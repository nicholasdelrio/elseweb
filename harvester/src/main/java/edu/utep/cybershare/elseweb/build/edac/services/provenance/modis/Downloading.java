package edu.utep.cybershare.elseweb.build.edac.services.provenance.modis;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.provenance.CommonResources;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.Date;
import edu.utep.cybershare.elseweb.ontology.DateRange;
import edu.utep.cybershare.elseweb.ontology.Download;
import edu.utep.cybershare.elseweb.ontology.DownloadedMODISDataset;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.FileManifestation;
import edu.utep.cybershare.elseweb.ontology.MODISDataset;
import edu.utep.cybershare.elseweb.xsd.Vocabulary;

public class Downloading {
	private static TimeZone mountainTimeZone = TimeZone.getTimeZone("America/Denver");
	
	private OWLDataFactory dataFactory;
	private Factory factory;
	private Inventory inventory;

	private ArrayList<DownloadedMODISDataset> downloadedDatasets;
	private DateRange duration;
	private DatasetManipulationSoftware downloader;
	private CommonResources resources;
	
	public Downloading(Factory factory, Inventory inventory, CommonResources resources){
		this.factory = factory;
		this.inventory = inventory;
		this.dataFactory = OWLManager.createOWLOntologyManager().getOWLDataFactory();
		this.resources = resources;
		downloadedDatasets = new ArrayList<DownloadedMODISDataset>();
		
		this.intializeCommonResources();
	}
	
	private void intializeCommonResources(){
		
		//start date
		Date startDate = factory.createDate(inventory.getRandomInstanceURI("date"));
		Calendar startDateCal = getDate(2010, 10, 01);
		startDate.addHasDateTime(getOWLLiteral(startDateCal));
		inventory.addToInventory(startDate);
		
		//end date
		Date endDate = factory.createDate("date");
		Calendar endDateCal = getDate(2011, 10, 20);
		endDate.addHasDateTime(getOWLLiteral(endDateCal));
		inventory.addToInventory(endDate);
		
		//the dataset's date range
		duration = factory.createDateRange(inventory.getRandomInstanceURI("duration"));
		duration.addHasStartDate(startDate);
		duration.addHasEndDate(endDate);
		inventory.addToInventory(duration);
		
		//downloader
		downloader = factory.createDatasetManipulationSoftware("http://gstore.unm.edu/elseweb/curl");
	}
	
	public void download(URL downloadURL){
		//create remote and locally downloaded datasets
		MODISDataset modisDataset = this.buildMODISDataset(downloadURL);
		DownloadedMODISDataset downloadedMODISDataset = this.buildDownloadedMODISDataset(modisDataset);
		
		//attach via the download activity
		associateWithDownload(modisDataset, downloadedMODISDataset);
		

		this.downloadedDatasets.add(downloadedMODISDataset);		
	}
	
	private MODISDataset buildMODISDataset(URL url){		
		//the dataset's manifestation
		FileManifestation manif = factory.createFileManifestation(url.toString() + "-data-manifestation");
		manif.addEncodedInFormat(resources.getHDF5());
		manif.addHasFileDownloadURL(getOWLLiteral(url));
		inventory.addToInventory(manif);
		
		//the dataset
		MODISDataset dataset = factory.createMODISDataset(url.toString() + "-dataset");
		dataset.addHasManifestation(manif);		
		dataset.addCoversRegion(resources.getRegion());
		dataset.addCoversTimePeriod(duration);
		dataset.addHasGeospatialProjection(resources.getWSG84Projection());
		inventory.addToInventory(dataset);
		
		return dataset;
	}
	
	private OWLLiteral getOWLLiteral(URL url){
		OWLDatatype anyURI = Vocabulary.DATA_TYPE_ANYURI;
		
		OWLLiteral anyURILiteral = dataFactory.getOWLLiteral(url.toString(), anyURI);
		return anyURILiteral;
	}
	
	private OWLLiteral getOWLLiteral(Calendar date){
		OWLDatatype dateTime = Vocabulary.DATA_TYPE_DATETIME;
		OWLLiteral dateTimeLiteral = dataFactory.getOWLLiteral(DatatypeConverter.printDateTime(date), dateTime);
		return dateTimeLiteral;
	}
	
	private DownloadedMODISDataset buildDownloadedMODISDataset(MODISDataset modisDataset){
		FileManifestation manif = factory.createFileManifestation(modisDataset.getHasManifestation().iterator().next().getOwlIndividual().getIRI().toString() + "-downloaded");
		manif.addEncodedInFormat(resources.getHDF5());
		inventory.addToInventory(manif);
		
		DownloadedMODISDataset dataset = factory.createDownloadedMODISDataset(modisDataset.getOwlIndividual().getIRI().toString() + "-downloaded");
		dataset.addHasManifestation(manif);
		dataset.addCoversRegion(modisDataset.getCoversRegion().iterator().next());
		dataset.addCoversTimePeriod(modisDataset.getCoversTimePeriod().iterator().next());
		dataset.addHasGeospatialProjection(modisDataset.getHasGeospatialProjection().iterator().next());
		inventory.addToInventory(dataset);
		
		return dataset;
	}
	
	public List<DownloadedMODISDataset> getDownloadedMODISDatasets(){
		return this.downloadedDatasets;
	}
	
	private void associateWithDownload(MODISDataset input, DownloadedMODISDataset output){
		Download downloadActivity = factory.createDownload(inventory.getRandomInstanceURI("download"));
		downloadActivity.addHadInput(input);
		downloadActivity.addWasAssociatedWith(downloader);
		inventory.addToInventory(downloadActivity);
		
		output.addWasOutputBy(downloadActivity);
	}
	
	private static Calendar getDate(int year, int month, int day){

		GregorianCalendar date = new GregorianCalendar();
		date.clear();
		date.set(year, month, day, 0, 0, 0);
		date.setTimeZone(mountainTimeZone);
		
		return date;
	}
}
