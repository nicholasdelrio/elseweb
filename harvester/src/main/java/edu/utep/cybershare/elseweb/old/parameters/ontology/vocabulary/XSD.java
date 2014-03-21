package edu.utep.cybershare.elseweb.old.parameters.ontology.vocabulary;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDatatype;

import edu.utep.cybershare.elseweb.old.parameters.ontology.OntologyToolset;

/**
 * XML Schema (FOAF)
 * <a href="http://www.w3.org/XML/Schema">http://www.w3.org/XML/Schema</a>
 * @author Nicholas Del Rio
 *
 */

public class XSD extends Vocabulary {
	
	public static final String NAMESPACE = "http://www.w3.org/2001/XMLSchema";
	
	// Data Types
	public static final String Datatype_dateTime = NAMESPACE + "#dateTime";
	public static final String Datatype_anyURI = NAMESPACE + "#anyURI";

	public XSD(OntologyToolset toolset) {
		super(toolset);
		// TODO Auto-generated constructor stub
	}	
	public OWLDatatype getDataType_dateTime(){
		return bundle.getDataFactory().getOWLDatatype(IRI.create(Datatype_dateTime));
	}	
	public OWLDatatype getDataType_anyURI(){
		return bundle.getDataFactory().getOWLDatatype(IRI.create(Datatype_anyURI));
	}
	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}
}
