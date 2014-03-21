package edu.utep.cybershare.elseweb.services.ogc.wcs.execution.digest;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.utep.cybershare.elseweb.services.util.HTTPGetUtils;

public class WCSDigest {
	
	private String name;
	private int id;
	private URL wcsServiceEndpoint;
	
	private JSONObject jsonDigest;
	
	public WCSDigest(URL wcsJSONDigestURL){
		
		String wcsJSONDigestContents = HTTPGetUtils.getInstance().robustDownloadText(wcsJSONDigestURL, 5);
		try{
			jsonDigest = new JSONObject(wcsJSONDigestContents);
			init();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public WCSDigest(JSONObject wcsJSONDigest){
		jsonDigest = wcsJSONDigest;		
		init();
	}
	
	private void init(){
		// the rest of the fields can be found directly in the JSON digest
		this.setName();		
		this.setID();
		this.setWCSServiceEndpoint();
	}
	
	public String getName(){
		return name;
	}
	
	private void setName(){
		try{this.name =  jsonDigest.getString("name");}
		catch(Exception e){e.printStackTrace();}		
	}
	
	public int getID() {
		return id;
	}
	private void setID() {
		try{this.id =  jsonDigest.getInt("id");}
		catch(Exception e){e.printStackTrace();}
	}
	public String toString(){
		return jsonDigest.toString();
	}
	private void setWCSServiceEndpoint() {

		try{
			JSONArray services = jsonDigest.getJSONArray("services");
			JSONObject services1 = services.getJSONObject(1);
			
			String wcsServiceString = services1.getString("wcs");
			wcsServiceEndpoint = new URL(wcsServiceString.split("wcs?")[0]);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	public URL getWCSServiceEndpoint(){
		return this.wcsServiceEndpoint;
	}
}