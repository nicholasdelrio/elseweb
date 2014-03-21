package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;

import java.util.HashMap;

import org.semanticweb.owlapi.model.OWLClass;

public class OBOEOntClassMapper {
	
	private static HashMap<String, OWLClass> themekeyToCharacteristic = new HashMap<String, OWLClass>();
	private static HashMap<String, OWLClass> themekeyToEntity = new HashMap<String, OWLClass>();
	
	public OBOEOntClassMapper(ELSEWEB edac, OBOE oboe){
		populateCharacteristicMappings(oboe);
		populateEntityMappings(edac);
	}
	
	private void populateEntityMappings(ELSEWEB edacVocab){
		themekeyToEntity.put("dew_point_temperature", edacVocab.getOWLClass_DewPoint());
		themekeyToEntity.put("precipitation_amount", edacVocab.getOWLClass_Precipitation());
		themekeyToEntity.put("air_temperature", edacVocab.getOWLClass_Air());
		themekeyToEntity.put("LAND SURFACE TEMPERATURE", edacVocab.getOWLClass_SurfaceLayer());
		themekeyToEntity.put("VEGETATION INDEX", edacVocab.getOWLClass_VegetationIndex());
	}
	
	private void populateCharacteristicMappings(OBOE oboeVocab){
		themekeyToCharacteristic.put("dew_point_temperature", oboeVocab.getOWLClass_Temperature());
		themekeyToCharacteristic.put("precipitation_amount", oboeVocab.getOWLClass_Amount());
		themekeyToCharacteristic.put("air_temperature", oboeVocab.getOWLClass_Temperature());
		themekeyToCharacteristic.put("LAND SURFACE TEMPERATURE", oboeVocab.getOWLClass_Temperature());
		themekeyToCharacteristic.put("VEGETATION INDEX", oboeVocab.getOWLClass_Amount());
	}

	public OWLClass getCharacteristicOntClass(String themekey){
		return themekeyToCharacteristic.get(themekey);
	}	
	public OWLClass getEntityOntClass(String themekey){
		return themekeyToEntity.get(themekey);
	}
}
