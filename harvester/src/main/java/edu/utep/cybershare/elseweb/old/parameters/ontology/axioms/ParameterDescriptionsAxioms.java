package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameters;
import edu.utep.cybershare.elseweb.old.parameters.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;

public class ParameterDescriptionsAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Parameters parameters;
	private OWLClass parameterSetClass;
	
	public ParameterDescriptionsAxioms(OWLIndividual individual, Parameters parameters, OntologyToolset bundle, OWLClass parameterSetClass) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.parameters = parameters;
		this.parameterSetClass = parameterSetClass;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_ParameterDescriptions());
		
		addParameterDescriptions();
		addDescribesBehaviorOf();
		addParameterSetClass();
	}
	
	private void addDescribesBehaviorOf(){
		if(parameters.isSet_ParentAlgorithm()){
			OWLIndividual algorithmIndividual = Individuals.getIndividual(parameters.getParentAlgorithm(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_Lifemapper.getObjectProperty_describesBehaviorOf(), individual, algorithmIndividual);
			add(axiom);
		}
	}
	
	private void addParameterSetClass(){
		OWLLiteral classSetLiteral = bundle.getDataFactory().getOWLLiteral(this.parameterSetClass.getIRI().toString(), vocabulary_XSD.getDataType_anyURI());
		OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasParameterCollectionClass(), individual, classSetLiteral);
		add(axiom);
	}
	
	private void addParameterDescriptions(){
		if(parameters.isSet_ParameterSet()){
			OWLIndividual paramDescriptionIndividual;
			
			for(Parameter param : parameters.getParameters()){
				paramDescriptionIndividual = Individuals.getIndividual(param, bundle, "-description");
				
				OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_Lifemapper.getObjectProperty_hasParameterDescription(), individual, paramDescriptionIndividual);
				add(axiom);
			}
		}
	}
}
