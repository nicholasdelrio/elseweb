package edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageDistribution;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;

public class WCSCoverageDistributionAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WCSCoverageDistribution distribution;
	public WCSCoverageDistributionAxioms(WCSCoverageDistribution distribution, OWLIndividual individual, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.distribution = distribution;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addTypeAxiom(vocabulary_ELSEWEB.getOWLClass_WCSCoverageDistribution());
		addAccessURI();
		addDownloadURI();
		addFormat();
		//mediatype
	}
	private void addAccessURI(){
		if(distribution.isSet_accessURI()){
			OWLLiteral accessLiteral = bundle.getDataFactory().getOWLLiteral(distribution.getAccessURI().toASCIIString());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_DCAT.getDatatypeProperty_accessURL(), individual, accessLiteral);
			add(axiom);
		}
	}
	private void addDownloadURI(){
		if(distribution.isSet_downloadURI()){
			OWLLiteral downloadLiteral = bundle.getDataFactory().getOWLLiteral(distribution.getDownloadURI().toASCIIString());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_DCAT.getDatatypeProperty_downloadURL(), individual, downloadLiteral);
			add(axiom);
		}
	}
	private void addFormat(){
		if(distribution.isSet_format()){
			OWLIndividual formatIndividual = Individuals.getIndividual(distribution.getFormat(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_DCMI.getObjectProperty_format(), individual, formatIndividual);
			add(axiom);
		}
	}
}