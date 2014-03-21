package edu.utep.cybershare.elseweb.old.data.banded.ontology;

import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.banded.model.Characteristic;
import edu.utep.cybershare.elseweb.old.data.banded.model.Duration;
import edu.utep.cybershare.elseweb.old.data.banded.model.Entity;
import edu.utep.cybershare.elseweb.old.data.banded.model.Measurement;
import edu.utep.cybershare.elseweb.old.data.banded.model.Observation;
import edu.utep.cybershare.elseweb.old.data.banded.model.Region;
import edu.utep.cybershare.elseweb.old.data.banded.model.Visitor;
import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageDataset;
import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageDistribution;
import edu.utep.cybershare.elseweb.old.data.banded.model.WCSCoverageSet;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.CharacteristicAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.DurationAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.EntityAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.MeasurementAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.ObservationAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.RegionAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.WCSCoverageDatasetAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.WCSCoverageDistributionAxioms;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms.WCSCoverageSetAxioms;

public class OWLVisitor implements Visitor{

	private OntologyToolset bundle;
	
	public OWLVisitor(OntologyToolset bundle){
		this.bundle = bundle;
	}
	
	public void visit(Characteristic characteristic) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(characteristic, bundle);
		CharacteristicAxioms axioms = new CharacteristicAxioms(characteristic, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(WCSCoverageDataset dataset) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(dataset, bundle);
		WCSCoverageDatasetAxioms axioms = new WCSCoverageDatasetAxioms(dataset, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Measurement measurement) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(measurement, bundle);
		MeasurementAxioms axioms = new MeasurementAxioms(measurement, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Observation observation) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(observation, bundle);
		ObservationAxioms axioms = new ObservationAxioms(observation, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Entity entity) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(entity, bundle);
		EntityAxioms axioms = new EntityAxioms(entity, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(WCSCoverageSet catalog) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(catalog, bundle);
		WCSCoverageSetAxioms axioms = new WCSCoverageSetAxioms(catalog, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(WCSCoverageDistribution distribution) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(distribution, bundle);
		WCSCoverageDistributionAxioms axioms = new WCSCoverageDistributionAxioms(distribution, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Region region) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(region, bundle);
		RegionAxioms axioms = new RegionAxioms(region, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}

	public void visit(Duration duration) {
		// TODO Auto-generated method stub
		OWLIndividual individual = Individuals.getIndividual(duration, bundle);
		DurationAxioms axioms = new DurationAxioms(duration, individual, bundle);
		axioms.setAxioms();
		bundle.addAxioms(axioms);
	}
}
