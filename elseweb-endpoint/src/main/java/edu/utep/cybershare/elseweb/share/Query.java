package edu.utep.cybershare.elseweb.share;

import java.net.URL;
import java.net.URLEncoder;

public class Query {
	
	private static final String NEWLINE = "\n";

	private URL namedGraphURL;
	
	private String getPrefix(){
		String prefix = "prefix lm: <http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#>" + NEWLINE;
		return prefix;
	}
	
	public Query(URL specificationURL){
		this.namedGraphURL = specificationURL;
	}
	
	private String getQueryTemplate(){
		String queryText = 
				getPrefix() +
				"select distinct ?resultURL ?resultURI" + NEWLINE +
				"from <REPLACE>" + NEWLINE +
				"where" + NEWLINE +
				"{" + NEWLINE +
				"?jsonSpec a lm:JSONExperimentSpecification ." + NEWLINE +
				"?jsonSpec lm:hasInputWCSDataset" + NEWLINE +
					"[lm:hasWCSResponse" + NEWLINE +
						"[lm:hasExtractedPayload" + NEWLINE +
							"[lm:hasPublishedLayer" + NEWLINE +
								"[lm:isScenarioLayerOf" + NEWLINE +
									"[lm:hasPublishedScenario" + NEWLINE +
										"[lm:isModellingScenarioOf" + NEWLINE +
											"[lm:hasExperimentResult ?resultURI]]]]]]]." + NEWLINE +
				"?result lm:hasExperimentResultURL ?resultURL" + NEWLINE +
				"}";
		return queryText;
	}
	
	public String getCompletedQuery(){
		String completedQueryString = null;
		if(namedGraphURL != null)
			completedQueryString = this.getQueryTemplate().replaceAll("REPLACE", namedGraphURL.toString());
		
		return completedQueryString;
	}

	
	private String getEncodedQuery(String queryString) {
		String encodedQuery = null;
		try {encodedQuery = URLEncoder.encode(queryString, "UTF-8");}
		catch (Exception e) {e.printStackTrace();}
		return encodedQuery;
	}
		
	@Override
	public String toString(){
		return getEncodedQuery(getCompletedQuery());
	}
}
