package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;


import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;



public class PROVO extends Vocabulary{

	private static final String NAMESPACE = "http://www.w3.org/ns/prov";
	
	private static final String OntClass_Activity = NAMESPACE + "#Activity";
	
	private static final String ObjectProperty_wasGeneratedBy = NAMESPACE + "#wasGeneratedBy";
	private static final String ObjectProperty_wasAssociatedWith = NAMESPACE + "#wasAssociatedWith";

	
	public PROVO(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
	public OWLClass getOntClass_Activity(){return bundle.getDataFactory().getOWLClass(IRI.create(OntClass_Activity));}
	public OWLObjectProperty getObjectProperty_wasGeneratedBy(){return bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_wasGeneratedBy));}	
	public OWLObjectProperty getObjectProperty_wasAssociatedWith(){return bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_wasAssociatedWith));}
}
