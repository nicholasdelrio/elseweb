package edu.utep.cybershare.elseweb.build.edac.services.provenance.modis;

import java.io.File;
import java.net.URL;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.provenance.CommonResources;
import edu.utep.cybershare.elseweb.ontology.Factory;

public class Simulator {
	
	private Factory factory;
	private Inventory inventory;
	private CommonResources resources;
	
	public Simulator(Factory factory, Inventory inventory){
		this.factory = factory;
		this.inventory = inventory;
		this.resources = new CommonResources(factory, inventory);
	}
	
	private void simulate(){
		
		Downloading downloading = new Downloading(factory, inventory, resources);
		try{
			downloading.download(new URL("http://nasa.gov/data/dataset1.hdf"));
			downloading.download(new URL("http://nasa.gov/data/dataset2.hdf"));
			downloading.download(new URL("http://nasa.gov/data/dataset3.hdf"));
		}catch(Exception e){e.printStackTrace();}
		
		Extracting extracting = new Extracting(factory, inventory, resources);
		extracting.extract(downloading.getDownloadedMODISDatasets());
		
		Mosaic mosaic = new Mosaic(factory, inventory, resources);
		mosaic.mosaic(extracting.getExtractedDatasets());
		
		Publishing publishing = new Publishing(factory, inventory);
		publishing.publish(mosaic.getMosaicDataset());		
	}
	
	public static void main(String[] args){
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();		
		String prefix = "http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/edac/services/provenance/modis/";		
		Inventory inventory = new Inventory(prefix);
		try{
			OWLOntology ontology = ontologyManager.createOntology(IRI.create(prefix + "modis.owl"));
			Factory factory = new Factory(ontology);
			
			Simulator simulator = new Simulator(factory, inventory);
			simulator.simulate();
			
			File aFile = new File("../ontology.cybershare.utep.edu/ELSEWeb/linked-data/edac/services/provenance/modis/modis.owl");
			FileDocumentTarget target = new FileDocumentTarget(aFile);
			ontologyManager.saveOntology(ontology, target);
			System.out.println("dumped file");
		}
		catch(Exception e){e.printStackTrace();}
	}
}
