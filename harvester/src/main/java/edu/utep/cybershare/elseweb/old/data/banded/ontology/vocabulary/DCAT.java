package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;


/**
 * Data Catalog (DCAT)
 * <a href="http://www.w3.org/TR/vocab-dcat/">http://www.w3.org/TR/vocab-dcat/</a>
 * @author Nicholas Del Rio
 *
 */

public class DCAT extends Vocabulary{
	
	private static final String NAMESPACE = "http://www.w3.org/ns/dcat";
	
	private static final String ObjectProperty_distribution = NAMESPACE + "#distribution";
	private static final String ObjectProperty_dataset = NAMESPACE + "#dataset";
	
	private static final String DatatypeProperty_accessURL = NAMESPACE + "#accessURL";
	private static final String DatatypeProperty_downloadURL = NAMESPACE + "#downloadURL";

	public DCAT(OntologyToolset bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}

	public OWLObjectProperty getObjectProperty_distribution(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_distribution));}
	public OWLObjectProperty getObjectProperty_dataset(){return this.bundle.getDataFactory().getOWLObjectProperty(IRI.create(ObjectProperty_dataset));}
	public OWLDataProperty getDatatypeProperty_accessURL(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DatatypeProperty_accessURL));}
	public OWLDataProperty getDatatypeProperty_downloadURL(){return this.bundle.getDataFactory().getOWLDataProperty(IRI.create(DatatypeProperty_downloadURL));}
}
