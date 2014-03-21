package edu.utep.cybershare.elseweb.xsd;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;


/**
 * Vocabulary class to provide access to the Manchester OWL API representatives for 
 * various entities in the ontology used to generate this code.<p> 
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: ${javaClass}
 *
 * @version generated on Sun Feb 02 12:37:35 GMT-07:00 2014 by nick
 */

public class Vocabulary {

	private static final OWLDataFactory factory = OWLManager.createOWLOntologyManager().getOWLDataFactory();
	private static final String xsdNamespace = "http://www.w3.org/2001/XMLSchema#";

    /* ***************************************************
     * Data Type http://www.w3.org/2001/XMLSchema/anyURI
     */
    public static final OWLDatatype DATA_TYPE_ANYURI = factory.getOWLDatatype(IRI.create(xsdNamespace + "anyURI"));

    /* ***************************************************
     * Data Type http://www.w3.org/2001/XMLSchema/dateTime
     */
    public static final OWLDatatype DATA_TYPE_DATETIME = factory.getOWLDatatype(IRI.create(xsdNamespace + "dateTime"));

    public static final OWLDatatype DATA_TYPE_DOUBLE = factory.getOWLDatatype(IRI.create(xsdNamespace + "dateTime"));

}