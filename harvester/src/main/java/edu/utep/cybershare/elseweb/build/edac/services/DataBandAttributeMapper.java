package edu.utep.cybershare.elseweb.build.edac.services;

import java.util.HashMap;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.ontology.Air;
import edu.utep.cybershare.elseweb.ontology.Amount;
import edu.utep.cybershare.elseweb.ontology.DewPointTemperature;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.Index;
import edu.utep.cybershare.elseweb.ontology.RGISCharacteristic;
import edu.utep.cybershare.elseweb.ontology.RGISEntity;
import edu.utep.cybershare.elseweb.ontology.SurfaceLayer;
import edu.utep.cybershare.elseweb.ontology.Temperature;
import edu.utep.cybershare.elseweb.ontology.Vegetation;

public class DataBandAttributeMapper {
	
	private HashMap<String, RGISCharacteristic> themekeyToCharacteristic = new HashMap<String, RGISCharacteristic>();
	private HashMap<String, RGISEntity> themekeyToEntity = new HashMap<String, RGISEntity>();
	private Factory factory;
	private Inventory inventory;
	
	public DataBandAttributeMapper(Factory factory, Inventory inventory){
		this.factory = factory;
		this.inventory = inventory;
		populateEntityMappings();
		populateCharacteristicMappings();
	}
	
	private void populateEntityMappings(){
		String airURI = inventory.getInstanceURI("air");
		String vegetationURI = inventory.getInstanceURI("vegetation");
		String surfaceLayerURI = inventory.getInstanceURI("surface-layer");
		
		Air air = factory.createAir(airURI);
		SurfaceLayer surfaceLayer = factory.createSurfaceLayer(surfaceLayerURI);
		Vegetation vegetation = factory.createVegetation(vegetationURI);
		
		themekeyToEntity.put("dew_point_temperature", air);
		themekeyToEntity.put("precipitation_amount", surfaceLayer);
		themekeyToEntity.put("air_temperature", air);
		themekeyToEntity.put("LAND SURFACE TEMPERATURE", surfaceLayer);
		themekeyToEntity.put("VEGETATION INDEX", vegetation);
	}
	
	private void populateCharacteristicMappings(){
		String dewpointURI = inventory.getInstanceURI("dew-point-temperature");
		String temperatureURI = inventory.getInstanceURI("temperature");
		String amountURI = inventory.getInstanceURI("amount");
		String indexURI = inventory.getInstanceURI("index");
		
		DewPointTemperature dewPointTemperature = factory.createDewPointTemperature(dewpointURI);
		Temperature temperature = factory.createTemperature(temperatureURI);
		Amount amount = factory.createAmount(amountURI);
		Index index = factory.createIndex(indexURI);
		
		themekeyToCharacteristic.put("dew_point_temperature", dewPointTemperature);
		themekeyToCharacteristic.put("precipitation_amount",amount);
		themekeyToCharacteristic.put("air_temperature", temperature);
		themekeyToCharacteristic.put("LAND SURFACE TEMPERATURE",temperature);
		themekeyToCharacteristic.put("VEGETATION INDEX",index);
	}

	public RGISCharacteristic getCharacteristic(String themekey){
		return themekeyToCharacteristic.get(themekey);
	}	
	public RGISEntity getEntity(String themekey){
		return themekeyToEntity.get(themekey);
	}
}
