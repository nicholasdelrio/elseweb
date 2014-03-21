package edu.utep.cybershare.elseweb.old.parameters.harvest;

import java.io.File;

import edu.utep.cybershare.elseweb.old.parameters.build.Builder;
import edu.utep.cybershare.elseweb.old.parameters.build.Director;
import edu.utep.cybershare.elseweb.old.parameters.build.ModelProduct;
import edu.utep.cybershare.elseweb.old.parameters.build.source.lifemapper.ParametersXML;
import edu.utep.cybershare.elseweb.old.parameters.model.Algorithm;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameters;
import edu.utep.cybershare.elseweb.old.parameters.ontology.IndividualsOntologyToolset;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OWLClassesVisitor;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OWLIndividualsVisitor;
import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.parameters.util.FilePath;
import edu.utep.cybershare.elseweb.old.parameters.util.InstancesFilePath;

public class Harvester {
	
	public static void main(String[] args){
	
		//setup the empty product
		ModelProduct product = new ModelProduct();
		
		//setup the builder of the product
		Builder builder = new Builder(product);
		
		//setup the builder directory
		Director director = new Director(builder);
		
		//get our data source and pass to director
		ParametersXML paramsXML = new ParametersXML();
		director.construct(paramsXML.getDOMObject());
		
		//create visitor to convert model product to axioms
		OntologyToolset classesBundle = new OntologyToolset(FilePath.DOCUMENT_URL);
		IndividualsOntologyToolset instancesBundle = new IndividualsOntologyToolset(FilePath.DOCUMENT_URL, InstancesFilePath.DOCUMENT_URL, InstancesFilePath.INSTANCES_BASE_URL);
		
		OWLClassesVisitor classesVisitor = new OWLClassesVisitor(classesBundle);
		//visit all algorithms
		for(Algorithm algorithm : product.getAlgorithms())
			classesVisitor.visit(algorithm);

		//visit all parameters
		for(Parameter parameter : product.getParameters()){
			classesVisitor.visit(parameter);
		}
		
		//visit all parameter sets
		for(Parameters parameters : product.getParameterSets()){
			classesVisitor.visit(parameters);
		}

		OWLIndividualsVisitor indsVisitor = new OWLIndividualsVisitor(classesBundle, instancesBundle);
		//visit all algorithms
		for(Algorithm algorithm : product.getAlgorithms())
			indsVisitor.visit(algorithm);

		//visit all parameters
		for(Parameter parameter : product.getParameters()){
			indsVisitor.visit(parameter);
		}
		
		//visit all parameter sets
		for(Parameters parameters : product.getParameterSets()){
			indsVisitor.visit(parameters);
		}
		
		
		//dump file
		classesBundle.dumpOntology(new File(FilePath.DUMP_PATH));
		instancesBundle.dumpOntology(new File(InstancesFilePath.DUMP_PATH));
	}
}
