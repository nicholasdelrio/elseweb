package edu.utep.cybershare.elseweb.old.data.occurrences.model;

import java.net.URI;
import java.net.URL;

public class Manifestation extends Element{
	
	private URI formatURI;
	private URL fileDownloadURL;
	private URL landingPageURL;
	
	public Manifestation(String id){
		super(id);
	}
	
	public boolean isSet_formatURI(){return formatURI != null;}
	public boolean isSet_fileDownloadURL(){return fileDownloadURL != null;}
	public boolean isSet_landingPageURL(){return landingPageURL != null;}
	
	public void accept(Visitor visitor){
		visitor.visit(this);
	}

	/**
	 * @return the fileDownloadURL
	 */
	public URL getFileDownloadURL() {
		return fileDownloadURL;
	}

	/**
	 * @param fileDownloadURL the fileDownloadURL to set
	 */
	public void setFileDownloadURL(URL fileDownloadURL) {
		this.fileDownloadURL = fileDownloadURL;
	}

	/**
	 * @return the formatURI
	 */
	public URI getFormatURI() {
		return formatURI;
	}

	/**
	 * @param formatURI the formatURI to set
	 */
	public void setFormatURI(URI formatURI) {
		this.formatURI = formatURI;
	}
	
	public URL getLandingPageURL(){
		return this.landingPageURL;
	}
	
	public void setLandingPageURL(URL landingPage){
		this.landingPageURL = landingPage;
	}
}
