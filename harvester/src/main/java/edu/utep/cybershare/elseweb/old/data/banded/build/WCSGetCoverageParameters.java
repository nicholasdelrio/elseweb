package edu.utep.cybershare.elseweb.old.data.banded.build;

public class WCSGetCoverageParameters {
	
	private static final String EQUALS = "=";

	private static final String VERSION = "VERSION";
	private String version = "1.1.2";
	
	private static final String SERVICE = "SERVICE";
	private String service = "WCS";
	
	private static final String REQUEST = "REQUEST";
	private String request = "GetCoverage";
	
	private static final String CRS = "CRS";
	private String crs = "EPSG:4326";

	private static final String COVERAGE = "COVERAGE";
	private String coverage;
	
	private static final String BBOX = "BBOX";
	private BBox bbox;
	
	private static final String WIDTH = "WIDTH";
	private double width;
	
	private static final String HEIGHT = "HEIGHT";
	private double height;
	
	private static final String FORMAT = "FORMAT";
	private String format;
	
	public String getVersionBinding(){
		return VERSION + EQUALS + version;
	}
	
	public String getServiceBinding(){
		return SERVICE + EQUALS + service;
	}
	
	public String getRequestBinding(){
		return REQUEST + EQUALS + request;
	}
	
	public String getCRSBinding(){
		return CRS + EQUALS + crs;
	}
	
	public void setFormat(String format){
		this.format = format;
	}
	
	public String getFormatBinding(){
		return FORMAT + EQUALS + format;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	
	public String getHeightBinding(){
		return HEIGHT + EQUALS + height;
	}
	
	public void setWidth(double width){
		this.width = width;
	}
	
	public String getWidthBinding(){
		return WIDTH + EQUALS + width;
	}
	
	public void setCoverage(String coverage){
		this.coverage = coverage;
	}
	
	public String getCoverageBinding(){
		return COVERAGE + EQUALS + coverage;
	}
	
	public void setBBox(double llon, double llat, double rlon, double ulat){
		BBox bbox = new BBox();
		bbox.setLLon(llon);
		bbox.setLLat(llat);
		bbox.setRLon(rlon);
		bbox.setULat(ulat);
		
		this.bbox = bbox;
	}
	
	public String getBBoxBinding(){
		return BBOX + EQUALS + bbox;
	}
	
	public class BBox {
		
		private double llon;
		private double llat;
		private double rlon;
		private double ulat;
		
		public void setLLon(double llon){
			this.llon = llon;
		}
		
		public void setLLat(double llat){
			this.llat = llat;
		}
		
		public void setRLon(double rlon){
			this.rlon = rlon;
		}
		
		public void setULat(double ulat){
			this.ulat = ulat;
		}
		
		public String toString(){
			return llon + "," + llat + "," + rlon + "," + ulat;
		}
	}
}
