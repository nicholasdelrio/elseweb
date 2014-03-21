package edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;


public class ELSEWebModelling extends Vocabulary {
	
	private static final String NAMESPACE = "http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-modelling.owl";
	
	private static final String ObjectProperty_controlsBehaviorOf = NAMESPACE + "#controlsBehaviorOf";
	private static final String ObjectProperty_hasParameterMember = NAMESPACE + "#hasParameterMember";
	
	private static final String DataProperty_hasParameterName = NAMESPACE + "#hasParameterName";
	private static final String DataProperty_hasAlgorithmName = NAMESPACE + "#hasAlgorithmName";
	
	private static final String DataProperty_boundToValue = NAMESPACE + "#boundToValue";
	
	public ELSEWebModelling(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}
	
	public OWLObjectProperty getObjectProperty_controlsBehaviorOf(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_controlsBehaviorOf));}	
	public OWLObjectProperty getObjectProperty_hasParameterMember(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasParameterMember));}	
	
	public OWLDataProperty getDataProperty_hasParameterName(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasParameterName));}
	public OWLDataProperty getDataProperty_hasAlgorithmName(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasAlgorithmName));}

	public OWLDataProperty getDataProperty_boundToValue(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_boundToValue));}
	
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
}