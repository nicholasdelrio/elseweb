package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms;

import java.net.URISyntaxException;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Manifestation;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.Axioms;

public class ManifestationAxioms extends Axioms {

	private Manifestation manifestation;
	
	public ManifestationAxioms(OWLIndividual individual, Manifestation manifestation, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.manifestation = manifestation;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_data.getOWLClass_VectorFileManifestation());

		addFormat();
		
		try{
			addFileDownloadURL();
			addLandingPageURL();
		}catch(Exception e){e.printStackTrace();}
	}
	

	private void addLandingPageURL() throws URISyntaxException{
		if(manifestation.isSet_landingPageURL()){
			OWLIndividual lpURL = Individuals.getIndividual(manifestation.getLandingPageURL().toURI(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_hasLandingPageURL(), individual, lpURL);
			add(axiom);
		}
	}

	
	private void addFileDownloadURL() throws URISyntaxException{
		if(manifestation.isSet_fileDownloadURL()){
			OWLIndividual downloadURL = Individuals.getIndividual(manifestation.getFileDownloadURL().toURI(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_hasFileDownloadURL(), individual, downloadURL);
			add(axiom);
		}
	}
	
	private void addFormat(){
		if(manifestation.isSet_formatURI()){
			OWLIndividual formatURI = Individuals.getIndividual(manifestation.getFormatURI(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_encodedInFormat(), individual, formatURI);
			add(axiom);	
		}
	}
}
