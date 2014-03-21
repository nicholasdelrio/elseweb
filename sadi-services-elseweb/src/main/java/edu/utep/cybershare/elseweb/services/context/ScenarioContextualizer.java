package edu.utep.cybershare.elseweb.services.context;

import java.net.URL;

import org.apache.log4j.Logger;

import ca.wilkinsonlab.sadi.service.annotations.Description;
import ca.wilkinsonlab.sadi.service.annotations.Name;
import ca.wilkinsonlab.sadi.service.annotations.ContactEmail;
import ca.wilkinsonlab.sadi.service.annotations.InputClass;
import ca.wilkinsonlab.sadi.service.annotations.OutputClass;
import ca.wilkinsonlab.sadi.service.simple.SimpleSynchronousServiceServlet;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

import edu.utep.cybershare.elseweb.ontology.Vocabulary;
import edu.utep.cybershare.elseweb.services.specification.translation.SpecificationBuilder;
import edu.utep.cybershare.elseweb.services.specification.translation.json.JSONSpecification;
import edu.utep.cybershare.elseweb.services.util.Printing;

@Name("ScenarioContextualizer")
@ContactEmail("nicholas.delrio@gmail.com")
@InputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#Scenario")
@OutputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#ModellingScenario")
@Description("Associates scenarios with executable experiments")

public class ScenarioContextualizer extends SimpleSynchronousServiceServlet{
	
	private static final Logger log = Logger.getLogger(ScenarioContextualizer.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	public void processInput(Resource input, Resource output){
		Printing.print(input.getModel());
		
		// Extract the link to the JSON specification
		Literal jsonSpecificationURL = input.getProperty(Vocabulary.hasJSONExperimentSpecificationURL).getLiteral();

		// Create output model
		Model outputModel = ModelFactory.createDefaultModel();

		// Create the experiment
		JSONSpecification jsonSpec = new JSONSpecification(getURL(jsonSpecificationURL));
		SpecificationBuilder specBuilder = new SpecificationBuilder(jsonSpec, outputModel);
		Resource specification = specBuilder.getSpecification();
		specification.addProperty(Vocabulary.specifiesModellingScenario, input);
		
		// Merge our temporary output model
		output.getModel().add(outputModel);
		
		// Set scenario to reference parent experiment
		output.addProperty(Vocabulary.isModellingScenarioOf, specification);
		
		Printing.print(output.getModel());
	}
	
	private URL getURL(Literal literalURL){
		URL url = null;
		try{url = new URL(literalURL.getString());}
		catch(Exception e){e.printStackTrace();}
		return url;
	}
}
