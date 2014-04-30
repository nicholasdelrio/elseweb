package edu.utep.cybershare.elseweb.build.edac.services;

import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.source.edac.fgdc.theme.Theme;
import edu.utep.cybershare.elseweb.ontology.BoxedGeographicRegion;
import edu.utep.cybershare.elseweb.ontology.Date;
import edu.utep.cybershare.elseweb.ontology.DateRange;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.MODISMeasurement;
import edu.utep.cybershare.elseweb.ontology.ModellingAgent;
import edu.utep.cybershare.elseweb.ontology.PRISMModelling;
import edu.utep.cybershare.elseweb.ontology.Projection;
import edu.utep.cybershare.elseweb.ontology.RGISCharacteristic;
import edu.utep.cybershare.elseweb.ontology.RGISDataBand;
import edu.utep.cybershare.elseweb.ontology.RGISEntity;
import edu.utep.cybershare.elseweb.ontology.RGISWCSDataset;
import edu.utep.cybershare.elseweb.ontology.RGISWCSManifestation;
import edu.utep.cybershare.elseweb.ontology.Sensor;
import edu.utep.cybershare.elseweb.xsd.Vocabulary;

public class Builder {
	
	private static final String datasetLabel = "dataset";
	private static final String durationLabel = "duration";
	private static final String bandLabel = "band";
	private static final String regionLabel = "region";
	private static final String manifestationLabel = "manifestation";
	private static final String separator = "_";

	//uniqe band related components
	private RGISCharacteristic characteristic;
	private RGISEntity entity;
	private RGISDataBand band;
	
	//unique service components
	private int baseID;
	private RGISWCSDataset service;	
	private BoxedGeographicRegion region;
	private DateRange duration;
	
	//static components
	private Projection projection;		
	private ModellingAgent modellingAgent;
	private Sensor sensorAgent;
	
	private HashMap<String, String> regionEncodingToRegionName;
	private HashMap<String, String> durationEncodingToDurationName;
	
	private int regionCounter;
	private int durationCounter;
	
	private DataBandAttributeMapper mapper;
	
	private Factory factory;
	private OWLDataFactory dataFactory;
	
	private Inventory inventory;
	
	public Builder(Factory factory, Inventory inventory){
		this.factory = factory;
		this.inventory = inventory;
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		this.dataFactory = ontologyManager.getOWLDataFactory();
		
		regionEncodingToRegionName = new HashMap<String,String>();
		durationEncodingToDurationName = new HashMap<String,String>();
		mapper = new DataBandAttributeMapper(factory, inventory);
		regionCounter = 0;
		durationCounter = 0;
		setProjection();
		setSensorAgent();
		setModellingAgent();
		
		reset();
	}
	
	private void reset(){
		characteristic = null;
		service = null;
		entity = null;
		region = null;
		duration = null;
		band = null;
		baseID = -1;
	}
	
	private void setProjection(){
		projection = factory.createProjection(inventory.getInstanceURI("4326-projection"));
		projection.addHasEPSGCode(4326);
	}
	
	private void setSensorAgent(){
		this.sensorAgent = factory.createSensor(inventory.getInstanceURI("MODIS"));
		this.sensorAgent.addHasProcessorName("moderate resolution imaging spectroradiometer");
	}
	
	private void setModellingAgent(){
		this.modellingAgent = factory.createModellingAgent(inventory.getInstanceURI("PRISM"));
		this.modellingAgent.addHasProcessorName("PRISM Climate Group");
	}
	
	public void setBaseID(int id){
		baseID = id;
	}
	
	private String appendDatasetID(String label){
		return label + separator + baseID;
	}
	
	public void buildCharacteristic(String themekey){
		characteristic = mapper.getCharacteristic(themekey);
	}

