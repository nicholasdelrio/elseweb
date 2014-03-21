package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Layer;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.Axioms;

public class LayerAxioms extends Axioms {

	private Layer layer;
	
	public LayerAxioms(OWLIndividual individual, Layer layer, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.layer = layer;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_SpeciesOccurrenceLayer());
		
		addOccurrenceSet();
		
	}
	
	private void addOccurrenceSet(){
		if(layer.isSet_occurrenceSet()){
			OWLIndividual setIndividual = Individuals.getIndividual(layer.getOccurrenceSet(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_containsFeatureSet(), individual, setIndividual);
			add(axiom);
		}
	}	
}
