package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Dataset;
import edu.utep.cybershare.elseweb.old.data.occurrences.model.Layer;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.Individuals;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.Axioms;

public class DatasetAxioms extends Axioms {

	private Dataset dataset;
	
	public DatasetAxioms(OWLIndividual individual, Dataset dataset, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.dataset = dataset;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_Lifemapper.getOWLClass_SpeciesOccurrenceDataset());
		
		addRegion();
		addLayers();
		addManifestation();
		addProjection();		
	}
	
	private void addRegion(){
		if(dataset.isSet_region()){
			OWLIndividual regionIndividual = Individuals.getIndividual(dataset.getRegion(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_coversRegion(), individual, regionIndividual);
			add(axiom);
		}
	}
	
	private void addLayers(){
		OWLIndividual layerIndividual = null;
		for(Layer layer : dataset.getLayers())
			layerIndividual = Individuals.getIndividual(layer, bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_hasLayer(), individual, layerIndividual);
			add(axiom);
	}
	
	private void addManifestation(){
		if(dataset.isSet_manifestation()){
			OWLIndividual manifestationIndividual = Individuals.getIndividual(dataset.getManifestation(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_hasManifestation(), individual, manifestationIndividual);
			add(axiom);
		}
	}
	
	private void addProjection(){
		if(dataset.isSet_Projection()){
			OWLIndividual projectionInd = Individuals.getIndividual(dataset.getProjection(), bundle);
			OWLAxiom axiom = bundle.getDataFactory().getOWLObjectPropertyAssertionAxiom(vocabulary_data.getObjectProperty_hasGeospatialProjection(), individual, projectionInd);
			add(axiom);
		}
	}
}
