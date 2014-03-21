package edu.utep.cybershare.elseweb.share;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class Endpoint {
	private static URL shareURL;

	private HttpClient client;	
	
	public Endpoint(){		
		client = new HttpClient();
		setShareURL();
	}
	
	private static void setShareURL(){
		try{shareURL = new URL("http://visko.cybershare.utep.edu/cardioSHARE-elseweb/query");}
		catch(Exception e){e.printStackTrace();}
	}
	
	private static String getQueryParameterString(Query shareQuery){
		if(shareQuery.toString() != null)
			return "?query=" + shareQuery;		

		return null;
	}
	
	private static String getStatusParameterString(String taskID){
		if(taskID != null)
			return "?poll=" + taskID;
		return null;
	}
	
	public String getStatus(String taskID){
		String requestURL = shareURL.toString() + getStatusParameterString(taskID);
		return get(requestURL);
	}

	public String submitQuery(Query shareQuery) {
		String requestURL = shareURL.toString() + getQueryParameterString(shareQuery);
		return get(requestURL);
	}
	
	private String get(String requestURL){
		HttpMethod method = new GetMethod(requestURL.toString());
		
		String result = "{}";
		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}

			else{
				// Read the response body.
				byte[] responseBody = method.getResponseBody();

				// Deal with the response.
				// Use caution: ensure correct character encoding and is not binary
				// data
				result = new String(responseBody);
			}

		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
		return result;
	}
}