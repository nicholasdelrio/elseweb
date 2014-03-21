package edu.utep.cybershare.elseweb.services.specification;

import java.net.URL;
import java.util.List;

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
import edu.utep.cybershare.elseweb.services.specification.translation.ELSEWebSPARQLEndpoint;
import edu.utep.cybershare.elseweb.services.specification.translation.json.JSONSpecification;
import edu.utep.cybershare.elseweb.services.util.Printing;

@Name("InputWCSDatasetMatcher")
@ContactEmail("nicholas.delrio@gmail.com")
@InputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#JSONExperimentSpecification")
@OutputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#InputWCSDatasetExperimentSpecification")
@Description("Matches wcs datasets specified in JSON experiment specifications")

public class InputWCSDatasetMatcher extends SimpleSynchronousServiceServlet{
	
	private static final Logger log = Logger.getLogger(InputWCSDatasetMatcher.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	public void processInput(Resource input, Resource output){
		Printing.print(input.getModel());
		
		// Extract the link to the JSON specification
		Literal jsonSpecificationURL = input.getProperty(Vocabulary.hasJSONExperimentSpecificationURL).getLiteral();
		
		// Create output model
		Model outputModel = ModelFactory.createDefaultModel();
		
		// Match up InputWCSDatasets
		JSONSpecification jsonSpec = new JSONSpecification(getURL(jsonSpecificationURL));
		List<String> datasetURIs = jsonSpec.getModellingScenario();
		ELSEWebSPARQLEndpoint endpoint = new ELSEWebSPARQLEndpoint();
		outputModel.add(endpoint.constructInputWCSDatasets(datasetURIs));
		
		// Merge our temporary output model
		output.getModel().add(outputModel);
		
		// Create our InputWCSDataset and add it to the output
		Resource wcsDataset;
		String wcsDatasetURI;
		for(int i = 0; i < jsonSpec.getModellingScenario().size(); i ++){
			
			// Add type code, layer units, and the JSON specification URL
			wcsDatasetURI = jsonSpec.getModellingScenario().get(i);
			wcsDataset = output.getModel().createResource(wcsDatasetURI);
			wcsDataset.addLiteral(Vocabulary.hasTypeCode, i);
			wcsDataset.addLiteral(Vocabulary.hasLayerUnits, "dd");
			wcsDataset.addLiteral(Vocabulary.hasJSONExperimentSpecificationURL, jsonSpecificationURL);
			
			// Add the InputWCSDataset to the output
			output.addProperty(Vocabulary.hasInputWCSDataset, wcsDataset);
		}
			
		Printing.print(output.getModel());
	}
	
	private URL getURL(Literal literalURL){
		URL url = null;
		try{url = new URL(literalURL.getString());}
		catch(Exception e){e.printStackTrace();}
		return url;
	}
}
