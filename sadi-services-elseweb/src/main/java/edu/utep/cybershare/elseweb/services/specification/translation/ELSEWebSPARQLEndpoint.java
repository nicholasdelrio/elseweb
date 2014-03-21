package edu.utep.cybershare.elseweb.services.specification.translation;

import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import edu.utep.cybershare.elseweb.services.util.HTTPGetUtils;
import edu.utep.cybershare.elseweb.services.util.HTTPPostUtils;

public class ELSEWebSPARQLEndpoint {
	
	private static final String ENDPOINT_URL = "http://visko.cybershare.utep.edu/sparql";
	private static final String PROVENANCE_GRAPH_URI = "http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/sadi/provenance/sadi-prov.owl";	
	private static final String NEWLINE = "\n";
	
	private String endpoint;
	private String endpointAuth;
	private String formatParameter;
	
	public ELSEWebSPARQLEndpoint(){
		this.endpoint = ENDPOINT_URL;
		this.endpointAuth = this.endpoint + "-graph-crud-auth";
		this.formatParameter = "&format=application%2frdf%2Bxml";
	}
	
	public void updateProvenance(String turtleContent){
		try{
			String requestString = this.endpointAuth + "?graph=" + PROVENANCE_GRAPH_URI;
			
			System.out.println("updating prov graph");
			System.out.println(requestString);
			
			URL requestURL = new URL(requestString);
			HTTPPostUtils.getInstance().postText(requestURL, turtleContent, "elseweb", "elseweb1");
		}catch(Exception e){e.printStackTrace();}
	}
	
	public String getAlgorithm(String algorithmCode){
		String queryString = this.getSelectAlgorithmQuery(algorithmCode);
		System.out.println("select Algorith Description query:");
		System.out.println(queryString);
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
		ResultSet results = qexec.execSelect();
		
		String algorithmURI = null;
		if(results.hasNext())
			algorithmURI = results.next().getResource("?algorithm").getURI();
		
		return algorithmURI;
	}
	
	public AlgorithmDescription getAlgorithDescription(String algorithmCode){
		String queryString = this.getConstructAlgorithmQuery(algorithmCode);
		System.out.println("construct Algorithm Description query:");
		System.out.println(queryString);
		
		AlgorithmDescription description = null;
		/*This is an incredibly stupid hack because the version of ARQ sadi supports is fucking old*/
		try{
			String requestString = this.endpoint + "?query=" + URLEncoder.encode(queryString, "UTF-8") + this.formatParameter;
			URL requestURL = new URL(requestString);
		
			String queryResults = HTTPGetUtils.getInstance().downloadText(requestURL);
			System.out.println("results:");
			System.out.println(queryResults);
			
			StringReader reader = new StringReader(queryResults);
		
			Model model = ModelFactory.createDefaultModel();
			model.read(reader, null);
				
			String algorithmURI = this.getAlgorithm(algorithmCode);
			description = new AlgorithmDescription(model.getResource(algorithmURI));
		}
		catch(Exception e){e.printStackTrace();}
		return description;
	}
	
	public Model constructOccurrenceSet(String occurrenceSetID){
		String queryString = this.getConstructOccurrenceSetQuery(occurrenceSetID);
		System.out.println("construct OccurrenceSet query:");
		System.out.println(queryString);
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
		Model model = qexec.execConstruct();
		
		return model;
	}
	
	public String getOccurrenceSet(String occurrenceSetID){
		String queryString = this.getSelectOccurrenceSetQuery(occurrenceSetID);
		System.out.println("select OccurrenceSet query:");
		System.out.println(queryString);
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
		ResultSet results = qexec.execSelect();
		
		QuerySolution solution;
		String occurrenceSetURI = null;
		if(results.hasNext()){
			solution = results.next();
			occurrenceSetURI = solution.getResource("?occurrenceSet").getURI();
		}

		return occurrenceSetURI;
	}
	
