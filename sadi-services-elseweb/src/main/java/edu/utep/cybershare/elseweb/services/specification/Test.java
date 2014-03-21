package edu.utep.cybershare.elseweb.services.specification;

import java.net.URL;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import edu.utep.cybershare.elseweb.services.specification.translation.SpecificationBuilder;
import edu.utep.cybershare.elseweb.services.specification.translation.json.JSONSpecification;
import edu.utep.cybershare.elseweb.services.util.Printing;


public class Test {

	public static void main(String[] args){
		String jsonSpecURLString = "http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/experiments/specifications/json/sample-specification.json";
			
		try{
			URL jsonSpecURL = new URL(jsonSpecURLString);
			JSONSpecification jsonSpec = new JSONSpecification(jsonSpecURL);
			Model model = ModelFactory.createDefaultModel();
			SpecificationBuilder builder = new SpecificationBuilder(jsonSpec, model);		
			Printing.print(model);
			
		}catch(Exception e){e.printStackTrace();}
	}
}
