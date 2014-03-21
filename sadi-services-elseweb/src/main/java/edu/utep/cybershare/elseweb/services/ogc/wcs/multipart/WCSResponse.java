package edu.utep.cybershare.elseweb.services.ogc.wcs.multipart;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

import javax.activation.URLDataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import edu.utep.cybershare.elseweb.services.util.FileSupport;
import edu.utep.cybershare.elseweb.services.util.HTTPGetUtils;

public class WCSResponse {
	
	private static final String PROPERTIES_FILE_NAME = "service.properties";
	private static final String OUTPUT_DIRECTORY_NAME = "/output/";
	private static final String PAYLOADS_DIRECTORY_NAME = OUTPUT_DIRECTORY_NAME + "payloads/";	
	private static final String RESPONSES_DIRECTORY_NAME = OUTPUT_DIRECTORY_NAME + "wcsResponses/";
	private static final String WEBAPPS = "webapps/";
	
	private static final String WCS_RESPONSE_FILENAME = "wcsResponse.bin";
	private static final String PAYLOAD_FILENAME = "payload.tif";

	private File responsesDir;
	private File payloadsDir;	
	private URL payloadsDirURL;

	private URL wcsResponseURL;
	private URL payloadURL;
	
	private String uuid;
	
	public WCSResponse(URL wcsResponseURL){
		this.wcsResponseURL = wcsResponseURL;
		this.init();
	}
	
	public WCSResponse(String wcsResponseURLString){
		this.wcsResponseURL = getURL(wcsResponseURLString);
		this.init();
	}
	
	private void init(){
		Properties properties = getServiceProperties(PROPERTIES_FILE_NAME);
		
		String tomcatHomePath = ensureTrailingForwardSlash(properties.getProperty("service.server.tomcat.home"));
		String webappName = properties.getProperty("service.server.webapp.name");		
		String serverURL = ensureTrailingForwardSlash(properties.getProperty("service.server.url"));

		responsesDir = new File(tomcatHomePath + WEBAPPS + webappName + RESPONSES_DIRECTORY_NAME);
		payloadsDir = new File(tomcatHomePath + WEBAPPS + webappName + PAYLOADS_DIRECTORY_NAME);
		
		String payloadsURLString = serverURL + webappName + PAYLOADS_DIRECTORY_NAME;
		payloadsDirURL = getURL(payloadsURLString);		
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
	
	public URL getPayload(){
		byte[] responseContents = HTTPGetUtils.getInstance().downloadBytes(this.wcsResponseURL);
		File multipartResponseFile = dumpWCSResponseFile(responseContents);

		URL fileURL  = getFileProtocolURL(multipartResponseFile);
		System.out.println(fileURL);
		
		File outputFilePath = this.getPayloadFile();
	
		try{
			URLDataSource dataSource = new URLDataSource(fileURL);
			MimeMultipart multipart = new MimeMultipart(dataSource);
			MimeBodyPart coverage = (MimeBodyPart) multipart.getBodyPart(1);
			coverage.saveFile(outputFilePath);
		}catch(Exception e){e.printStackTrace();}
		
		return payloadURL;
	}
	
	private File dumpWCSResponseFile(byte[] contents){
		// get random string
		uuid = UUID.randomUUID().toString();
		
		// output file
		File wcsResponseFile = this.getRandomFile(WCS_RESPONSE_FILENAME);
		File wcsResponseFilePath = new File(this.responsesDir, wcsResponseFile.getName());
		
		// dump file
		FileSupport.writeBinaryFile(contents, wcsResponseFilePath);
		
		return wcsResponseFilePath;
	}
	
	private File getPayloadFile(){
		File payloadFile = getRandomFile(PAYLOAD_FILENAME);
		File payloadFilePath = new File(this.payloadsDir, payloadFile.getName());
		
		this.payloadURL = getURL(payloadsDirURL.toString() + payloadFile.getName());
		
		return payloadFilePath;
	}
	
	private File getRandomFile(String fileName){
		// mint new random file name
		String[] fileNameParts = fileName.split("\\.");
		String name = fileNameParts[0];
		String extension = fileNameParts[1];
		String wcsResponseFileName = name + "-" + uuid + "." + extension;
		File wcsResponseFile = new File(wcsResponseFileName);	
		
		return wcsResponseFile;
	}
	
	public static URL getFileProtocolURL(File inputPath) {
		URL fileURL = null;
		try{fileURL = new URL("file://" + inputPath.getAbsolutePath());}
		catch(Exception e){e.printStackTrace();}
		return fileURL;
	}
	
	public static void main(String[] args){
		try{
			byte[] responseContents = HTTPGetUtils.getInstance().downloadBytes(new URL("http://gstore.unm.edu/apps/epscor/datasets/dc629a6c-5c97-4b6a-9ae3-40f050ea60ae/services/ogc/wcs?VERSION=1.1.2&SERVICE=WCS&REQUEST=GetCoverage&COVERAGE=MYD13Q1_2012185_EVI_MOSAIC&CRS=EPSG:4326&BBOX=-125.021,-66.4792,24.0625,49.9375&FORMAT=image/tiff&WIDTH=1200.0&HEIGHT=1200.0"));
			File responseFile = new File("/Users/nick/Downloads/wcsResponse");
			FileSupport.writeBinaryFile(responseContents, responseFile);
	
			URL fileURL  = new URL("file:" + responseFile.getAbsolutePath());
			System.out.println("file url: " + fileURL);
			
			URLDataSource dataSource = new URLDataSource(fileURL);
			MimeMultipart multipart = new MimeMultipart(dataSource);
			MimeBodyPart coverage = (MimeBodyPart) multipart.getBodyPart(1);
			File outputFilePath = new File("/Users/nick/Downloads/somemap.tif");
			coverage.saveFile(outputFilePath);
			
		}catch(Exception e){e.printStackTrace();}
	}
}