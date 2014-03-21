package edu.utep.cybershare.elseweb.old.data.banded.util;

import java.util.Hashtable;

import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigest;
import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigests;
import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.fgdc.theme.Themes;

public class EntityMeasurementTypes {

	private Hashtable<String,Integer> types;
	
	public EntityMeasurementTypes(){
		types = new Hashtable<String,Integer>();
		
		populateEntityMeasurementTypes();
	}

	private void populateEntityMeasurementTypes(){
		//get our data source and pass to director
		WCSDigests digests = new WCSDigests(7000, 0);
		System.out.println("Number of WCS digests found: " + digests.size());
		
		for(WCSDigest digest : digests)
			addEntityMeasurementType(digest.getFGDCThemes());
	}
	
	private String getKey(Themes themes){
		if(themes.getTheme_CF() != null)
			return "CF: " + themes.getTheme_CF().getThemekey();
		else if(themes.getTheme_GCMD_Science() != null)
			return "GCMD_Science: " + themes.getTheme_GCMD_Science().getThemekey();
		else //if(themes.getTheme_ISO_19115_Topic_Categories() != null)
			return "ISO: " + themes.getTheme_ISO_19115_Topic_Categories().getThemekey();
	}
	
	private void addEntityMeasurementType(Themes themes){
		String key = getKey(themes);
		
		Integer count = types.get(key);
		int counter;
		if(count == null)
			count = new Integer(0);
		
		// need to use +1 rather than ++ since count is an Integer object
		counter = count + 1;
		types.put(key, new Integer(counter));
	}
	
	public void printDistribution(){
		Integer count;
		for(String measurementEntityType : types.keySet()){
			count = types.get(measurementEntityType);
			System.out.println("EntityMeasurementType: " + measurementEntityType + ", Count: " + count);
		}
	}
	
	public static void main(String[] args){
		EntityMeasurementTypes types = new EntityMeasurementTypes();
		types.printDistribution();
	}
}
