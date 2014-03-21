package edu.utep.cybershare.elseweb.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: WFSManifestation <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */

public interface WFSManifestation extends OGCServiceManifestation {

    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#encodedInFormat
     */
     
    /**
     * Gets all property values for the encodedInFormat property.<p>
     * 
     * @returns a collection of values for the encodedInFormat property.
     */
    Collection<? extends Format> getEncodedInFormat();

    /**
     * Checks if the class has a encodedInFormat property value.<p>
     * 
     * @return true if there is a encodedInFormat property value.
     */
    boolean hasEncodedInFormat();

    /**
     * Adds a encodedInFormat property value.<p>
     * 
     * @param newEncodedInFormat the encodedInFormat property value to be added
     */
    void addEncodedInFormat(Format newEncodedInFormat);

    /**
     * Removes a encodedInFormat property value.<p>
     * 
     * @param oldEncodedInFormat the encodedInFormat property value to be removed.
     */
    void removeEncodedInFormat(Format oldEncodedInFormat);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasCapabilitiesDocumentURL
     */
     
    /**
     * Gets all property values for the hasCapabilitiesDocumentURL property.<p>
     * 
     * @returns a collection of values for the hasCapabilitiesDocumentURL property.
     */
    Collection<? extends Object> getHasCapabilitiesDocumentURL();

    /**
     * Checks if the class has a hasCapabilitiesDocumentURL property value.<p>
     * 
     * @return true if there is a hasCapabilitiesDocumentURL property value.
     */
    boolean hasHasCapabilitiesDocumentURL();

    /**
     * Adds a hasCapabilitiesDocumentURL property value.<p>
     * 
     * @param newHasCapabilitiesDocumentURL the hasCapabilitiesDocumentURL property value to be added
     */
    void addHasCapabilitiesDocumentURL(Object newHasCapabilitiesDocumentURL);

    /**
     * Removes a hasCapabilitiesDocumentURL property value.<p>
     * 
     * @param oldHasCapabilitiesDocumentURL the hasCapabilitiesDocumentURL property value to be removed.
     */
    void removeHasCapabilitiesDocumentURL(Object oldHasCapabilitiesDocumentURL);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
