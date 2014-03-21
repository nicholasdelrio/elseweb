package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;


public class ELSEWEB extends Vocabulary {
	
	private static final String NAMESPACE = "http://ontology.cybershare.utep.edu/ELSEWeb/elsewebdata.owl";
	
	private static final String OWLClass_WCSCoverageSet = NAMESPACE + "#WCSCoverageSet";
	private static final String OWLClass_WCSCoverageDataset = NAMESPACE + "#WCSCoverageDataset";
	private static final String OWLClass_WCSCoverageDistribution = NAMESPACE + "#WCSCoverageDistribution";
	private static final String OWLClass_Region = NAMESPACE + "#Region";
	private static final String OWLClass_Duration = NAMESPACE + "#Duration";
	private static final String OWLClass_Method = NAMESPACE + "#Method";
	private static final String OWLClass_Sensor = NAMESPACE + "#Sensor";
	
	//Entities
	private static final String OWLClass_DewPoint = NAMESPACE + "#DewPoint";
	private static final String OWLClass_VegetationIndex = NAMESPACE + "#VegetationIndex";
	private static final String OWLClass_SurfaceLayer = NAMESPACE + "#SurfaceLayer";
	private static final String OWLClass_Precipitation = NAMESPACE + "#Precipitation";
	private static final String OWLClass_Air = NAMESPACE + "#Air";
	
	private static final String ObjectProperty_hasWCSCoverage = NAMESPACE + "#hasWCSCoverage";

	private static final String DataProperty_hasStartDate = NAMESPACE + "#hasStartDate";
	private static final String DataProperty_hasEndDate = NAMESPACE + "#hasEndDate";
	private static final String DataProperty_hasLeftLongitude = NAMESPACE + "#hasLeftLongitude";
	private static final String DataProperty_hasRightLongitude = NAMESPACE + "#hasRightLongitude";
	private static final String DataProperty_hasLowerLatitude = NAMESPACE + "#hasLowerLatitude";
	private static final String DataProperty_hasUpplerLatitude = NAMESPACE + "#hasUpperLatitude";
	private static final String DataProperty_hasID = NAMESPACE + "#hasID";

	public ELSEWEB(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}
	
	public OWLClass getOWLClass_WCSCoverageSet(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_WCSCoverageSet));}
	public OWLClass getOWLClass_WCSCoverageDataset(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_WCSCoverageDataset));}
	public OWLClass getOWLClass_WCSCoverageDistribution(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_WCSCoverageDistribution));}
	public OWLClass getOWLClass_Region(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Region));}
	public OWLClass getOWLClass_Duration(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Duration));}
	public OWLClass getOWLClass_Method(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Method));}
	public OWLClass getOWLClass_Sensor(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Sensor));}
	
	public OWLClass getOWLClass_DewPoint(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_DewPoint));}
	public OWLClass getOWLClass_VegetationIndex(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_VegetationIndex));}
	public OWLClass getOWLClass_SurfaceLayer(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_SurfaceLayer));}
	public OWLClass getOWLClass_Precipitation(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Precipitation));}
	public OWLClass getOWLClass_Air(){return this.bundle.getDataFactory().getOWLClass(IRI.create(OWLClass_Air));}

	
	public OWLObjectProperty getObjectProperty_hasWCSCoverage(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_hasWCSCoverage));}
	
	public OWLDataProperty getDataProperty_hasStartDate(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasStartDate));}
	public OWLDataProperty getDataProperty_hasEndDate(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasEndDate));}
	public OWLDataProperty getDataProperty_hasLeftLongitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasLeftLongitude));}
	public OWLDataProperty getDataProperty_hasRightLongitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasRightLongitude));}
	public OWLDataProperty getDataProperty_hasLowerLatitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasLowerLatitude));}
	public OWLDataProperty getDataProperty_hasUpperLatitude(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasUpplerLatitude));}
	public OWLDataProperty getDataProperty_hasID(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DataProperty_hasID));}
	
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}

}
