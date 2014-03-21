package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;

public class ParameterClassAxioms extends ClassAxioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Parameter parameter;
	
	public ParameterClassAxioms(OWLClass owlParameterClass, Parameter parameter, OntologyToolset bundle) {
		super(owlParameterClass, bundle);
		this.parameter = parameter;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addSubClassOfAxiom(this.vocabulary_Lifemapper.getOWLClass_LifemapperParameter());
		
		addDefaultValueRestriction();
		addBoundToValueRestriction();
		addParameterNameRestriction();
	}
	
	private void addDefaultValueRestriction(){
		OWLLiteral defaultValueLiteral;
		if(parameter.isSet_defaultValue()){
			if(parameter.getType().equals(Parameter.Integer_Label))
				defaultValueLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getIntegerDefaultValue());
			else
				defaultValueLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getFloatDefaultValue());
			
			OWLDataHasValue hasValueRestriction = bundle.getDataFactory().getOWLDataHasValue(vocabulary_Lifemapper.getDataProperty_hasDefaultValue(), defaultValueLiteral);
			this.addEquivalentClassAxiom(hasValueRestriction);
		}
	}
	
	private void addParameterNameRestriction(){
		if(parameter.isSet_name()){
			OWLLiteral nameLiteral = bundle.getDataFactory().getOWLLiteral(parameter.getName());
			
			OWLDataHasValue hasValueRestriction = bundle.getDataFactory().getOWLDataHasValue(vocabulary_Modelling.getDataProperty_hasParameterName(), nameLiteral);
			this.addEquivalentClassAxiom(hasValueRestriction);
		}
	}
	
	private void addBoundToValueRestriction(){
		OWLDataExactCardinality exactCardinality = null;
		OWLDatatypeRestriction intervalRestriction = null;
				
		if(parameter.isSet_min() && parameter.isSet_max()){
			if(parameter.isSet_type() && parameter.getType().equals(Parameter.Integer_Label))
				intervalRestriction = bundle.getDataFactory().getOWLDatatypeMinMaxInclusiveRestriction(parameter.getIntegerMin(), parameter.getIntegerMax());
			else
				intervalRestriction = bundle.getDataFactory().getOWLDatatypeMinMaxInclusiveRestriction(parameter.getFloatMin(), parameter.getFloatMax());				
		}
		else if(parameter.isSet_min() && !parameter.isSet_max()){
			if(parameter.isSet_type() && parameter.getType().equals(Parameter.Integer_Label))
				intervalRestriction = bundle.getDataFactory().getOWLDatatypeMinInclusiveRestriction(parameter.getIntegerMin());
			else
				intervalRestriction = bundle.getDataFactory().getOWLDatatypeMinInclusiveRestriction(parameter.getFloatMin());
		}
		else if(!parameter.isSet_min() && parameter.isSet_max()){
			if(parameter.isSet_type() && parameter.getType().equals(Parameter.Integer_Label))
				intervalRestriction = bundle.getDataFactory().getOWLDatatypeMinInclusiveRestriction(parameter.getIntegerMax());
			else
				intervalRestriction = bundle.getDataFactory().getOWLDatatypeMinInclusiveRestriction(parameter.getFloatMax());
		}
		
		if(intervalRestriction != null){
			exactCardinality = bundle.getDataFactory().getOWLDataExactCardinality(1, vocabulary_Modelling.getDataProperty_boundToValue(), intervalRestriction);
			this.addEquivalentClassAxiom(exactCardinality);
		}
	}
}
