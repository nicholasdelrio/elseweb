package edu.utep.cybershare.elseweb.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ServerInformation {
	
	private static final String PROPERTIES_FILE_NAME = "service.properties";
	private static final String SPECIFICATIONS_DIRECTORY_NAME = "/specifications/";	
	private static final String WEBAPPS = "webapps/";
	
	private File specificationsDir;
	private URL specificationsDirURL;
	
	public ServerInformation(){
		Properties properties = getServiceProperties(PROPERTIES_FILE_NAME);
		
		String tomcatHomePath = ensureTrailingForwardSlash(properties.getProperty("service.server.tomcat.home"));
		String webappName = properties.getProperty("service.server.webapp.name");		
		String serverURL = ensureTrailingForwardSlash(properties.getProperty("service.server.url"));

		specificationsDir = new File(tomcatHomePath + WEBAPPS + webappName + SPECIFICATIONS_DIRECTORY_NAME);		
		String specificationsDirURLString = serverURL + webappName + SPECIFICATIONS_DIRECTORY_NAME;
		specificationsDirURL = getURL(specificationsDirURLString);		
	}
	
	private static URL getURL(String urlString){
		URL url = null;
		try{url = new URL(urlString);}
		catch(Exception e){e.printStackTrace();}
		return url;
	}
				
	private static String ensureTrailingForwardSlash(String path){
		String formattedPath = path;
		if(!path.endsWith("/"))
			formattedPath += "/";
		
		return formattedPath;
	}
		
	public static Properties getServiceProperties(String propertiesName) {
		Properties moduleProps = new Properties();
		
		try{
			InputStream propsFile = FileSupport.class.getResourceAsStream("/" + propertiesName);
			moduleProps.load(propsFile);
		}catch(Exception e){e.printStackTrace();}	
		return moduleProps;
	}
	
	public File getSpecificationsDir(){return this.specificationsDir;}
	public URL getSpecificationsDirURL(){return this.specificationsDirURL;}
	
	public File getSpecificationFilePath(File fileName){
		return new File(getSpecificationsDir(), fileName.getName());
	}
	
	public URL getSpecificationURL(File fileName){
		String urlString = this.getSpecificationsDirURL().toString() + fileName.getName();
		return getURL(urlString);
	}
}
