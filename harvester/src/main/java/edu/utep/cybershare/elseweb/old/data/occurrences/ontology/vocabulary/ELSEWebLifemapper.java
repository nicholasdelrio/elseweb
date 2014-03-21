package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;


public class ELSEWebLifemapper extends Vocabulary {
	
	private static final String NAMESPACE = "http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-lifemapper.owl";

	private static final String OWLClass_Species = NAMESPACE + "#Species";
	private static final String OWLClass_SpeciesOccurrenceSet = NAMESPACE + "#SpeciesOccurrenceSet";
	private static final String OWLClass_SpeciesOccurrenceLayer = NAMESPACE + "#SpeciesOccurrenceLayer";
	private static final String OWLClass_SpeciesOccurrenceDataset = NAMESPACE + "#SpeciesOccurrenceDataset";
		
	private static final String ObjectProperty_hasOccurrenceOfSpecies = NAMESPACE + "#hasOccurrenceOfSpecies";
	
	private static final String DataProperty_hasGenusName = NAMESPACE + "#hasGenusName";
	private static final String DataProperty_hasNumberOfOccurrences = NAMESPACE + "#hasNumberOfOccurrences";
	private static final String DataProperty_hasOccurrenceSetID = NAMESPACE + "#hasOccurrenceSetID";

	
	public ELSEWebLifemapper(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}
	
	public OWLClass getOWLClass_Species(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Species));}
	public OWLClass getOWLClass_SpeciesOccurrenceSet(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_SpeciesOccurrenceSet));}
	public OWLClass getOWLClass_SpeciesOccurrenceLayer(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_SpeciesOccurrenceLayer));}
	public OWLClass getOWLClass_SpeciesOccurrenceDataset(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_SpeciesOccurrenceDataset));}

	public OWLObjectProperty getObjectProperty_hasOccurrenceOfSpecies(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasOccurrenceOfSpecies));}
	
	public OWLDataProperty getDataProperty_hasGenusName(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasGenusName));}
	public OWLDataProperty getDataProperty_hasNumberOfOccurrences(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasNumberOfOccurrences));}
	public OWLDataProperty getDataProperty_hasOccurrenceSetID(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasOccurrenceSetID));}
	
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
}
