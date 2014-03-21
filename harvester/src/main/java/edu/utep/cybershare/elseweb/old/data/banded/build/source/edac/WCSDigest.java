package edu.utep.cybershare.elseweb.old.data.banded.build.source.edac;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.fgdc.FGDCDocument;
import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.fgdc.theme.Themes;

public class WCSDigest {
	
	private String name;
	private int lastUpdate;
	private int id;
	private String taxonomy;
	private URL tiffDownload;
	private String description;
	private URL FGDC_metadataXML;
	private int epsg;
	private double leftLongitude;
	private double rightLongitude;
	private double lowerLatitude;
	private double upperLatitude;
	private URL wmsService;
	private URL wcsServiceEndpoint;
	private URL wcsService;
	private URL preview;
	private int gr;
	private String subtheme;
	private String theme;
	private String groupname;
	private Calendar startDate;
	private Calendar endDate;

	private Themes fgdcThemes;

	private JSONObject jsonDigest;
	
	private static TimeZone mountainTimeZone = TimeZone.getTimeZone("America/Denver");
	
	public WCSDigest(JSONObject wcsJSONDigest){
		jsonDigest = wcsJSONDigest;

		// first find and set URL to FDGC meta data and the populate dependent fields
		this.setMetadata();
		FGDCDocument fgdcData = new FGDCDocument(getFGDCXMLURL());
		fgdcThemes = fgdcData.getThemes();
		
		// the rest of the fields can be found directly in the JSON digest
		this.setName();
		this.setCategories();
		this.setDescription();
		this.setLastUpdate();
		
		this.setPreview();
		this.setServices();
		this.setSpatial();
		this.setTaxonomy();
		this.setDownloads();
		this.setID();
		this.setValid_Dates();
	}
	
	public String getName(){
		return name;
	}
	
	private void setName(){
		try{this.name =  jsonDigest.getString("name");}
		catch(Exception e){e.printStackTrace();}		
	}
	
	public int getLastUpdate() {
		return lastUpdate;
	}
	private void setLastUpdate() {
		try{this.lastUpdate =  Integer.valueOf(jsonDigest.getString("lastupdate"));}
		catch(Exception e){e.printStackTrace();}
	}
	public int getID() {
		return id;
	}
	private void setID() {
		try{this.id =  jsonDigest.getInt("id");}
		catch(Exception e){e.printStackTrace();}
	}

	public String getTaxonomy() {
		return taxonomy;
	}
	private void setTaxonomy() {
		try{this.taxonomy =  jsonDigest.getString("lastupdate");}
		catch(Exception e){e.printStackTrace();}
	}

	public URL getTiffDownload() {
		return tiffDownload;
	}

	private void setDownloads() {
		try {
			JSONArray downloads = jsonDigest.getJSONArray("downloads");
			JSONObject download0 = downloads.getJSONObject(0);
			tiffDownload = new URL(download0.getString("tif"));
		}
		catch(Exception e){e.printStackTrace();}
	}

	public String getDescription() {
		return description;
	}

	private void setDescription() {
		try{this.description =  jsonDigest.getString("description");}
		catch(Exception e){e.printStackTrace();}
	}
	
	private void setMetadata() {
		try {
			JSONArray metadata = jsonDigest.getJSONArray("metadata");
			JSONObject metadata0 = metadata.getJSONObject(0);
			JSONObject fgdc = metadata0.getJSONObject("FGDC-STD-012-2002");
			FGDC_metadataXML = new URL(fgdc.getString("xml"));
		}
		catch(Exception e){e.printStackTrace();System.out.println(this.jsonDigest);}
	}

	public URL getFGDC_metadataXML() {
		return FGDC_metadataXML;
	}
	
