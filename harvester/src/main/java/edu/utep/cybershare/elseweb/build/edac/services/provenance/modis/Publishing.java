package edu.utep.cybershare.elseweb.build.edac.services.provenance.modis;

import java.net.URL;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.build.Inventory;
import edu.utep.cybershare.elseweb.ontology.DatasetManipulationSoftware;
import edu.utep.cybershare.elseweb.ontology.Factory;
import edu.utep.cybershare.elseweb.ontology.MosaicDataset;
import edu.utep.cybershare.elseweb.ontology.Publish;
import edu.utep.cybershare.elseweb.ontology.PublishedMODISDataset;
import edu.utep.cybershare.elseweb.ontology.RGISWCSManifestation;
import edu.utep.cybershare.elseweb.xsd.Vocabulary;

public class Publishing {
	private Factory factory;
	private Inventory inventory;
	private OWLDataFactory dataFactory;

	private DatasetManipulationSoftware publisher;

	private PublishedMODISDataset dataset;
	
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
	
	public void publish(MosaicDataset mosaicDataset){
		//the manifestation of the extracted dataset
		RGISWCSManifestation manif = factory.createRGISWCSManifestation(inventory.getRandomInstanceURI("wcs-modis-manifestation"));
		try{
			manif.addHasCapabilitiesDocumentURL("http://gstore.unm.edu/apps/epscor/datasets/bc68ffde-5ea6-4de3-aa1a-182b6b2aeab2/services/ogc/wcs?SERVICE=wcs&REQUEST=GetCapabilities&VERSION=1.1.2");
			manif.addhasJSONCapabilitiesDigestURL("http://gstore.unm.edu/someURLToJSON");
		}
		catch(Exception e){e.printStackTrace();}		
		inventory.addToInventory(manif);
		
		dataset = factory.createPublishedMODISDataset("wcs-modis-dataset");
		dataset.addCoversRegion(mosaicDataset.getCoversRegion().iterator().next());
		dataset.addCoversTimePeriod(mosaicDataset.getCoversTimePeriod().iterator().next());
		dataset.addHasGeospatialProjection(mosaicDataset.getHasGeospatialProjection().iterator().next());
		dataset.addHasDataBand(mosaicDataset.getHasDataBand().iterator().next());
		dataset.addHasManifestation(manif);
		inventory.addToInventory(dataset);
		
		Publish publish = factory.createPublish(inventory.getRandomInstanceURI("publish-modis"));
		publish.addHadInput(mosaicDataset);
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
