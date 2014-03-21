package edu.utep.cybershare.elseweb.services.ogc.wcs.execution;

import java.net.URL;


public class WCSGetCoverageURL {
	
	private static final String AND = "&";
	private String endpoint;
	private WCSGetCoverageParameters params;
	
	public WCSGetCoverageURL(String endpointURL, WCSGetCoverageParameters parameters){
		endpoint = endpointURL + "wcs";
		params = parameters;
	}
	
	public URL getURL(){
		URL getCoverageURL = null;
		String getURLString;
		try{
			getURLString = endpoint + "?";
			getURLString += params.getVersionBinding() + AND;
			getURLString += params.getServiceBinding() + AND;
			getURLString += params.getRequestBinding() + AND;
			getURLString += params.getCoverageBinding() + AND;
			getURLString += params.getCRSBinding() + AND;
			getURLString += params.getBBoxBinding() + AND;
			getURLString += params.getFormatBinding() + AND;
			getURLString += params.getWidthBinding() + AND;
			getURLString += params.getHeightBinding();
		
			getCoverageURL = new URL(getURLString);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return getCoverageURL;
	}
}