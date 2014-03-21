package edu.utep.cybershare.elseweb.old.data.banded.harvest;

import java.io.File;

import edu.utep.cybershare.elseweb.old.data.banded.build.Builder;
import edu.utep.cybershare.elseweb.old.data.banded.build.Director;
import edu.utep.cybershare.elseweb.old.data.banded.build.MaxDiversityMinSizeDirector;
import edu.utep.cybershare.elseweb.old.data.banded.build.ModelProduct;
import edu.utep.cybershare.elseweb.old.data.banded.build.source.edac.WCSDigests;
import edu.utep.cybershare.elseweb.old.data.banded.model.Characteristic;
import edu.utep.cybershare.elseweb.old.data.banded.model.Duration;
import edu.utep.cybershare.elseweb.old.data.banded.model.Entity;
import edu.utep.cybershare.elseweb.old.data.banded.model.Measurement;
import edu.utep.cybershare.elseweb.old.data.banded.model.Observation;
import edu.utep.cybershare.elseweb.old.data.banded.model.Region;
import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageDataset;
import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageDistribution;
import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageSet;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OWLVisitor;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.banded.util.FilePath;

public class Harvester {
	
	public static void main(String[] args){
	
		//setup the empty product
		ModelProduct product = new ModelProduct();
		
		//setup the builder of the product
		Builder builder = new Builder(product);
		
		//setup the builder directory
		Director director = new Director(builder);
		
		//get our data source and pass to director
		WCSDigests digests = new WCSDigests(10000, 0);
		director.construct(digests);
		
		//create visitor to convert model product to axioms
		OntologyToolset bundle = new OntologyToolset(FilePath.URI_PREFIX);
		OWLVisitor visitor = new OWLVisitor(bundle);
		
		//visit all model elements
		for(WCSCoverageSet catalog : product.getCatalogs())
			visitor.visit(catalog);
		for(Characteristic characteristic : product.getCharacteristics())
			visitor.visit(characteristic);
		for(WCSCoverageDataset dataset : product.getDatasets())
			visitor.visit(dataset);
		for(WCSCoverageDistribution distribution : product.getDistributions())
			visitor.visit(distribution);
		for(Duration duration : product.getDurations())
			visitor.visit(duration);
		for(Entity entity : product.getEntities())
			visitor.visit(entity);
		for(Measurement measurement : product.getMeasurements())
			visitor.visit(measurement);
		for(Observation obs : product.getObservations())
			visitor.visit(obs);
		for(Region region :product.getRegions())
			visitor.visit(region);
	
		//dump file
		bundle.dumpOntology(new File(FilePath.DUMP_PATH));
	}
}
