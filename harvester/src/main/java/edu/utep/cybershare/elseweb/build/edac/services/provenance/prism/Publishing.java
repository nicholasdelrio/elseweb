package edu.utep.cybershare.elseweb.build.edac.services.provenance.prism;

import java.net.URL;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.Publish;
import edu.utep.cybershare.elseweb.ontology.PublishedPRISMDataset;
import edu.utep.cybershare.elseweb.ontology.RGISWCSManifestation;
import edu.utep.cybershare.elseweb.ontology.ReprojectedDataset;
import edu.utep.cybershare.elseweb.xsd.Vocabulary;

public class Publishing {
	private Factory factory;
	private Inventory inventory;
	private OWLDataFactory dataFactory;

	private DatasetManipulationSoftware publisher;

	private PublishedPRISMDataset dataset;
	
	public Publishing(Factory factory, Inventory inventory){
		this.factory = factory;
		this.inventory = inventory;
		this.dataFactory = OWLManager.createOWLOntologyManager().getOWLDataFactory();
		initializeCommonResources();
	}
	
	private void initializeCommonResources(){
		publisher = factory.createDatasetManipulationSoftware("http://gstore.unm.edu/elseweb/GSTORE");
		inventory.addToInventory(publisher);
	}
	
	public void publish(ReprojectedDataset reprojectedDataset){
		//the manifestation of the extracted dataset
		RGISWCSManifestation manif = factory.createRGISWCSManifestation(inventory.getRandomInstanceURI("wcs-prism-manifestation"));
		try{
			manif.addHasCapabilitiesDocumentURL("http://gstore.unm.edu/apps/epscor/datasets/bc68ffde-5ea6-4de3-aa1a-182b6b2aeab2/services/ogc/wcs?SERVICE=wcs&REQUEST=GetCapabilities&VERSION=1.1.2");
			manif.addhasJSONCapabilitiesDigestURL("http://gstore.unm.edu/someURLToJSON");
		}
		catch(Exception e){e.printStackTrace();}		
		inventory.addToInventory(manif);
		
		dataset = factory.createPublishedPRISMDataset("wcs-prism-dataset");
		dataset.addCoversRegion(reprojectedDataset.getCoversRegion().iterator().next());
		dataset.addCoversTimePeriod(reprojectedDataset.getCoversTimePeriod().iterator().next());
		dataset.addHasGeospatialProjection(reprojectedDataset.getHasGeospatialProjection().iterator().next());
		dataset.addHasDataBand(reprojectedDataset.getHasDataBand().iterator().next());
		dataset.addHasManifestation(manif);
		inventory.addToInventory(dataset);
		
		Publish publish = factory.createPublish(inventory.getRandomInstanceURI("publish-prism"));
		publish.addHadInput(reprojectedDataset);
		inventory.addToInventory(publish);

		dataset.addWasPublishedBy(publish);
	}
	/*
	private OWLLiteral getOWLLiteral(URL url){
		OWLDatatype anyURI = Vocabulary.DATA_TYPE_ANYURI;
		
		OWLLiteral anyURILiteral = dataFactory.getOWLLiteral(url.toString(), anyURI);
		return anyURILiteral;
	}*/
}
