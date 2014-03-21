package edu.utep.cybershare.elseweb.services.specification.translation;

import java.util.HashMap;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class AlgorithmDescription {
	
	private String algorithmURI;
	private String paramsCollectionClassURI;
	private HashMap<String,String> paramClassURIs;
	
	public AlgorithmDescription(Resource algorithm){
		init(algorithm);
	}
	
	public String getAlgorithmURI() {
		return algorithmURI;
	}

	public String getParamsCollectionClassURI() {
		return paramsCollectionClassURI;
	}

	public String getParamClassURI(String paramName) {
		return this.paramClassURIs.get(paramName);
	}

	private void init(Resource algorithm){
		//set algorithmURI
		this.algorithmURI = algorithm.getURI();

		//set paramCollectionClassURI
		Resource parameterCollectionClass = algorithm.getPropertyResourceValue(Resources.behaviorControlledBy);
		this.paramsCollectionClassURI = parameterCollectionClass.getURI();
		
		//set paramClassURIs
		this.paramClassURIs = new HashMap<String,String>();
		StmtIterator iterator = parameterCollectionClass.listProperties(Resources.hasParameterMember);
		Statement statement;
		Resource paramClassResource;
		String paramClassURI;
		String paramName;
		while(iterator.hasNext()){
			statement = iterator.next();
			paramClassResource = statement.getObject().asResource();
			paramName = paramClassResource.getProperty(Resources.hasParameterName).getLiteral().getString();			
			paramClassURI = paramClassResource.getURI();
			
			this.paramClassURIs.put(paramName, paramClassURI);
		}
	}
	
	private static class Resources{
		private static Model m_model = ModelFactory.createDefaultModel();

		private static final String lifemapperNamespace = "http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl#";
		private static final String modellingNamespace = "http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-modelling.owl#";
		
		//Properties
		public static final Property behaviorControlledBy = m_model.createProperty(lifemapperNamespace + "behaviorControlledBy");
		public static final Property hasParameterMember = m_model.createProperty(lifemapperNamespace + "hasParameterMember");
		public static final Property hasParameterName = m_model.createProperty(modellingNamespace + "hasParameterName");		
	}
}
