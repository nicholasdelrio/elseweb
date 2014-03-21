package edu.utep.cybershare.elseweb.old.data.banded.build;

import java.util.HashMap;

import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigest;
import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigests;

public class MaxDiversityMinSizeDirector {
	
	private Builder builder;
	private static final int MAX_OCCURRENCE = 3;
	
	private HashMap<String,Integer> themekeyOccurrences;
	
	public MaxDiversityMinSizeDirector(Builder builder){
		this.builder = builder;
		themekeyOccurrences = new HashMap<String,Integer>();
	}

	public void construct(WCSDigests digests){
		for(WCSDigest digest : digests){
			
			String themekey = digest.getThemekey();
			
			Integer occurrences = themekeyOccurrences.get(themekey);
			if(occurrences != null){
				int occurr = occurrences;
				if(occurr < MAX_OCCURRENCE){
					build(digest);					
					occurr ++;
					themekeyOccurrences.put(themekey, new Integer(occurr));
				}
			}
			else
				themekeyOccurrences.put(themekey, new Integer(0));				
		}
	}
	
	private void build(WCSDigest digest){
		//used to name the elements of the model
		int baseID = digest.getID();
		builder.setBaseID(baseID);
		
		//build entity
		builder.buildEntity(digest.getThemekey());
				
		//build Observation
		builder.buildObservation();
		
		//build Measurement
		builder.buildMeasurement();
		
		//build Characteristic
		builder.buildCharacteristic(digest.getThemekey());
		
		//build Region
		builder.buildRegion(digest.getLeftLongitude(), digest.getRightLongitude(), digest.getLowerLatitude(), digest.getUpperLatitude());
		
		//build Duration
		builder.buildDuration(digest.getStartDate(), digest.getEndDate());
		
		//build Distribution
		builder.buildDistribution(digest.getName(), digest.getWcsServiceEndpoint().toString());
		
		//build Dataset
		builder.buildDataset();
		
		//build Agent
		builder.buildAgent(digest.getFGDCThemes().getTheme_EDAC_Prism());
		
		builder.assemble();
		
	}
}
