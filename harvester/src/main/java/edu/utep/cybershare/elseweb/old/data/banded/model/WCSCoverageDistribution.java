package edu.utep.cybershare.elseweb.old.data.banded.model;

import java.net.URI;

public class WCSCoverageDistribution extends Element {

	private URI accessURI;
	private URI downloadURI;
	private URI format;
	private String mediaType;
	
	public WCSCoverageDistribution(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSet_mediaType(){
		return this.getMediaType() != null;
	}
	
	public boolean isSet_format(){
		return this.getFormat() != null;
	}
	
	public boolean isSet_accessURI(){
		return this.getAccessURI() != null;
	}
	
	public boolean isSet_downloadURI(){
		return this.getDownloadURI() != null;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public URI getAccessURI() {
		return accessURI;
	}

	public void setAccessURI(URI accessURI) {
		this.accessURI = accessURI;
	}

	public URI getDownloadURI() {
		return downloadURI;
	}

	public void setDownloadURI(URI downloadURI) {
		this.downloadURI = downloadURI;
	}

	public URI getFormat() {
		return format;
	}

	public void setFormat(URI format) {
		this.format = format;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
}
