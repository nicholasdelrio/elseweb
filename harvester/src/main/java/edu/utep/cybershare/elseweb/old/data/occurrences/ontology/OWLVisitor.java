package edu.utep.cybershare.elseweb.old.data.occurrences.ontology;

import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Dataset;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Layer;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Manifestation;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Projection;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Region;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Species;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.SpeciesOccurrenceSet;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Visitor;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.DatasetAxioms;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.LayerAxioms;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.ManifestationAxioms;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.ProjectionAxioms;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.RegionAxioms;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.SpeciesAxioms;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.SpeciesOccurrenceSetAxioms;

public class OWLVisitor implements Visitor{

	private OntologyToolset bundle;
	
	public OWLVisitor(OntologyToolset bundle){
		this.bundle = bundle;
	}

	public void visit(Region region) {
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(region, bundle);
		RegionAxioms axioms = new RegionAxioms(ind, region, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Dataset dataset) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(dataset, bundle);
		DatasetAxioms axioms = new DatasetAxioms(ind, dataset, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
		
	}

	public void visit(Layer layer) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(layer, bundle);
		LayerAxioms axioms = new LayerAxioms(ind, layer, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);

	}

	public void visit(Manifestation manifestation) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(manifestation, bundle);
		ManifestationAxioms axioms = new ManifestationAxioms(ind, manifestation, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);

	}

	public void visit(Species species) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(species, bundle);
		SpeciesAxioms axioms = new SpeciesAxioms(ind, species, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);

	}

	public void visit(SpeciesOccurrenceSet speciesOccurrence) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(speciesOccurrence, bundle);
		SpeciesOccurrenceSetAxioms axioms = new SpeciesOccurrenceSetAxioms(ind, speciesOccurrence, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);

	}

	public void visit(Projection projection) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		OWLIndividual ind = Individuals.getIndividual(projection, bundle);
		ProjectionAxioms axioms = new ProjectionAxioms(ind, projection, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}
}
