package edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms;


import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.banded.model.Measurement;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;

public class MeasurementAxioms extends Axioms{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Measurement measurement;
	public MeasurementAxioms(Measurement measurement, OWLIndividual individual, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.measurement = measurement;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addTypeAxiom(vocabulary_OBOE.getOWLClass_Measurement());
		this.addTypeAxiom(vocabulary_PROVO.getOntClass_Activity());
		
		addCharacteristic();
		addObservation();
		addAgent();
	}
	
	private void addAgent(){
		if(measurement.isSet_responsibleAgent()){
			OWLIndividual agentIndividual = Individuals.getIndividual(measurement.getResponsibleAgent(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_PROVO.getObjectProperty_wasAssociatedWith(), individual, agentIndividual);
			add(axiom);
		}
	}
	
	private void addCharacteristic(){
		if(measurement.isSet_charactersitc()){
			OWLIndividual charIndividual = Individuals.getIndividual(measurement.getCharacteristic(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_OBOE.getObjectProperty_ofCharacteristic(), individual, charIndividual);
			add(axiom);
		}
	}
	
	private void addObservation(){
		if(measurement.isSet_Observation()){
			OWLIndividual observationIndividual = Individuals.getIndividual(measurement.getObservation(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_OBOE.getObjectProperty_measurementFor(), individual, observationIndividual);
			add(axiom);
		}
	}
}
