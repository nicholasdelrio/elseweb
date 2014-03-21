package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;


/**
 * Observation Ontology for Environmental Science (OBOE)
 * <a href="https://semtools.ecoinformatics.org/oboe">https://semtools.ecoinformatics.org/oboe</a>
 * @author Nicholas Del Rio
 *
 */

public class OBOE extends Vocabulary {
	
	private static final String NAMESPACE = "http://ecoinformatics.org/oboe/oboe.1.0/oboe-core.owl";

	private static final String OWLClass_Observation = NAMESPACE + "#Observation";
	private static final String OWLClass_Measurement = NAMESPACE + "#Measurement";
	private static final String OWLClass_Entity = NAMESPACE + "#Entity";
	private static final String OWLClass_Characteristic = NAMESPACE + "#Characteristic";
	
	//Characteristic Classes
	private static final String OWLClass_Temperature = "http://ecoinformatics.org/oboe/oboe.1.0/oboe-characteristics.owl#Temperature";
	private static final String OWLClass_Amount = "http://ecoinformatics.org/oboe/oboe.1.0/oboe-characteristics.owl#Amount";

	//Entity Classes
	private static final String OWLClass_EcologicalCommunity = "http://ecoinformatics.org/oboe/oboe.1.0/oboe-ecology.owl#EcologicalCommunity";
	private static final String OWLClass_TerrestrialFeature = "http://ecoinformatics.org/oboe/oboe.1.0/oboe-environment.owl#TerrestrialFeature";
	private static final String OWLClass_AtmosphericFeature = "http://ecoinformatics.org/oboe/oboe.1.0/oboe-environment.owl#AtmosphericFeature";

	
	private static final String ObjectProperty_measurementFor = NAMESPACE + "#measurementFor";
	private static final String ObjectProperty_ofEntity = NAMESPACE + "#ofEntity";
	private static final String ObjectProperty_ofCharacteristic = NAMESPACE + "#ofCharacteristic";
	
	public OBOE(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
	
	public OWLClass getOWLClass_Observation(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Observation));}
	public OWLClass getOWLClass_Measurement(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Measurement));}
	public OWLClass getOWLClass_Entity(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Entity));}
	public OWLClass getOWLClass_Characteristic(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Characteristic));}
	public OWLClass getOWLClass_Temperature(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Temperature));}
	public OWLClass getOWLClass_Amount(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Amount));}
	public OWLClass getOWLClass_EcologicalCommunity(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_EcologicalCommunity));}
	public OWLClass getOWLClass_TerrestrialFeature(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_TerrestrialFeature));}
	public OWLClass getOWLClass_AtmosphericFeature(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_AtmosphericFeature));}
	
	public OWLObjectProperty getObjectProperty_measurementFor(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_measurementFor));}
	public OWLObjectProperty getObjectProperty_ofEntity(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_ofEntity));}
	public OWLObjectProperty getObjectProperty_ofCharacteristic(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_ofCharacteristic));}
}
