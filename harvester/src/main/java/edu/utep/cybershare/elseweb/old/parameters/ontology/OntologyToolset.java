package edu.utep.cybershare.elseweb.old.parameters.ontology;

import java.io.File;
import java.util.List;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentTarget;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary.ELSEWebLifemapper;


public class OntologyToolset {
	protected OWLDataFactory dataFactory;
	protected OWLOntology ontology;
	protected OWLOntologyManager ontologyManager;
	protected String baseURI;
	
	public OntologyToolset(String baseURI){
		this.baseURI = baseURI;
			
		dataFactory = OWLManager.getOWLDataFactory();
		ontologyManager = OWLManager.createOWLOntologyManager();

		try{ontology = ontologyManager.createOntology(IRI.create(this.baseURI));}
		catch(Exception e){e.printStackTrace();}
		
		//importLifemapperOntology();
	}
	
	public String getBaseIRI(){return this.baseURI;}
	
	private void importLifemapperOntology(){
		ELSEWebLifemapper vocabulary_Lifemapper = new ELSEWebLifemapper(this);
		IRI lifemapperOntologyIRI = IRI.create(vocabulary_Lifemapper.getNamespace());
		OWLImportsDeclaration lifemapperImportDeclaration = dataFactory.getOWLImportsDeclaration(lifemapperOntologyIRI);
		AddImport addLifemapperImport = new AddImport(ontology, lifemapperImportDeclaration);
		ontologyManager.applyChange(addLifemapperImport);
	}

		
	public String getIRI(String fragment){
		return this.baseURI + "#" + fragment;
	}
	
	public void addAxioms(List<OWLAxiom> axioms){
		AddAxiom addAxiomChange;
		for(OWLAxiom anAxiom : axioms){
			addAxiomChange = new AddAxiom(ontology, anAxiom);
			ontologyManager.applyChange(addAxiomChange);
		}
	}
	
	public OWLDataFactory getDataFactory() {
		return dataFactory;
	}
	public void setDataFactory(OWLDataFactory dataFactory) {
		this.dataFactory = dataFactory;
	}
	public OWLOntology getOntology() {
		return ontology;
	}
	public void setOntology(OWLOntology ontology) {
		this.ontology = ontology;
	}
	public OWLOntologyManager getOntologyManager() {
		return ontologyManager;
	}
	public void setOntologyManager(OWLOntologyManager ontologyManager) {
		this.ontologyManager = ontologyManager;
	}

	public void dumpOntology(File aFile){
		FileDocumentTarget target = new FileDocumentTarget(aFile);
		try{ontologyManager.saveOntology(ontology, target);}
		catch(Exception e){e.printStackTrace();}
	}
}