	public void buildService(Theme theme, URL capabilitiesURL, URL jsonURL){
		String qualifiedLabel = appendDatasetID(datasetLabel);
		String uri = inventory.getInstanceURI(qualifiedLabel);
		
		if(isPRISM(theme))
			service = factory.createPublishedPRISMDataset(uri);
		else
			service = factory.createPublishedMODISDataset(uri);

		//build manifestation
		RGISWCSManifestation manifestation = factory.createRGISWCSManifestation(uri + "-" + manifestationLabel);
				
		manifestation.addHasCapabilitiesDocumentURL(capabilitiesURL.toString());
		manifestation.addhasJSONCapabilitiesDigestURL(jsonURL.toString());
		
		//build data band
		band = factory.createRGISDataBand(uri + bandLabel);

		if(isPRISM(theme)){
			PRISMModelling modellingActivity = factory.createPRISMModelling(uri + "-" + "modellingActivity");
			modellingActivity.addWasAssociatedWith(this.modellingAgent);
			band.addWasModelledBy(modellingActivity);
		}
		else{
			MODISMeasurement measurementActivity = factory.createMODISMeasurement(uri + "-" + "measurementActivity");
			measurementActivity.addWasAssociatedWith(this.sensorAgent);
			band.addWasMeasuredBy(measurementActivity);			
		}
		
		service.addHasDataBand(band);
		service.addHasManifestation(manifestation);
		service.addHasGeospatialProjection(projection);
	}
	
	
	public void buildEntity(String themekey){
		entity = mapper.getEntity(themekey);
	}
	
	public void buildRegion(double llon, double rlon, double llat, double ulat){
		String regionKey = this.getRegionKey(llon, rlon, llat, ulat);
		String uri = inventory.getInstanceURI(regionKey);
		region = factory.createBoxedGeographicRegion(uri);
		region.addHasLeftLongitude(getOWLLiteral(llon));
		region.addHasRightLongitude(getOWLLiteral(rlon));
		region.addHasLowerLatitude(getOWLLiteral(llat));
		region.addHasUpperLatitude(getOWLLiteral(ulat));
	}
	
	public void buildDuration(Calendar startDate, Calendar endDate){
		String durationKey = this.getDurationKey(startDate, endDate);
		String uri = inventory.getInstanceURI(durationKey);

		Date sDate = factory.createDate(uri + "-sdate");
		sDate.addHasDateTime(getOWLLiteral(startDate));
		
		Date eDate = factory.createDate(uri + "-edate");
		eDate.addHasDateTime(getOWLLiteral(endDate));

		duration = factory.createDateRange(uri);
		duration.addHasStartDate(sDate);
		duration.addHasEndDate(eDate);
	}
		
	private boolean isPRISM(Theme prismTheme){
		return prismTheme != null;
	}
	
	private String getRegionKey(double llon, double rlon, double llat, double ulat){
		String regionString = String.valueOf(llon) + String.valueOf(rlon) + String.valueOf(llat) + String.valueOf(ulat);
		String regionName = this.regionEncodingToRegionName.get(regionString);
		if(regionName == null){
			regionName = regionLabel + separator + regionCounter++;
			this.regionEncodingToRegionName.put(regionString, regionName);
		}
		return regionName;
	}
	
	private String getDurationKey(Calendar startDate, Calendar endDate){
		String durationString = startDate.toString() + endDate.toString();
		String durationName = this.durationEncodingToDurationName.get(durationString);
		if(durationName == null){
			durationName = durationLabel + separator + durationCounter++;
			this.durationEncodingToDurationName.put(durationString, durationName);
		}
		return durationName;
	}
	
	public void assemble(){
		//assemble band
		band.addEncodingOfCharacteristic(characteristic);
		band.addRepresentsEntity(entity);
		
		//assemble service
		service.addCoversRegion(region);
		service.addCoversTimePeriod(duration);
		service.addHasGeospatialProjection(projection);		
								
		reset();
	}
	
	/*
	private OWLLiteral getOWLLiteral(URL url){
		OWLDatatype anyURI = Vocabulary.DATA_TYPE_ANYURI;
		
		OWLLiteral anyURILiteral = dataFactory.getOWLLiteral(url.toString(), anyURI);
		return anyURILiteral;
	}*/
	
	private OWLLiteral getOWLLiteral(double value){
		OWLLiteral doubleLiteral = dataFactory.getOWLLiteral(value);
		return doubleLiteral;
	}
	
	private OWLLiteral getOWLLiteral(Calendar date){
		OWLDatatype dateTime = Vocabulary.DATA_TYPE_DATETIME;
		OWLLiteral dateTimeLiteral = dataFactory.getOWLLiteral(DatatypeConverter.printDateTime(date), dateTime);
		return dateTimeLiteral;
	}
}