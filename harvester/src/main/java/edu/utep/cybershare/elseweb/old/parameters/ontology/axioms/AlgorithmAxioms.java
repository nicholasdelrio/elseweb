package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.parameters.model.Algorithm;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;

public class AlgorithmAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Algorithm algorithm;
	
	public AlgorithmAxioms(OWLIndividual individual, Algorithm algorithm, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.algorithm = algorithm;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_LifemapperAlgorithm());
		
		addCode();
		addName();
	}
	
	private void addCode(){
		if(algorithm.isSet_code()){
			OWLLiteral codeLiteral = bundle.getDataFactory().getOWLLiteral(algorithm.getCode());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasAlgorithmCode(), individual, codeLiteral);
			add(axiom);
		}
	}

	private void addName(){
		if(algorithm.isSet_name()){
			OWLLiteral nameLiteral = bundle.getDataFactory().getOWLLiteral(algorithm.getName());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Modelling.getDataProperty_hasAlgorithmName(), individual, nameLiteral);
			add(axiom);
		}
	}	
}
