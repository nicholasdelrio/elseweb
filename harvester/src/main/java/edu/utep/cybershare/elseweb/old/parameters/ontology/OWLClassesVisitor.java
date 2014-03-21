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

public class OWLClassesVisitor implements Visitor{

	private OntologyToolset bundle;
	
	public OWLClassesVisitor(OntologyToolset bundle){
		this.bundle = bundle;
	}
	
	public void visit(Algorithm algorithm) {
		//build the algorithm individual
		OWLIndividual algorithmIndividual = Individuals.getIndividual(algorithm, bundle);
		
		AlgorithmAxioms axioms = new AlgorithmAxioms(algorithmIndividual, algorithm, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Parameter parameter) {
		// TODO Auto-generated method stub
		OWLClass parameterClass = Classes.getOWLClass(parameter, bundle, null);
		ParameterClassAxioms axioms = new ParameterClassAxioms(parameterClass, parameter, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Parameters parameters) {
		// TODO Auto-generated method stub
		OWLClass parametersClass = Classes.getOWLClass(parameters, bundle, null);
		ParameterSetClassAxioms axioms = new ParameterSetClassAxioms(parametersClass, parameters, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}
}
