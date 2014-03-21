package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;


/**
 * Dublin Core Metadata Initiative (DCMI)
 * <a href="http://dublincore.org/">http://dublincore.org/</a>
 * @author Nicholas Del Rio
 *
 */

public class DCMI extends Vocabulary{

	private static final String NAMESPACE = "http://purl.org/dc/terms";
	
	private static final String OntClass_FileFormat = NAMESPACE + "/FileFormat";
	
	private static final String ObjectProperty_format = NAMESPACE + "/format";
	private static final String ObjectProperty_spatial = NAMESPACE + "/spatial";
	private static final String ObjectProperty_temporal = NAMESPACE + "/temporal";
	
	
	public DCMI(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
	
	public OWLClass getOntClass_FileFormat(){return bundle.getDataFactory().getOWLClass(IRI.create(OntClass_FileFormat));}
	
	public OWLObjectProperty getObjectProperty_format(){return bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_format));}
	public OWLObjectProperty getObjectProperty_spatial(){return bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_spatial));}
	public OWLObjectProperty getObjectProperty_temporal(){return bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_temporal));}
}
