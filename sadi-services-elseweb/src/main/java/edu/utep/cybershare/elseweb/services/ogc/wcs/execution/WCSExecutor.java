package edu.utep.cybershare.elseweb.services.ogc.wcs.execution;

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
import edu.utep.cybershare.elseweb.services.ogc.wcs.execution.digest.WCSDigest;
import edu.utep.cybershare.elseweb.services.util.Printing;
import edu.utep.cybershare.elseweb.services.util.ResourceURI;


@Name("WCSExecutor")
@ContactEmail("nicholas.delrio@gmail.com")
@InputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#InputWCSDataset")
@OutputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#ExecutedWCSDataset")
@Description("Generates wcs responses from input wcs datasets")

public class WCSExecutor extends SimpleSynchronousServiceServlet{
	
	private static final Logger log = Logger.getLogger(WCSExecutor.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void processInput(Resource input, Resource output){
		Printing.print(input.getModel());
		
		// Extract Manifestation
		Resource distributionResource = input.getPropertyResourceValue(Vocabulary.hasManifestation);
		
		// Extract the type code and layer units
		int typeCode = input.getProperty(Vocabulary.hasTypeCode).getInt();
		String layerUnits = input.getProperty(Vocabulary.hasLayerUnits).getString();
		
		// Extract the link to the JSON specification
		Literal jsonSpecificationURL = input.getProperty(Vocabulary.hasJSONExperimentSpecificationURL).getLiteral();
		
		// Extract Region
		Resource boxedRegion = input.getPropertyResourceValue(Vocabulary.coversRegion);
		double llon = boxedRegion.getProperty(Vocabulary.hasLeftLongitude).getDouble();
		double rlon = boxedRegion.getProperty(Vocabulary.hasRightLongitude).getDouble();
		double llat = boxedRegion.getProperty(Vocabulary.hasLowerLatitude).getDouble();
		double ulat = boxedRegion.getProperty(Vocabulary.hasUpperLatitude).getDouble();
		
		// Extract Capabilities URL
		String capabilitiesJSONURL = distributionResource.getProperty(Vocabulary.hasJSONCapabilitiesDigestURL).getString();
		
		// Create the the service call URL
		WCSGetCoverageURL wcsGetCoverageURL = this.getWCSGetCoverageURL(capabilitiesJSONURL, llon, rlon, llat, ulat);
						
		// Create output model
		Model outputModel = ModelFactory.createDefaultModel();
		
		// Create the WCSResponseManifestation
		ResourceURI resourceURI = new ResourceURI();
		Resource wcsResponseManifestation = outputModel.createResource(resourceURI.getURI("manifestation").toASCIIString(), Vocabulary.WCSResponseManifestation);
		wcsResponseManifestation.addLiteral(Vocabulary.hasFileDownloadURL, wcsGetCoverageURL.getURL().toString());

		//create the WCSResponse
		Resource wcsResponse = outputModel.createResource(resourceURI.getURI("wcsResponse").toASCIIString(), Vocabulary.WCSResponse);
		wcsResponse.addProperty(Vocabulary.hasManifestation, wcsResponseManifestation);
		wcsResponse.addLiteral(Vocabulary.hasTypeCode, typeCode);
		wcsResponse.addLiteral(Vocabulary.hasLayerUnits, layerUnits);
		wcsResponse.addProperty(Vocabulary.hasJSONExperimentSpecificationURL, jsonSpecificationURL);
		
		// Merge our temporary output model
		output.getModel().add(outputModel);

		// Attached the WCSResponse to the output
		output.addProperty(Vocabulary.hasWCSResponse, wcsResponse);

		Printing.print(output.getModel());
	}
	
	private WCSGetCoverageURL getWCSGetCoverageURL(String jsonDigestURLString, double llon, double rlon, double llat, double ulat){
		try{
			
			URL jsonDigestURL = new URL(jsonDigestURLString);
			WCSDigest wcsDigest = new WCSDigest(jsonDigestURL);
			
			// set wcs getCoverage parameters
			WCSGetCoverageParameters params = new WCSGetCoverageParameters();

			// set the requested bounding box
			params.setBBox(llon, rlon, llat, ulat);
		
			// set the width and height of resulting coverage
			double width = 1200;
			double height = 1200;
			params.setWidth(width);
			params.setHeight(height);
		

			// set the response format, note that the format is contained in some OGC metadata XML
			String format = "image/tiff";
			params.setFormat(format);
		
			// set the coverage being requested
			params.setCoverage(wcsDigest.getName());
		
			// construct the parameterized URL from the wcs endpoint and the parameters
			WCSGetCoverageURL wcsGetCoverageURL = new WCSGetCoverageURL(wcsDigest.getWCSServiceEndpoint().toString(), params);
			return wcsGetCoverageURL;
		}catch(Exception e){e.printStackTrace();}
			return null;
	}
}