package edu.utep.cybershare.elseweb.build.edac.services;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.build.edac.services.source.edac.WCSDigests;
import edu.utep.cybershare.elseweb.ontology.Factory;

public class Harvester {
	
	public static void main(String[] args){
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();		
		
		try{
			OWLOntology ontology = ontologyManager.createOntology(IRI.create(FilePath.DOCUMENT_URL));
			Factory factory = new Factory(ontology);

			WCSDigests digests = new WCSDigests(10000, 0);
			Inventory inventory = new Inventory(FilePath.URI_PREFIX);
			Builder builder = new Builder(factory, inventory);
			Director director = new Director(builder);
			director.construct(digests);
			
			File aFile = new File(FilePath.DUMP_PATH);
			FileDocumentTarget target = new FileDocumentTarget(aFile);
			ontologyManager.saveOntology(ontology, target);
			System.out.println("dumped file: " + FilePath.DUMP_PATH);
		}catch(Exception e){e.printStackTrace();}
	}
}
