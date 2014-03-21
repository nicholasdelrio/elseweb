package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Species;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.Axioms;

public class SpeciesAxioms extends Axioms {

	private Species species;
	
	public SpeciesAxioms(OWLIndividual individual, Species species, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.species = species;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_Species());
		
		addCanonicalName();
		
	}
	
	private void addCanonicalName(){
		if(species.isSet_canonicalName()){
			OWLLiteral nameLiteral = bundle.getDataFactory().getOWLLiteral(species.getCanonicalName());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasGenusName(), individual, nameLiteral);
			add(axiom);
		}
	}	
}
