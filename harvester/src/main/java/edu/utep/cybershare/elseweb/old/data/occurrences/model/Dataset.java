package edu.utep.cybershare.elseweb.old.data.occurrences.model;

import java.util.List;
import java.util.ArrayList;

public class Dataset extends Element {

	private Manifestation manifestation;
	private ArrayList<Layer> layers;
	private Region region;
	private Projection projection;
	
	public Dataset(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		layers = new ArrayList<Layer>();
	}
	public boolean isSet_Projection(){return this.projection != null;}
	public boolean isSet_manifestation(){return manifestation != null;}
	public boolean isSet_layers(){return layers.size() > 0;}
	public boolean isSet_region(){return region != null;}
	
	public void setManifestation(Manifestation manifest){
		this.manifestation = manifest;
	}
	
	public void setProjection(Projection projection){this.projection = projection;}
	public Projection getProjection(){return this.projection;}
	
	public void addLayer(Layer layer){
		layers.add(layer);
	}
	public void setRegion(Region region){
		this.region = region;
	}
	
	public Manifestation getManifestation(){return manifestation;}
	public Region getRegion(){return region;}
	public List<Layer> getLayers(){return layers;}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
