package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;

public class ParameterDescriptionAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Parameter parameter;
	private OWLClass parameterClass;
	
	public ParameterDescriptionAxioms(OWLIndividual individual, Parameter parameter, OntologyToolset bundle, OWLClass parameterClass) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.parameter = parameter;
		this.parameterClass = parameterClass;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_ParameterDescription());
		
		addLowerBound();
		addUpperBound();
		addName();
		addDefaultValue();
		addParameterClass();
	}

	private void addDefaultValue(){
		if(parameter.isSet_defaultValue()){
			OWLLiteral defaultLiteral;
			if(parameter.getType().equals(Parameter.Integer_Label))
				defaultLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getIntegerDefaultValue());
			else
				defaultLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getFloatDefaultValue());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasDefaultValue(), individual, defaultLiteral);
			add(axiom);
		}
	}
	
	private void addName(){
		if(parameter.isSet_name()){
			OWLLiteral nameLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getName());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Modelling.getDataProperty_hasParameterName(), individual, nameLiteral);
			add(axiom);
		}
	}
	
	private void addParameterClass(){
		OWLLiteral classLiteral = bundle.getDataFactory().getOWLLiteral(this.parameterClass.getIRI().toString(), vocabulary_XSD.getDataType_anyURI());
		OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasParameterClass(), individual, classLiteral);
		add(axiom);
	}

	
	private void addLowerBound(){
		if(parameter.isSet_min()){
			OWLLiteral minLiteral;
			if(parameter.getType().equals(Parameter.Integer_Label))
				minLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getIntegerMin());
			else
				minLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getFloatMin());
			
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasLowerBoundInclusive(), individual, minLiteral);
			add(axiom);
		}
	}
	
	
	
	private void addUpperBound(){
		if(parameter.isSet_max()){
			OWLLiteral maxLiteral;
			if(parameter.getType().equals(Parameter.Integer_Label))
				maxLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getIntegerMax());
			else
				maxLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getFloatMax());
			
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_Lifemapper.getDataProperty_hasUpperBoundInclusive(), individual, maxLiteral);
			add(axiom);
		}
	}
}
