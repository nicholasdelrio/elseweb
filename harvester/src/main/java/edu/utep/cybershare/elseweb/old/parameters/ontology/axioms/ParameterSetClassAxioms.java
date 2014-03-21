package edu.utep.cybershare.elseweb.old.parameters.ontology.axioms;

import java.util.HashSet;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;

import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameters;
import edu.utep.cybershare.elseweb.old.parameters.ontology.Classes;
import edu.utep.cybershare.elseweb.old.parameters.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;

public class ParameterSetClassAxioms extends ClassAxioms {

	private Parameters parameters;
	
	public ParameterSetClassAxioms(OWLClass owlParameterSetClass, Parameters parameters, OntologyToolset bundle) {
		super(owlParameterSetClass, bundle);
		this.parameters = parameters;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addSubClassOfAxiom(vocabulary_Lifemapper.getOWLClass_LifemapperParameters());
		
		addIntersectionOfProperties();
	}
	
	private void addIntersectionOfProperties(){
		OWLClass owlParameterClass;
		HashSet<OWLClassExpression> anonymousClassesIntersection = new HashSet<OWLClassExpression>();
		
		for(Parameter paramClass : this.parameters.getParameters()){
			owlParameterClass = Classes.getOWLClass(paramClass, bundle, null);
					
			OWLClassExpression memberExpression = bundle.getDataFactory().getOWLObjectSomeValuesFrom(vocabulary_Modelling.getObjectProperty_hasParameterMember(), owlParameterClass);			
			anonymousClassesIntersection.add(memberExpression);
		}
		
		//add the controlsBehaviorOf property as part of the intersection
		/*
		OWLObjectHasValue controlsBehaviorRestriction = getControlsBehaviorOf();
		if(controlsBehaviorRestriction != null)
			anonymousClassesIntersection.add(controlsBehaviorRestriction);*/
		
		OWLObjectIntersectionOf memberIntersection = bundle.getDataFactory().getOWLObjectIntersectionOf(anonymousClassesIntersection);		
		this.addEquivalentClassAxiom(memberIntersection);
	}
	
	/*
	private OWLObjectHasValue getControlsBehaviorOf(){
		if(parameters.isSet_ParentAlgorithm()){
			OWLIndividual algorithmIndividual = Individuals.getIndividual(parameters.getParentAlgorithm(), bundle);
			
			OWLObjectHasValue hasValueRestriction = bundle.getDataFactory().getOWLObjectHasValue(vocabulary_Modelling.getObjectProperty_controlsBehaviorOf(), algorithmIndividual);
			return hasValueRestriction;
		}
		return null;
	}*/
}
