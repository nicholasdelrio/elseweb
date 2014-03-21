package edu.utep.cybershare.elseweb.build.edac.services;

import java.net.URL;

import edu.utep.cybershare.elseweb.build.edac.services.source.edac.WCSDigest;
import edu.utep.cybershare.elseweb.build.edac.services.source.edac.WCSDigests;

public class Director {
	
	private Builder builder;
		
	public Director(Builder builder){
		this.builder = builder;
	}

	public void construct(WCSDigests digests){
		int counter = 1;
		for(WCSDigest digest : digests){

			System.out.println("count: " + counter++);
			
			//used to name the elements of the model
			int baseID = digest.getID();
			builder.setBaseID(baseID);
			
			//build entity
			builder.buildEntity(digest.getThemekey());
									
			//build Characteristic
			builder.buildCharacteristic(digest.getThemekey());
			
			//build Region
			builder.buildRegion(digest.getLeftLongitude(), digest.getRightLongitude(), digest.getLowerLatitude(), digest.getUpperLatitude());
			
			//build Duration
			builder.buildDuration(digest.getStartDate(), digest.getEndDate());
						
			//build Dataset
			builder.buildService(digest.getFGDCThemes().getTheme_EDAC_Prism(), digest.getWcsService(), getJSONDigestURL(digest));
			
			builder.assemble();
		}
	}
	
	private URL getJSONDigestURL(WCSDigest digest){
		String prefix = "http://gstore.unm.edu/apps/epscor/datasets/";
		String postfix = "/services.json";
		try{return new URL(prefix + digest.getUUID() + postfix);}
		catch(Exception e){e.printStackTrace();}
		return null;
	}
}
