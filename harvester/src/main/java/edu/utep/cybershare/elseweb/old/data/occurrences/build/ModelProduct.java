package edu.utep.cybershare.elseweb.old.data.occurrences.build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Region;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Dataset;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Layer;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Manifestation;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Projection;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Species;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.SpeciesOccurrenceSet;

public class ModelProduct {
	
	private HashMap <String, Region> regions;
	private HashMap <String, Dataset> datasets;
	private HashMap <String, Layer> layers;
	private HashMap <String, Manifestation> manifestations;
	private HashMap <String, Species> species;
	private HashMap <String, SpeciesOccurrenceSet> occurrenceSets;
	private HashMap <String, Projection> projections;

	public ModelProduct(){
		this.regions = new HashMap <String, Region>();
		this.datasets = new HashMap <String, Dataset>();
		this.layers = new HashMap <String, Layer>();
		this.manifestations = new HashMap <String, Manifestation>();
		this.species = new HashMap <String, Species>();
		this.occurrenceSets = new HashMap <String, SpeciesOccurrenceSet>();
		this.projections = new HashMap<String, Projection>();
	}
	
	public List<Region> getRegions(){return new ArrayList<Region>(regions.values());}
	public List<Layer> getLayers(){return new ArrayList<Layer>(layers.values());}
	public List<Manifestation> getManifestations(){return new ArrayList<Manifestation>(this.manifestations.values());}
	public List<Species> getSpecies(){return new ArrayList<Species>(this.species.values());}
	public List<SpeciesOccurrenceSet> getOccurrenceSets(){return new ArrayList<SpeciesOccurrenceSet>(this.occurrenceSets.values());}
	public List<Projection> getProjections(){return new ArrayList<Projection>(this.projections.values());}
	public List<Dataset> getDatasets(){return new ArrayList<Dataset>(this.datasets.values());}
	
	public Projection getProjection(String key){
		Projection object = this.projections.get(key);
		if(object == null){
			object = new Projection(key);
			this.projections.put(key, object);
		}
		return object;
	}
	
	public Region getRegion(String key){
		Region object = this.regions.get(key);
		if(object == null){
			object = new Region(key);
			this.regions.put(key, object);
		}
		return object;
	}
	
	public Dataset getDataset(String key){
		Dataset object = this.datasets.get(key);
		if(object == null){
			object = new Dataset(key);
			this.datasets.put(key, object);
		}
		return object;
	}
	
	public Layer getLayer(String key){
		Layer object = this.layers.get(key);
		if(object == null){
			object = new Layer(key);
			this.layers.put(key, object);
		}
		return object;
	}
	
	public Manifestation getManifestation(String key){
		Manifestation object = this.manifestations.get(key);
		if(object == null){
			object = new Manifestation(key);
			this.manifestations.put(key, object);
		}
		return object;
	}
	
	public Species getSpecies(String key){
		Species object = this.species.get(key);
		if(object == null){
			object = new Species(key);
			this.species.put(key, object);
		}
		return object;
	}

	public SpeciesOccurrenceSet getSpeciesOccurrenceSet(String key){
		SpeciesOccurrenceSet object = this.occurrenceSets.get(key);
		if(object == null){
			object = new SpeciesOccurrenceSet(key);
			this.occurrenceSets.put(key, object);
		}
		return object;
	}
}