	private void setSpatial() {
		try {
			JSONObject spatial = jsonDigest.getJSONObject("spatial");
			epsg = spatial.getInt("epsg");
			JSONArray bbox = spatial.getJSONArray("bbox");
			
			leftLongitude = bbox.getDouble(0);
			lowerLatitude = bbox.getDouble(1);
			rightLongitude = bbox.getDouble(2);
			upperLatitude = bbox.getDouble(3);			
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public int getEPSG() {
		return epsg;
	}
	
	public double getLeftLongitude() {
		return leftLongitude;
	}

	public double getRightLongitude() {
		return rightLongitude;
	}
	
	public double getLowerLatitude() {
		return lowerLatitude;
	}

	public double getUpperLatitude() {
		return upperLatitude;
	}

	private void setServices() {

		try{
			JSONArray services = jsonDigest.getJSONArray("services");
			JSONObject services0 = services.getJSONObject(0);
			JSONObject services1 = services.getJSONObject(1);
			
			String wcsServiceString = services1.getString("wcs");
			
			wmsService = new URL(services0.getString("wms"));
			wcsService = new URL(wcsServiceString);
			wcsServiceEndpoint = new URL(wcsServiceString.split("wcs?")[0]);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	public URL getWcsService() {
		return wcsService;
	}
	
	public URL getWmsService() {
		return wmsService;
	}

	public URL getWcsServiceEndpoint(){
		return wcsServiceEndpoint;
	}
	
	public URL getPreview() {
		return preview;
	}
	
	private void setPreview() {
		try{
			preview = new URL(jsonDigest.getString("preview"));
		}catch(Exception e){e.printStackTrace();}
	}
	
	public int getGr() {
		return gr;
	}
	protected void setGr(int gr) {
		try{
			gr = jsonDigest.getInt("gr");
		}catch(Exception e){e.printStackTrace();}
	}
		
	private void setCategories() {
		try{
			JSONArray categories = jsonDigest.getJSONArray("categories");
			JSONObject categories0 = categories.getJSONObject(0);
			theme = categories0.getString("theme");
			groupname = categories0.getString("groupname");
			subtheme = categories0.getString("subtheme");			
		}catch(Exception e){e.printStackTrace();}
	}
	
	public String getSubtheme() {
		return subtheme;
	}
	
	public String getTheme() {
		return theme;
	}
	public String getGroupName() {
		return groupname;
	}
	
	private String getFGDCXMLURL(){
		String fgdcXMLURL = null;
		try{
			JSONArray metadataArray = jsonDigest.getJSONArray("metadata");
			JSONObject metadata0 = metadataArray.getJSONObject(0);
			JSONObject fgdcObject = metadata0.getJSONObject("FGDC-STD-012-2002");
			fgdcXMLURL = fgdcObject.getString("xml");
		}catch(Exception e){
			e.printStackTrace();
		}
		return fgdcXMLURL;
	}
	
	private void setValid_Dates() {
		try {
			JSONObject valid_dates = jsonDigest.getJSONObject("valid_dates");
			startDate = WCSDigest.getDate(valid_dates.getString("start"));
			endDate = WCSDigest.getDate(valid_dates.getString("end"));
		}
		catch(Exception e){e.printStackTrace();}
	}

	
	public Calendar getStartDate(){
		return startDate;
	}
	
	public Calendar getEndDate(){
		return endDate;
	}
	
	public String toString(){
		return jsonDigest.toString();
	}	
	
	public Themes getFGDCThemes(){
		return fgdcThemes;
	}
	
	private static Calendar getDate(String fgdcDate){
		int year = Integer.parseInt(fgdcDate.substring(0, 4));
		int day = Integer.parseInt(fgdcDate.substring(4, 6));
		int month = Integer.parseInt(fgdcDate.substring(6, 8));

		GregorianCalendar date = new GregorianCalendar();
		date.clear();
		date.set(year, month, day, 0, 0, 0);
		date.setTimeZone(mountainTimeZone);
		
		return date;
	}
	
	public String getThemekey(){
		if(fgdcThemes.getTheme_CF() != null)
			return fgdcThemes.getTheme_CF().getThemekey();
		else if(fgdcThemes.getTheme_GCMD_Science() != null)
			return fgdcThemes.getTheme_GCMD_Science().getThemekey();
		else //if(themes.getTheme_ISO_19115_Topic_Categories() != null)
			return fgdcThemes.getTheme_ISO_19115_Topic_Categories().getThemekey();
	}
}