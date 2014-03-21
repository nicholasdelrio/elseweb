package edu.utep.cybershare.elseweb.old.parameters.ontology;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.parameters.ontology.axioms.AlgorithmAxioms;
import edu.utep.cybershare.elseweb.old.parameters.ontology.axioms.ParameterClassAxioms;
import edu.utep.cybershare.elseweb.old.parameters.ontology.axioms.ParameterDescriptionAxioms;
import edu.utep.cybershare.elseweb.old.parameters.ontology.axioms.ParameterDescriptionsAxioms;
import edu.utep.cybershare.elseweb.old.parameters.ontology.axioms.ParameterSetClassAxioms;
import edu.utep.cybershare.elseweb.old.parameters.model.Algorithm;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameters;
import edu.utep.cybershare.elseweb.old.parameters.model.Visitor;

public class OWLIndividualsVisitor implements Visitor{

	private OntologyToolset classesBundle;
	private OntologyToolset indsBundle;
	
	public OWLIndividualsVisitor(OntologyToolset classesBundle, IndividualsOntologyToolset indsBundle){
		this.classesBundle = classesBundle;
		this.indsBundle = indsBundle;
	}
	
	public void visit(Algorithm algorithm) {
		//build the algorithm individual
		OWLIndividual algorithmIndividual = Individuals.getIndividual(algorithm, indsBundle);
		
		AlgorithmAxioms axioms = new AlgorithmAxioms(algorithmIndividual, algorithm, indsBundle);
		axioms.setAxioms();
		indsBundle.addAxioms(axioms);
	}

	public void visit(Parameter parameter) {
		// TODO Auto-generated method stub
		OWLClass parameterClass = Classes.getOWLClass(parameter, classesBundle, null);
		
		OWLIndividual parameterDescriptionIndividual = Individuals.getIndividual(parameter, indsBundle, "-description");
		ParameterDescriptionAxioms pAxioms = new ParameterDescriptionAxioms(parameterDescriptionIndividual, parameter, indsBundle, parameterClass);
		pAxioms.setAxioms();
		indsBundle.addAxioms(pAxioms);
	}

	public void visit(Parameters parameters) {
		// TODO Auto-generated method stub
		OWLClass parametersClass = Classes.getOWLClass(parameters, classesBundle, null);
		
		OWLIndividual paramDescriptionsIndividual = Individuals.getIndividual(parameters, indsBundle, "-descriptions");
		ParameterDescriptionsAxioms pAxioms = new ParameterDescriptionsAxioms(paramDescriptionsIndividual, parameters, indsBundle, parametersClass);
		pAxioms.setAxioms();
		indsBundle.addAxioms(pAxioms);
		
	}
}
