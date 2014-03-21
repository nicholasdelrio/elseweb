package edu.utep.cybershare.elseweb.experiment;

import java.io.File;
import java.net.URL;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import edu.utep.cybershare.elseweb.utils.FileSupport;
import edu.utep.cybershare.elseweb.utils.ResourceURI;


public class JSONExperimentSpecification {

	private OWLOntology ontology;
	private OWLDataFactory factory;
	private OWLOntologyManager manager;
	
	private edu.utep.cybershare.elseweb.experiment.json.JSONSpecification jsonSpec;
	
	private FileSupport fileSupport;
	
	public JSONExperimentSpecification(edu.utep.cybershare.elseweb.experiment.json.JSONSpecification jsonSpec){
		this.jsonSpec = jsonSpec;
		this.manager = OWLManager.createOWLOntologyManager();
		this.factory = manager.getOWLDataFactory();
		this.fileSupport = new FileSupport();
	}
	
	private URL dumpJSONFile(){return fileSupport.dumpJSONSpecification(this.jsonSpec.getString());}
	
	public URL dumpJSONExperimentSpecification(){
	
		URL ontologyURI = this.fileSupport.getSpecificationURL();
		try{ontology = manager.createOntology(IRI.create(ontologyURI));}
		catch(Exception e){e.printStackTrace();}
		
		ResourceURI resourceURI = new ResourceURI();
	
		// Create specification individual
		String specificationURI = resourceURI.getURI("specification", this.fileSupport.getID()).toASCIIString();
		OWLIndividual spec = factory.getOWLNamedIndividual(IRI.create(specificationURI));
		OWLClass JSONExperimentSpecification = factory.getOWLClass(IRI.create("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#JSONExperimentSpecification"));
		OWLAxiom classifySpecAxiom = factory.getOWLClassAssertionAxiom(JSONExperimentSpecification, spec);
		manager.addAxiom(ontology, classifySpecAxiom);
		
		// Add JSON URL property
		String dumpedJSONURL = this.dumpJSONFile().toString();
		OWLDataProperty hasJSONExperimentSpecificationURL = factory.getOWLDataProperty(IRI.create("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#hasJSONExperimentSpecificationURL"));
		OWLLiteral jsonSpecURL = factory.getOWLLiteral(dumpedJSONURL);
		OWLAxiom hasJSONExperimentSpecificationURLAxiom = factory.getOWLDataPropertyAssertionAxiom(hasJSONExperimentSpecificationURL, spec, jsonSpecURL);
		manager.addAxiom(ontology, hasJSONExperimentSpecificationURLAxiom);
		
		// Dump specification
		File dumpFile = this.fileSupport.getSpecificationFilePath();
		FileDocumentTarget target = new FileDocumentTarget(dumpFile);
		try{manager.saveOntology(ontology, target);}
		catch(Exception e){e.printStackTrace();}
		
		return ontologyURI;
	}	
}