	public Model constructInputWCSDatasets(List<String> datasetURIs){ 
		Model aggregatedModel = ModelFactory.createDefaultModel();
		Model manifestationModel;
		
		for(String datasetURI : datasetURIs){
			manifestationModel = this.constructInputWCSDataset(datasetURI);
			aggregatedModel.add(manifestationModel);
		}
		return aggregatedModel;
	}
	
	private Model constructInputWCSDataset(String datasetURI){
		String queryString = this.getConstructInputWCSDatasetQuery(datasetURI);
		System.out.println("construct InputWCSDataset query:");
		System.out.println(queryString);
		
		/*This is an incredibly stupid hack because the version of ARQ sadi supports is fucking old*/
		Model model = ModelFactory.createDefaultModel();
		try{
			String requestString = this.endpoint + "?query=" + URLEncoder.encode(queryString, "UTF-8") + this.formatParameter;
			URL requestURL = new URL(requestString);
		
			String queryResults = HTTPGetUtils.getInstance().downloadText(requestURL);
			StringReader reader = new StringReader(queryResults);

			model.read(reader, null);
		}
		catch(Exception e){e.printStackTrace();}			
		return model;
	}
	
	private String getSelectAlgorithmQuery(String algorithmCode){
		String query =
				this.getPrefixes() + NEWLINE +
				"select ?algorithm" + NEWLINE +				
				"where" + NEWLINE +
				"{" + NEWLINE +
				"?algorithm a elseweb-lifemapper:LifemapperAlgorithm." + NEWLINE +
				"?algorithm elseweb-lifemapper:hasAlgorithmCode \"" + algorithmCode + "\"^^xsd:string." + NEWLINE +
				"}";
		
		return query;
	}
	
	private String getConstructAlgorithmQuery(String algorithmCode){
		String query =
				this.getPrefixes() + NEWLINE +
				"construct" + NEWLINE +
				"{" + NEWLINE +
				"?algorithm elseweb-lifemapper:behaviorControlledBy ?paramCollectionClassURI. " + NEWLINE +
				"?paramCollectionClassURI elseweb-lifemapper:hasParameterMember ?paramClassURI." + NEWLINE +
				"?paramClassURI elseweb-modelling:hasParameterName ?paramName." + NEWLINE +
				"}" + NEWLINE +
				
				"where" + NEWLINE +
				"{" + NEWLINE +
				"?algorithm a elseweb-lifemapper:LifemapperAlgorithm." + NEWLINE +
				"?algorithm elseweb-lifemapper:hasAlgorithmCode \"" + algorithmCode + "\"^^xsd:string." + NEWLINE +
				"?paramDescriptions elseweb-lifemapper:describesBehaviorOf ?algorithm." + NEWLINE +
				"?paramDescriptions elseweb-lifemapper:hasParameterCollectionClass ?paramCollectionClass." + NEWLINE +
				"?paramDescriptions elseweb-lifemapper:hasParameterDescription ?paramDescription." + NEWLINE +
				"?paramDescription elseweb-lifemapper:hasParameterClass ?paramClass." + NEWLINE +
				"?paramDescription elseweb-modelling:hasParameterName ?paramName." + NEWLINE +
				"BIND(IRI(?paramCollectionClass) AS ?paramCollectionClassURI)" + NEWLINE +
				"BIND(IRI(?paramClass) AS ?paramClassURI)" + NEWLINE +
				"}";
		return query;
	}
	
	private String getConstructOccurrenceSetQuery(String occurrenceSetID){
		String query =
				this.getPrefixes() + NEWLINE +
				"construct" + NEWLINE +
				"{" + NEWLINE +
				"?occurrenceSet a elseweb-lifemapper:SpeciesOccurrenceSet." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasOccurrenceSetID " + occurrenceSetID + " ." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasOccurrenceOfSpecies ?species ." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasNumberOfOccurrences ?numOccurrences ." + NEWLINE +
				"}" + NEWLINE +
				"where" + NEWLINE +
				"{" + NEWLINE +
				"?occurrenceSet a elseweb-lifemapper:SpeciesOccurrenceSet." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasOccurrenceSetID " + occurrenceSetID + " ." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasOccurrenceOfSpecies ?species ." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasNumberOfOccurrences ?numOccurrences ." + NEWLINE +
				"}" + NEWLINE;
		return query;
	}
	
