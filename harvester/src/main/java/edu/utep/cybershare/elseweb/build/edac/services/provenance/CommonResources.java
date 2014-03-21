package edu.utep.cybershare.elseweb.build.edac.services.provenance;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.ontology.BoxedGeographicRegion;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.PayloadFormat;
import edu.utep.cybershare.elseweb.ontology.Projection;

public class CommonResources {

	private BoxedGeographicRegion region;
	private PayloadFormat esriGrid;
	private PayloadFormat tiff;
	private PayloadFormat hdf5;
	private Projection projection;

	
	public CommonResources(Factory factory, Inventory inventory){
		//esri grid format
		esriGrid = factory.createPayloadFormat("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#esri-grid");
		inventory.addToInventory(esriGrid);
		
		//tiff format
		tiff = factory.createPayloadFormat("http://provenanceweb.org/format/mime/image/tiff");
		inventory.addToInventory(tiff);
		
		//hdf5 format
		hdf5 = factory.createPayloadFormat("http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hdf5");
		inventory.addToInventory(hdf5);
		
		//a region
		region = factory.createBoxedGeographicRegion(inventory.getRandomInstanceURI("region"));
		region.addHasLeftLongitude(-110);
		region.addHasRightLongitude(-107);
		region.addHasLowerLatitude(30);
		region.addHasUpperLatitude(40);
		inventory.addToInventory(region);
		
		//a projection
		projection = factory.createProjection(inventory.getRandomInstanceURI("projection"));
		projection.addHasEPSGCode(4326);
	}
	
	public BoxedGeographicRegion getRegion(){return region;}
	public PayloadFormat getESRIGrid(){return esriGrid;}
	public Projection getWSG84Projection(){return projection;}
	public PayloadFormat getTIFF(){return tiff;}
	public PayloadFormat getHDF5(){return hdf5;}
}
