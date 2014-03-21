package edu.utep.cybershare.elseweb.old.data.occurrences.harvest;

import java.io.File;

import edu.utep.cybershare.elseweb.old.data.occurrences.build.Builder;
import edu.utep.cybershare.elseweb.old.data.occurrences.build.Director;
import edu.utep.cybershare.elseweb.old.data.occurrences.build.ModelProduct;
import edu.utep.cybershare.elseweb.old.data.occurrences.build.source.lifemapper.OccurrenceSetsXML;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Dataset;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Layer;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Manifestation;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Projection;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Region;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Species;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.SpeciesOccurrenceSet;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OWLVisitor;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.util.FilePath;

public class Harvester {
	
	public static void main(String[] args){
	
		//setup the empty product
		ModelProduct product = new ModelProduct();
		
		//setup the builder of the product
		Builder builder = new Builder(product);
		
		//setup the builder directory
		Director director = new Director(builder);
		
		//get our data source and pass to director
		OccurrenceSetsXML occurrenceSetsXML = new OccurrenceSetsXML();
		director.construct(occurrenceSetsXML);

		//create visitor to convert model product to axioms
		OntologyToolset bundle = new OntologyToolset(FilePath.URI_PREFIX, FilePath.DOCUMENT_URL);
		OWLVisitor visitor = new OWLVisitor(bundle);
		
		for(Dataset ds : product.getDatasets())
			visitor.visit(ds);
		
		for(Layer layer : product.getLayers())
			visitor.visit(layer);
		
		for(Manifestation man : product.getManifestations())
			visitor.visit(man);
		
		for(Projection proj : product.getProjections())
			visitor.visit(proj);
		
		for(Region reg : product.getRegions())
			visitor.visit(reg);
		
		for(Species species : product.getSpecies())
			visitor.visit(species);
		
		for(SpeciesOccurrenceSet sets: product.getOccurrenceSets())
			visitor.visit(sets);
		
		//dump file
		bundle.dumpOntology(new File(FilePath.DUMP_PATH));
	}
}
