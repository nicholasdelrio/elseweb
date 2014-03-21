package edu.utep.cybershare.elseweb.old.data.occurrences.build;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Dataset;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Layer;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Manifestation;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Projection;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Region;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Species;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.SpeciesOccurrenceSet;


public class Builder {
	
	private static final String regionLabel = "region";
	private static final String separator = "_";
	
	private URI shapefileFormatURI;	
	private HashMap<String, String> regionEncodingToRegionName;
	private int regionCounter;
	
	private Region region;
	private Dataset dataset;
	private Layer layer;
	
	private ModelProduct product;

	public Builder(ModelProduct product){
		this.product = product;
		regionCounter = 0;
		regionEncodingToRegionName = new HashMap<String, String>();
		try{
			this.shapefileFormatURI = new URI("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#esri-shapefile");
		}catch(Exception e){e.printStackTrace();}
		
		reset();
	}
	
	private void reset(){
		region = null;
		dataset = null;
		layer = null;
	}

	
	public void buildSpeciesOccurrenceLayer(int occurrenceSetID, int numberOfOccurrences, String speciesName){
		//build species instance
		Species species = product.getSpecies(speciesName);
		species.setCanonicalName(speciesName);
		
		//build occurrence set
		String occurrenceSetName =  "occurrence-set-" + occurrenceSetID;
		SpeciesOccurrenceSet set = product.getSpeciesOccurrenceSet(occurrenceSetName);
		set.setOccurrenceSetID(occurrenceSetID);
		set.setSpecies(species);
		set.setNumberOfOccurrences(numberOfOccurrences);
		
		//finally, build feature layer
		String occurrenceLayerName = "-ocurrence-layer-" + occurrenceSetID;
		layer = product.getLayer(occurrenceLayerName);
		layer.setOccurrenceSet(set);
	}
	
	public void buildRegion(double llon, double rlon, double llat, double ulat){
		String regionKey = getRegionKey(llon, rlon, llat, ulat);
		region = product.getRegion(regionKey);
		region.setLlon(llon);
		region.setRlon(rlon);
		region.setLlat(llat);
		region.setUlat(ulat);
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
	
	public void buildDataset(String speciesName, int epsgCode, URL metadataURL){
		String datasetName = speciesName + "-dataset";
		dataset = product.getDataset(datasetName);
		dataset.addLayer(layer);

		//build manifestation
		Manifestation manifestation = product.getManifestation(datasetName + "-manifestation");
		manifestation.setFormatURI(this.shapefileFormatURI);
		manifestation.setLandingPageURL(metadataURL);
		try{
			URL url = new URL(metadataURL + "/shapefile");
			manifestation.setFileDownloadURL(url);
		}catch(Exception e){e.printStackTrace();}
		dataset.setManifestation(manifestation);
		
		//build projection
		Projection projection = product.getProjection(epsgCode + "-projection");
		projection.setEpsgCode(epsgCode);
		
		dataset.setProjection(projection);
	}
	
	public void assemble(){
		this.reset();
	}
}
