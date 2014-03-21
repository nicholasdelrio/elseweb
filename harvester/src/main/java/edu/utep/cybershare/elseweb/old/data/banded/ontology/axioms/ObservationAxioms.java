package edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.banded.model.Observation;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;

public class ObservationAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Observation obs;
	public ObservationAxioms(Observation obs, OWLIndividual individual, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.obs = obs;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		
		this.addTypeAxiom(vocabulary_OBOE.getOWLClass_Observation());
		
		addEntity();
	}
	
	private void addEntity(){
		if(obs.isSet_entity()){
			OWLIndividual entityIndividual = Individuals.getIndividual(obs.getEntity(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_OBOE.getObjectProperty_ofEntity(), individual, entityIndividual);
			add(axiom);
		}
	}
}
