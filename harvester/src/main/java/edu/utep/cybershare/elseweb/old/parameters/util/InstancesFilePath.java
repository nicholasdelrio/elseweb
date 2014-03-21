package edu.utep.cybershare.elseweb.old.parameters.util;

public class InstancesFilePath {

	public static final String INSTANCES_BASE_URL = "http://visko.cybershare.utep.edu/linked-data/lifemapper/parameter-descriptions/";
	//public static final String INSTANCES_BASE_URL = "http://localhost:8888/linked-data/lifemapper/parameter-descriptions/";
	
	private static final String BASE_URL = "http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/parameter-descriptions/";
	
	private static final String DOCUMENT_NAME = "parameter-descriptions.owl";
	public static final String DOCUMENT_URL = BASE_URL + DOCUMENT_NAME;
		
	public static final String DUMP_DIR = "../ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/parameter-descriptions/";
	public static final String DUMP_PATH = DUMP_DIR + DOCUMENT_NAME;
}
