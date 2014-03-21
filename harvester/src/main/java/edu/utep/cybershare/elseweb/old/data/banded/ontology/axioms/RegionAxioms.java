package edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms;


import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.data.banded.model.Region;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;

public class RegionAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Region region;
	public RegionAxioms(Region region, OWLIndividual individual, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.region = region;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addTypeAxiom(vocabulary_ELSEWEB.getOWLClass_Region());
		
		addLlon();
		addRlon();
		addLlat();
		addUlat();
	}
	
	private void addLlon(){
		if(region.isSet_llon()){
			OWLLiteral llonLiteral = bundle.getDataFactory().getOWLLiteral(region.getLlon());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_ELSEWEB.getDataProperty_hasLeftLongitude(), individual, llonLiteral);
			add(axiom);
		}
	}
	
	private void addRlon(){
		if(region.isSet_rlon()){
			OWLLiteral rlonLiteral = bundle.getDataFactory().getOWLLiteral(region.getRlon());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_ELSEWEB.getDataProperty_hasRightLongitude(), individual, rlonLiteral);
			add(axiom);
		}
	}
	
	private void addLlat(){
		if(region.isSet_llat()){
			OWLLiteral llatLiteral = bundle.getDataFactory().getOWLLiteral(region.getLlat());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_ELSEWEB.getDataProperty_hasLowerLatitude(), individual, llatLiteral);
			add(axiom);
		}
	}
	private void addUlat(){
		if(region.isSet_ulat()){
			OWLLiteral ulatLiteral = bundle.getDataFactory().getOWLLiteral(region.getUlat());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_ELSEWEB.getDataProperty_hasUpperLatitude(), individual, ulatLiteral);
			add(axiom);
		}
	}
}
