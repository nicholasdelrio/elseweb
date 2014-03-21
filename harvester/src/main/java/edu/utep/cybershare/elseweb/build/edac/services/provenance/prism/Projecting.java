package edu.utep.cybershare.elseweb.build.edac.services.provenance.prism;


import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.provenance.CommonResources;
import edu.utep.cybershare.elseweb.ontology.Amount;
import edu.utep.cybershare.elseweb.ontology.BandIdentification;
import edu.utep.cybershare.elseweb.ontology.ConvertedDataset;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.FileManifestation;
import edu.utep.cybershare.elseweb.ontology.Precipitation;
import edu.utep.cybershare.elseweb.ontology.RGISDataBand;
import edu.utep.cybershare.elseweb.ontology.Reproject;
import edu.utep.cybershare.elseweb.ontology.ReprojectedDataset;
;

public class Projecting {
	private Factory factory;
	private Inventory inventory;
	private ReprojectedDataset dataset;
	private DatasetManipulationSoftware reprojector;
	private CommonResources resources;
	public Projecting(Factory factory, Inventory inventory, CommonResources resources){
		this.factory = factory;
		this.inventory = inventory;
		this.resources = resources;
		initializeCommonResources();
	}
	
	private void initializeCommonResources(){
		reprojector = factory.createDatasetManipulationSoftware("http://gstore.unm.edu/elseweb/gdalwarp");
		inventory.addToInventory(reprojector);
	}
	public void reproject(ConvertedDataset convertedDataset){
		//the manifestation of the extracted dataset
		FileManifestation manif = factory.createFileManifestation(inventory.getRandomInstanceURI("projected-dataset-manifestation"));
		manif.addEncodedInFormat(resources.getTIFF());
		inventory.addToInventory(manif);
		
		//the band ID of the dataset's band
		BandIdentification bandID = factory.createBandIdentification(inventory.getRandomInstanceURI("band-id"));
		bandID.addHasBandName("Some Band ID");
		inventory.addToInventory(bandID);
		
		//the entity of the dataset
		Precipitation precipitationEntity = factory.createPrecipitation(inventory.getRandomInstanceURI("precipitation"));
		inventory.addToInventory(precipitationEntity);
		
		//the characteristic of the dataset
		Amount amountCharacteristic = factory.createAmount(inventory.getRandomInstanceURI("amount"));
		inventory.addToInventory(amountCharacteristic);
		
		//the databand
		RGISDataBand band = factory.createRGISDataBand(inventory.getRandomInstanceURI("band"));
		band.addHasBandIdentification(bandID);
		band.addRepresentsEntity(precipitationEntity);
		band.addEncodingOfCharacteristic(amountCharacteristic);
		inventory.addToInventory(band);
		
		dataset = factory.createReprojectedDataset(inventory.getRandomInstanceURI("reprojected-dataset"));
		dataset.addHasManifestation(manif);
		dataset.addHasDataBand(band);
		dataset.addCoversRegion(convertedDataset.getCoversRegion().iterator().next());
		dataset.addCoversTimePeriod(convertedDataset.getCoversTimePeriod().iterator().next());
		dataset.addHasGeospatialProjection(convertedDataset.getHasGeospatialProjection().iterator().next());
		inventory.addToInventory(dataset);
		
		Reproject reproject = factory.createReproject(inventory.getRandomInstanceURI("reproject"));
		reproject.addWasAssociatedWith(reprojector);
		inventory.addToInventory(reproject);
		
			
		reproject.addHadInput(convertedDataset);
		dataset.addWasOutputBy(reproject);
	}
	
	public ReprojectedDataset getReprojectedDataset(){return this.dataset;}
}
