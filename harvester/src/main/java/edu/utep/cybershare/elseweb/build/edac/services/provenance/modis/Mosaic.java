package edu.utep.cybershare.elseweb.build.edac.services.provenance.modis;

import java.util.List;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.provenance.CommonResources;
import edu.utep.cybershare.elseweb.ontology.BandIdentification;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.ExtractedDataset;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.FileManifestation;
import edu.utep.cybershare.elseweb.ontology.Index;
import edu.utep.cybershare.elseweb.ontology.MosaicDataset;
import edu.utep.cybershare.elseweb.ontology.RGISDataBand;
import edu.utep.cybershare.elseweb.ontology.Vegetation;

public class Mosaic {
	private Factory factory;
	private Inventory inventory;
	private MosaicDataset dataset;
	private DatasetManipulationSoftware merger;
	private CommonResources resources;
	
	public Mosaic(Factory factory, Inventory inventory, CommonResources resources){
		this.factory = factory;
		this.inventory = inventory;
		this.resources = resources;
		initializeCommonResources();
	}
	
	private void initializeCommonResources(){
		merger = factory.createDatasetManipulationSoftware("http://gstore.unm.edu/elseweb/gdal_merge");
		inventory.addToInventory(merger);
	}
	public void mosaic(List<ExtractedDataset> datasets){
		//the manifestation of the extracted dataset
		FileManifestation manif = factory.createFileManifestation(inventory.getRandomInstanceURI("mosaic-dataset-manifestation"));
		manif.addEncodedInFormat(resources.getTIFF());
		inventory.addToInventory(manif);
		
		//the band ID of the dataset's band
		BandIdentification bandID = factory.createBandIdentification(inventory.getRandomInstanceURI("band-id"));
		bandID.addHasBandName("Some Band ID");
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
		
		dataset = factory.createMosaicDataset(inventory.getRandomInstanceURI("mosaic-dataset"));
		dataset.addHasManifestation(manif);
		dataset.addHasDataBand(band);
		inventory.addToInventory(dataset);
		
		edu.utep.cybershare.elseweb.ontology.Mosaic mosaic = factory.createMosaic(inventory.getRandomInstanceURI("mosaic"));
		mosaic.addWasAssociatedWith(merger);
		inventory.addToInventory(mosaic);
		
		ExtractedDataset extractedDataset;
		for(int i = 0; i < datasets.size(); i ++){
			extractedDataset = datasets.get(i);
			if(i == 0){
				dataset.addCoversRegion(extractedDataset.getCoversRegion().iterator().next());
				dataset.addCoversTimePeriod(extractedDataset.getCoversTimePeriod().iterator().next());
				dataset.addHasGeospatialProjection(extractedDataset.getHasGeospatialProjection().iterator().next());
			}
			
			mosaic.addHadInput(extractedDataset);
		}
		dataset.addWasOutputBy(mosaic);
	}
	
	public MosaicDataset getMosaicDataset(){return this.dataset;}
}