	private String getSelectOccurrenceSetQuery(String occurrenceSetID){
		String query =
				this.getPrefixes() + NEWLINE +
				"select ?occurrenceSet" + NEWLINE +
				"where" + NEWLINE +
				"{" + NEWLINE +
				"?occurrenceSet a elseweb-lifemapper:SpeciesOccurrenceSet." + NEWLINE +
				"?occurrenceSet elseweb-lifemapper:hasOccurrenceSetID " + occurrenceSetID + "." + NEWLINE +
				"}" + NEWLINE;
		return query;
	}
	
	private String getConstructInputWCSDatasetQuery(String datasetURI){
		String turtleURI = getTurtleURI(datasetURI);
		String query = 
				this.getPrefixes() + NEWLINE +
				
				"construct" + NEWLINE +
				"{" + NEWLINE +
				turtleURI + " a elseweb-lifemapper:InputWCSDataset ." + NEWLINE +
				turtleURI + " elseweb-data:coversRegion ?region." + NEWLINE +
				"?region elseweb-data:hasLeftLongitude ?llon." + NEWLINE +
				"?region elseweb-data:hasRightLongitude ?rlon." + NEWLINE +
				"?region elseweb-data:hasLowerLatitude ?llat." + NEWLINE +
				"?region elseweb-data:hasUpperLatitude ?ulat." + NEWLINE +
				turtleURI + " elseweb-data:hasManifestation ?manif." + NEWLINE +
				"?manif a elseweb-edac:RGISWCSManifestation." + NEWLINE +
				"?manif elseweb-data:hasCapabilitiesDocumentURL ?capabilitiesURLString." + NEWLINE +
				"?manif elseweb-edac:hasJSONCapabilitiesDigestURL ?jsonURLString." + NEWLINE +
				"}" + NEWLINE +
				
				"where" + NEWLINE +
				"{" + NEWLINE +
				turtleURI + " elseweb-data:hasManifestation ?manif." + NEWLINE +
				turtleURI + " elseweb-data:coversRegion ?region." + NEWLINE +
				"?region elseweb-data:hasLeftLongitude ?llon." + NEWLINE +
				"?region elseweb-data:hasRightLongitude ?rlon." + NEWLINE +
				"?region elseweb-data:hasLowerLatitude ?llat." + NEWLINE +
				"?region elseweb-data:hasUpperLatitude ?ulat." + NEWLINE +
				"?manif a elseweb-edac:RGISWCSManifestation." + NEWLINE +
				"?manif elseweb-data:hasCapabilitiesDocumentURL ?capabilitiesURL." + NEWLINE +
				"?manif elseweb-edac:hasJSONCapabilitiesDigestURL ?jsonURL." + NEWLINE +
				"BIND(STR(?capabilitiesURL) AS ?capabilitiesURLString)" + NEWLINE +
				"BIND(STR(?jsonURL) AS ?jsonURLString)" + NEWLINE +
				"}" + NEWLINE;
		
		return query;
		
	}
	
	private String getTurtleURI(String uri){
		return "<" + uri + ">";
	}
	
	private String getPrefixes(){
		String prefixes =
				"prefix elseweb-data: <http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#>" + NEWLINE +
				"prefix elseweb-edac: <http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#>" + NEWLINE +
				"prefix elseweb-lifemapper: <http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#>" + NEWLINE +
				"prefix elseweb-modelling: <http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-modelling.owl#>" + NEWLINE +
				"prefix xsd: <http://www.w3.org/2001/XMLSchema#>" + NEWLINE;
		
		return prefixes;
	}
}
