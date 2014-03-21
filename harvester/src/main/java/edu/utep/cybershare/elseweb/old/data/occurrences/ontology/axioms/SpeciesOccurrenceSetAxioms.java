package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.SpeciesOccurrenceSet;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.Axioms;

public class SpeciesOccurrenceSetAxioms extends Axioms {

	private SpeciesOccurrenceSet speciesSet;
	
	public SpeciesOccurrenceSetAxioms(OWLIndividual individual, SpeciesOccurrenceSet speciesSet, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.speciesSet = speciesSet;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_SpeciesOccurrenceSet());
		
		addCount();
		addSpecies();
		addID();
	}
	
	private void addCount(){
		if(speciesSet.isSet_numberOfOccurrences()){
			OWLLiteral countLiteral = bundle.getDataFactory().getOWLLiteral(speciesSet.getNumberOfOccurrences());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasNumberOfOccurrences(), individual, countLiteral);
			add(axiom);
		}
	}
	
	private void addID(){
		if(speciesSet.isSet_occurrenceSetID()){
			OWLLiteral idLiteral = bundle.getDataFactory().getOWLLiteral(speciesSet.getOccurrenceSetID());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasOccurrenceSetID(), individual, idLiteral);
			add(axiom);
		}
	}
	
	private void addSpecies(){
		if(speciesSet.isSet_species()){
			OWLIndividual speciesInd = Individuals.getIndividual(speciesSet.getSpecies(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_Lifemapper.getObjectProperty_hasOccurrenceOfSpecies(), individual, speciesInd);
			add(axiom);
		}
	}
}
