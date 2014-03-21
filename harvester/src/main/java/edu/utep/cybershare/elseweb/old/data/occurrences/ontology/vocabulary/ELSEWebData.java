package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;

public class ELSEWebData extends Vocabulary {
	
	private static final String NAMESPACE = "http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl";

	private static final String OWLClass_VectorFileManifestation = NAMESPACE + "#VectorFileManifestation";
	private static final String OWLClass_BoxedGeographicRegion = NAMESPACE + "#BoxedGeographicRegion";
	private static final String OWLClass_Projection = NAMESPACE + "#Projection";
		
	private static final String ObjectProperty_hasLayer = NAMESPACE + "#hasLayer";
	private static final String ObjectProperty_hasManifestation = NAMESPACE + "#hasManifestation";
	private static final String ObjectProperty_hasGeospatialProjection = NAMESPACE + "#hasGeospatialProjection";
	private static final String ObjectProperty_containsFeatureSet = NAMESPACE + "#containsFeatureSet";
	private static final String ObjectProperty_coversRegion = NAMESPACE + "#coversRegion";
	private static final String ObjectProperty_encodedInFormat = NAMESPACE + "#encodedInFormat";
	private static final String ObjectProperty_hasFileDownloadURL = NAMESPACE + "#hasFileDownloadURL";
	private static final String ObjectProperty_hasLandingPageURL = NAMESPACE + "#hasLandingPageURL";
	
	private static final String DataProperty_hasLeftLongitude = NAMESPACE + "#hasLeftLongitude";
	private static final String DataProperty_hasRightLongitude = NAMESPACE + "#hasRightLongitude";
	private static final String DataProperty_hasLowerLatitude = NAMESPACE + "#hasLowerLatitude";
	private static final String DataProperty_hasUpperLatitude = NAMESPACE + "#hasUpperLatitude";
	private static final String DataProperty_hasEPSGCode = NAMESPACE + "#hasEPSGCode";
	
	public ELSEWebData(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}
	
	public OWLClass getOWLClass_VectorFileManifestation(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_VectorFileManifestation));}
	public OWLClass getOWLClass_BoxedGeographicRegion(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_BoxedGeographicRegion));}
	public OWLClass getOWLClass_Projection(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Projection));}

	public OWLObjectProperty getObjectProperty_hasLayer(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasLayer));}
	public OWLObjectProperty getObjectProperty_hasManifestation(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasManifestation));}
	public OWLObjectProperty getObjectProperty_hasGeospatialProjection(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasGeospatialProjection));}
	public OWLObjectProperty getObjectProperty_containsFeatureSet(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_containsFeatureSet));}
	public OWLObjectProperty getObjectProperty_coversRegion(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_coversRegion));}
	public OWLObjectProperty getObjectProperty_encodedInFormat(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_encodedInFormat));}
	public OWLObjectProperty getObjectProperty_hasFileDownloadURL(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasFileDownloadURL));}
	public OWLObjectProperty getObjectProperty_hasLandingPageURL(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasLandingPageURL));}
	
	public OWLDataProperty getDataProperty_hasLeftLongitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasLeftLongitude));}
	public OWLDataProperty getDataProperty_hasRightLongitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasRightLongitude));}
	public OWLDataProperty getDataProperty_hasLowerLatitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasLowerLatitude));}
	public OWLDataProperty getDataProperty_hasUpperLatitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasUpperLatitude));}
	public OWLDataProperty getDataProperty_hasEPSGCode(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasEPSGCode));}
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}

}
