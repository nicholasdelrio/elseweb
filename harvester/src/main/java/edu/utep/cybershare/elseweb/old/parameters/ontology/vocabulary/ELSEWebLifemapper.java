package edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;


public class ELSEWebLifemapper extends Vocabulary {
	
	private static final String NAMESPACE = "http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl";
	
	private static final String OWLClass_LifemapperAlgorithm = NAMESPACE + "#LifemapperAlgorithm";
	private static final String OWLClass_LifemapperParameter = NAMESPACE + "#LifemapperParameter";
	private static final String OWLClass_LifemapperParameters = NAMESPACE + "#LifemapperParameters";
	
	private static final String OWLClass_ParameterDescriptions = NAMESPACE + "#ParameterDescriptions";
	private static final String OWLClass_ParameterDescription = NAMESPACE + "#ParameterDescription";
	
	private static final String ObjectProperty_describesBehaviorOf = NAMESPACE + "#describesBehaviorOf";
	private static final String ObjectProperty_hasParameterDescription = NAMESPACE + "#hasParameterDescription";

	
	private static final String DataProperty_hasDefaultValue = NAMESPACE + "#hasDefaultValue";
	
	private static final String DataProperty_hasParameterClass = NAMESPACE + "#hasParameterClass";
	private static final String DataProperty_hasParameterCollectionClass = NAMESPACE + "#hasParameterCollectionClass";
	
	private static final String DataProperty_hasAlgorithmCode = NAMESPACE + "#hasAlgorithmCode";
	
	private static final String DataProperty_hasUpperBoundInclusive = NAMESPACE + "#hasUpperBoundInclusive";
	private static final String DataProperty_hasLowerBoundInclusive = NAMESPACE + "#hasLowerBoundInclusive";
	
	public ELSEWebLifemapper(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}
	
	public OWLClass getOWLClass_LifemapperAlgorithm(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_LifemapperAlgorithm));}
	public OWLClass getOWLClass_LifemapperParameters(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_LifemapperParameters));}
	public OWLClass getOWLClass_LifemapperParameter(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_LifemapperParameter));}
	public OWLClass getOWLClass_ParameterDescriptions(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_ParameterDescriptions));}
	public OWLClass getOWLClass_ParameterDescription(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_ParameterDescription));}
	
	public OWLDataProperty getDataProperty_hasDefaultValue(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasDefaultValue));}

	
	public OWLDataProperty getDataProperty_hasAlgorithmCode(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasAlgorithmCode));}
	
	public OWLDataProperty getDataProperty_hasUpperBoundInclusive(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasUpperBoundInclusive));}
	public OWLDataProperty getDataProperty_hasLowerBoundInclusive(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasLowerBoundInclusive));}
	
	public OWLDataProperty getDataProperty_hasParameterClass(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasParameterClass));}
	public OWLDataProperty getDataProperty_hasParameterCollectionClass(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasParameterCollectionClass));}
	
	public OWLObjectProperty getObjectProperty_describesBehaviorOf(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_describesBehaviorOf));}	
	public OWLObjectProperty getObjectProperty_hasParameterDescription(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasParameterDescription));}
		
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
}
