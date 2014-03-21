package edu.utep.cybershare.elseweb.build.edac.services.provenance.modis;

import java.util.ArrayList;
import java.util.List;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.provenance.CommonResources;
import edu.utep.cybershare.elseweb.ontology.BandIdentification;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.DownloadedMODISDataset;
import edu.utep.cybershare.elseweb.ontology.ExtractAndReproject;
import edu.utep.cybershare.elseweb.ontology.ExtractedDataset;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.FileManifestation;
import edu.utep.cybershare.elseweb.ontology.Index;
import edu.utep.cybershare.elseweb.ontology.RGISDataBand;
import edu.utep.cybershare.elseweb.ontology.Vegetation;


public class Extracting {
	private Factory factory;
	private Inventory inventory;
	private DatasetManipulationSoftware extractor;

	private ArrayList<ExtractedDataset> extractedDatasets;
	private CommonResources resources;
	public Extracting(Factory factory, Inventory inventory, CommonResources resources){
		this.factory = factory;
		this.inventory = inventory;
		this.resources = resources;
		extractedDatasets = new ArrayList<ExtractedDataset>();
		
		initializeCommonResources();
	}
	
	private void initializeCommonResources(){		
		extractor = factory.createDatasetManipulationSoftware("http://gstore.unm.edu/elseweb/gdalwarp");
		inventory.addToInventory(extractor);
	}
	
	public void extract(List<DownloadedMODISDataset> datasets){
		ExtractedDataset extractedDataset;
		for(DownloadedMODISDataset dataset: datasets){
			extractedDataset = this.buildExtractedDataset(dataset);
			this.associateWithExtract(dataset, extractedDataset);
			this.extractedDatasets.add(extractedDataset);
		}
	}
	
	private ExtractedDataset buildExtractedDataset(DownloadedMODISDataset downloadedDataset){
		//the manifestation of the extracted dataset
		FileManifestation manif = factory.createFileManifestation(downloadedDataset.getHasManifestation().iterator().next().getOwlIndividual().getIRI().toString() + "-extracted");
		manif.addEncodedInFormat(resources.getTIFF());
		inventory.addToInventory(manif);
		
		//the band ID of the dataset's band
		BandIdentification bandID = factory.createBandIdentification(inventory.getRandomInstanceURI("band-id"));
		bandID.addHasBandName("MODIS_Grid_16DAY_250m_500m_VI:250m 16 days EVI");
		inventory.addToInventory(bandID);
		
		//the entity of the dataset
		Vegetation vegetationEntity = factory.createVegetation(inventory.getRandomInstanceURI("vegetation"));
		inventory.addToInventory(vegetationEntity);
		
		//the characteristic of the dataset
		Index indexCharacteristic = factory.createIndex(inventory.getRandomInstanceURI("index"));
		inventory.addToInventory(indexCharacteristic);
		
		//the databand
		RGISDataBand band = factory.createRGISDataBand(inventory.getRandomInstanceURI("band"));
		band.addHasBandIdentification(bandID);
		band.addRepresentsEntity(vegetationEntity);
		band.addEncodingOfCharacteristic(indexCharacteristic);
		inventory.addToInventory(band);
				
		//the extracted dataset
		ExtractedDataset dataset = factory.createExtractedDataset(downloadedDataset.getOwlIndividual().getIRI().toString() + "-extracted");
		dataset.addHasManifestation(manif);
		dataset.addHasDataBand(band);
		dataset.addCoversRegion(downloadedDataset.getCoversRegion().iterator().next());
		dataset.addCoversTimePeriod(downloadedDataset.getCoversTimePeriod().iterator().next());
		dataset.addHasGeospatialProjection(downloadedDataset.getHasGeospatialProjection().iterator().next());
		inventory.addToInventory(dataset);
		return dataset;
	}
	
	private void associateWithExtract(DownloadedMODISDataset input, ExtractedDataset output){
		String name = inventory.getRandomInstanceURI("extract");
		ExtractAndReproject extract = factory.createExtractAndReproject(name);
		extract.addHadInputBandID(output.getHasDataBand().iterator().next().getHasBandIdentification().iterator().next());
		extract.addWasAssociatedWith(extractor);
		inventory.addToInventory(extract);
		
		extract.addHadInput(input);
		output.addWasOutputBy(extract);
	}
	
	public List<ExtractedDataset> getExtractedDatasets(){return this.extractedDatasets;}
}
