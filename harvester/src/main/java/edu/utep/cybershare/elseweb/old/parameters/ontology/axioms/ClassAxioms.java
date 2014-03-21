package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import java.util.ArrayList;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

import edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary.ELSEWebLifemapper;
import edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary.ELSEWebModelling;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;


public abstract class ClassAxioms extends ArrayList<OWLAxiom> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected OntologyToolset bundle;	
	protected OWLClass owlClass;
	
	protected ELSEWebLifemapper vocabulary_Lifemapper;
	protected ELSEWebModelling vocabulary_Modelling;
		
	protected ClassAxioms(OWLClass owlClass, OntologyToolset bundle){
		this.owlClass = owlClass;
		this.bundle = bundle;
		initializeVocabularies();
	}
	
	private void initializeVocabularies(){
		vocabulary_Lifemapper = new ELSEWebLifemapper(bundle);
		vocabulary_Modelling = new ELSEWebModelling(bundle);
	}
	
	protected void addEquivalentClassAxiom(OWLClassExpression classExpression){
		OWLEquivalentClassesAxiom axiom = bundle.getDataFactory().getOWLEquivalentClassesAxiom(owlClass, classExpression);
		add(axiom);
	}
	
	protected void addSubClassOfAxiom(OWLClass superClass){
		OWLSubClassOfAxiom axiom = bundle.getDataFactory().getOWLSubClassOfAxiom(owlClass, superClass);		
		add(axiom);
	}
	
	public abstract void setAxioms();
}
