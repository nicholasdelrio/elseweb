package edu.utep.cybershare.elseweb.build.edac.services.provenance.prism;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.provenance.CommonResources;
import edu.utep.cybershare.elseweb.ontology.Amount;
import edu.utep.cybershare.elseweb.ontology.BandIdentification;
import edu.utep.cybershare.elseweb.ontology.ConvertASCIIToTIFF;
import edu.utep.cybershare.elseweb.ontology.ConvertedDataset;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.DownloadedPRISMDataset;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.FileManifestation;
import edu.utep.cybershare.elseweb.ontology.Precipitation;
import edu.utep.cybershare.elseweb.ontology.RGISDataBand;

public class Converting {
	private Factory factory;
	private Inventory inventory;
	private DatasetManipulationSoftware converter;
	private CommonResources resources;
	private ConvertedDataset convertedDataset;
	
	public Converting(Factory factory, Inventory inventory, CommonResources resources){
		this.factory = factory;
		this.inventory = inventory;
		this.resources = resources;
		initializeCommonResources();
	}
	
	private void initializeCommonResources(){
		converter = factory.createDatasetManipulationSoftware("http://gstore.unm.edu/elseweb/gdal_translate");
		inventory.addToInventory(converter);
	}
	
	public void convert(DownloadedPRISMDataset dataset){
		ConvertedDataset extractedDataset = buildConvertedDataset(dataset);
		this.associateWithExtract(dataset, extractedDataset);
	}
	
	private ConvertedDataset buildConvertedDataset(DownloadedPRISMDataset downloadedDataset){
		
		//the manifestation of the extracted dataset
		FileManifestation manif = factory.createFileManifestation(downloadedDataset.getHasManifestation().iterator().next().getOwlIndividual().getIRI().toString() + "-converted");
		manif.addEncodedInFormat(resources.getTIFF());
		inventory.addToInventory(manif);
		
		//the band ID of the dataset's band
		BandIdentification bandID = factory.createBandIdentification(inventory.getRandomInstanceURI("band-id"));
		bandID.addHasBandName("Some Band Name - Can be fake or placeholder");
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
				
		//the converted dataset
		convertedDataset = factory.createConvertedDataset(downloadedDataset.getOwlIndividual().getIRI().toString() + "-extracted");
		convertedDataset.addHasManifestation(manif);
		convertedDataset.addHasDataBand(band);
		convertedDataset.addCoversRegion(downloadedDataset.getCoversRegion().iterator().next());
		convertedDataset.addCoversTimePeriod(downloadedDataset.getCoversTimePeriod().iterator().next());
		convertedDataset.addHasGeospatialProjection(downloadedDataset.getHasGeospatialProjection().iterator().next());
		inventory.addToInventory(convertedDataset);
		return convertedDataset;
	}
	
	private void associateWithExtract(DownloadedPRISMDataset input, ConvertedDataset output){
		String name = inventory.getRandomInstanceURI("convert");
		ConvertASCIIToTIFF convert = factory.createConvertASCIIToTIFF(name);
		convert.addWasAssociatedWith(converter);
		inventory.addToInventory(convert);
		
		convert.addHadInput(input);
		output.addWasOutputBy(convert);
	}
	
	public ConvertedDataset getConvertedDataset(){return this.convertedDataset;}
}
