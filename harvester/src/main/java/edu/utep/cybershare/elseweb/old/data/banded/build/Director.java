package edu.utep.cybershare.elseweb.old.data.banded.build;

import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigest;
import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigests;

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
			
			//build Agent
			builder.buildAgent(digest.getFGDCThemes().getTheme_EDAC_Prism());
			
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
			
			builder.assemble();
		}
	}
}
