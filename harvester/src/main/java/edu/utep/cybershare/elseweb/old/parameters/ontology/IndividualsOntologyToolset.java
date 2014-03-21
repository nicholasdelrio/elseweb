package edu.utep.cybershare.elseweb.old.parameters.ontology;

import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;

public class IndividualsOntologyToolset extends OntologyToolset{

	private String instancesBaseURI;
	
	public IndividualsOntologyToolset(String parameterClassesOntologyURI, String encapsulatingOntologyURI, String instancesBaseURI) {
		super(encapsulatingOntologyURI);
		
		this.instancesBaseURI = instancesBaseURI;

		if(!instancesBaseURI.endsWith("/"))
			this.instancesBaseURI += "/";
		
		this.importParametersOntology(parameterClassesOntologyURI);
	}
	
	private void importParametersOntology(String ontologyURI){
		OWLImportsDeclaration importDeclaration = dataFactory.getOWLImportsDeclaration(IRI.create(ontologyURI));
		AddImport addImport = new AddImport(ontology, importDeclaration);
		this.ontologyManager.applyChange(addImport);
	}
	
	@Override
	public String getIRI(String fragment){
		return this.instancesBaseURI + fragment;
	}
}
