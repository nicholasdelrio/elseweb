package edu.utep.cybershare.elseweb.old.data.banded.build.source.edac;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import edu.utep.cybershare.elseweb.old.data.banded.util.FilePath;

public class WCSDigests extends ArrayList<WCSDigest>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*private static final String JSON_DIGEST_BASE_URL = "http://gstore.unm.edu/apps/elseweb/search/datasets.json";*/
	
	private int limit;
	private int size;
	
	public WCSDigests(int limit, int offset){
		if(limit < 1)
			limit = 1;
		if(offset < 0)
			offset = 0;
		
		this.limit = limit;
		this.size = 0;
		
		JSONArray array  = getJSONDigestsArray();
		addJSONDigests(array);
	}
	
	
	private void addJSONDigests(JSONArray array){
		try{
			for(int i = 0; i < array.length(); i ++){
				System.out.println("processing: " + array.getJSONObject(i));
				addWCSDigest(array.getJSONObject(i));
			}
		}catch(Exception e){e.printStackTrace();}		
	}
	
	/*
	private String getURL(int limit, int offset){
		String queryString = 
				"?version=3" +
				"&limit=" + limit +
				"&offset=" + offset;
		return JSON_DIGEST_BASE_URL + queryString;
	}*/
		
	private void addWCSDigest(JSONObject wcsJSONDigest){
		if(size < limit){
			WCSDigest wcsDigest = new WCSDigest(wcsJSONDigest);
			add(wcsDigest);
			size ++;
		}
	}

	private JSONArray getJSONDigestsArray(){
		JSONObject jsonDigests = getJSONDigests();
		JSONArray jsonDigestsArray = null;
		try{jsonDigestsArray = jsonDigests.getJSONArray("results");}
		catch(Exception e){e.printStackTrace();}
		return jsonDigestsArray;
	}
	
	private JSONObject getJSONDigests(){
		String jsonDigestString = getJSONDigestString();
		JSONObject jsonDigests = null;
		try{jsonDigests = new JSONObject(jsonDigestString);}
		catch(Exception e){e.printStackTrace();}
		return jsonDigests;
	}
	
	private String getJSONDigestString(){
        File jsonFile = null;
        String jsonString = null;
        try {
            jsonFile = new File(FilePath.EDAC_SERVICES);            
            FileInputStream fisTargetFile = new FileInputStream(jsonFile);
            jsonString = IOUtils.toString(fisTargetFile, "UTF-8");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return jsonString;
	}
}
