package edu.utep.cybershare.elseweb.services.ogc.wcs.multipart;

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
import edu.utep.cybershare.elseweb.services.util.Printing;
import edu.utep.cybershare.elseweb.services.util.ResourceURI;

@Name("WCSResponseExtractor")
@ContactEmail("nicholas.delrio@gmail.com")
@InputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#WCSResponse")
@OutputClass("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#ExtractedWCSResponse")
@Description("Extracts payloads from wcs responses")

public class WCSResponseExtractor extends SimpleSynchronousServiceServlet{
	
	private static final Logger log = Logger.getLogger(WCSResponseExtractor.class);
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
		
		// Extract file download URL
		String fileDownloadURL = distributionResource.getProperty(Vocabulary.hasFileDownloadURL).getString();
		
		// Extract and publish the wcs response payload
		URL payloadURL = this.getCoveragePayloadURL(fileDownloadURL);
				
		// Create the output Model
		Model outputModel = ModelFactory.createDefaultModel();
		
		// Create the TIFFManifestation
		ResourceURI resourceURI = new ResourceURI();
		Resource tiffManifestation = outputModel.createResource(resourceURI.getURI("manifestation").toASCIIString(), Vocabulary.TIFFManifestation);
		tiffManifestation.addLiteral(Vocabulary.hasFileDownloadURL, payloadURL.toString());
		
		// Create the TIFFDataset
		Resource tiffDataset = outputModel.createResource(resourceURI.getURI("tiffDataset").toASCIIString(), Vocabulary.TIFFDataset);
		tiffDataset.addProperty(Vocabulary.hasManifestation, tiffManifestation);
		tiffDataset.addLiteral(Vocabulary.hasTypeCode, typeCode);
		tiffDataset.addLiteral(Vocabulary.hasLayerUnits, layerUnits);
		tiffDataset.addProperty(Vocabulary.hasJSONExperimentSpecificationURL, jsonSpecificationURL);
		
		// Merge our temporary output model
		output.getModel().add(outputModel);
		
		// Attached the TIFFDataset to the output
		output.addProperty(Vocabulary.hasExtractedPayload, tiffDataset);
		
		Printing.print(output.getModel());
	}
	
	private URL getCoveragePayloadURL(String fileDownloadURL){
		WCSResponse extractor = new WCSResponse(fileDownloadURL);
		URL coveragePayloadURL = extractor.getPayload();
		return coveragePayloadURL;
	}
}