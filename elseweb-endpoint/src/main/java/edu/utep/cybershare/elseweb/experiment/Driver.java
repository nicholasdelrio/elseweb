package edu.utep.cybershare.elseweb.experiment;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;

import edu.utep.cybershare.elseweb.utils.HTTPGetUtils;
import edu.utep.cybershare.elseweb.utils.HTTPPostUtils;
public class Driver {
	
	public static String getJSONSpecString(){
		URL url = getURL("http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/experiments/specifications/json/sample-specification.json");
		String json = HTTPGetUtils.getInstance().downloadText(url);
		return json;
	}
	
	public static void testDumping(){
		String jsonSpecificationString = getJSONSpecString();
		edu.utep.cybershare.elseweb.experiment.json.JSONSpecification jsonSpecification = new edu.utep.cybershare.elseweb.experiment.json.JSONSpecification(jsonSpecificationString);
		JSONExperimentSpecification specBuilder = new JSONExperimentSpecification(jsonSpecification);
		String specURLString = specBuilder.dumpJSONExperimentSpecification().toString();
		
		System.out.println(specURLString);
	}
	
	public static void testPosting(){
		String json = getJSONSpecString();
		
		ArrayList<BasicNameValuePair> bindings = new ArrayList<BasicNameValuePair>();
		bindings.add(new BasicNameValuePair("jsonSpec", json));

		URL url = getURL("http://visko.cybershare.utep.edu/elseweb-endpoint/JSONSpecification");
		String result = HTTPPostUtils.getInstance().post(url, bindings);
		System.out.println("Result: " + result);
	}
		
	public static URL getURL(String urlString){
		URL url = null;
		
		try{url = new URL(urlString);}
		catch(Exception e){e.printStackTrace();}
		
		return url;
	}
	
	public static void main(String[] args){
		//testDumping();
		testPosting();
	}
}
