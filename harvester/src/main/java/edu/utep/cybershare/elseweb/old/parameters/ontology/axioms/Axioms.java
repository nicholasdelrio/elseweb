package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import java.util.ArrayList;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary.ELSEWebLifemapper;
import edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary.ELSEWebModelling;
import edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary.XSD;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;


public abstract class Axioms extends ArrayList<OWLAxiom> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected OntologyToolset bundle;	
	protected OWLIndividual individual;
	
	protected ELSEWebLifemapper vocabulary_Lifemapper;
	protected ELSEWebModelling vocabulary_Modelling;
	protected XSD vocabulary_XSD;
		
	protected Axioms(OWLIndividual individual, OntologyToolset bundle){
		this.individual = individual;
		this.bundle = bundle;
		initializeVocabularies();
	}
	
	private void initializeVocabularies(){
		vocabulary_Lifemapper = new ELSEWebLifemapper(bundle);
		vocabulary_Modelling = new ELSEWebModelling(bundle);
		vocabulary_XSD = new XSD(bundle);
	}
		
	protected void addTypeAxiom(OWLClass owlClass){
		OWLClassAssertionAxiom classAssertionAxiom = bundle.getDataFactory().getOWLClassAssertionAxiom(owlClass, individual);
		add(classAssertionAxiom);
	}	
	
	public abstract void setAxioms();

}
