package edu.utep.cybershare.elseweb.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: WCSResponseManifestation <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */

public interface WCSResponseManifestation extends OGCResponseManifestation {

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
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasFileDownloadURL
     */
     
    /**
     * Gets all property values for the hasFileDownloadURL property.<p>
     * 
     * @returns a collection of values for the hasFileDownloadURL property.
     */
    Collection<? extends Object> getHasFileDownloadURL();

    /**
     * Checks if the class has a hasFileDownloadURL property value.<p>
     * 
     * @return true if there is a hasFileDownloadURL property value.
     */
    boolean hasHasFileDownloadURL();

    /**
     * Adds a hasFileDownloadURL property value.<p>
     * 
     * @param newHasFileDownloadURL the hasFileDownloadURL property value to be added
     */
    void addHasFileDownloadURL(Object newHasFileDownloadURL);

    /**
     * Removes a hasFileDownloadURL property value.<p>
     * 
     * @param oldHasFileDownloadURL the hasFileDownloadURL property value to be removed.
     */
    void removeHasFileDownloadURL(Object oldHasFileDownloadURL);



    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasLandingPageURL
     */
     
    /**
     * Gets all property values for the hasLandingPageURL property.<p>
     * 
     * @returns a collection of values for the hasLandingPageURL property.
     */
    Collection<? extends Object> getHasLandingPageURL();

    /**
     * Checks if the class has a hasLandingPageURL property value.<p>
     * 
     * @return true if there is a hasLandingPageURL property value.
     */
    boolean hasHasLandingPageURL();

    /**
     * Adds a hasLandingPageURL property value.<p>
     * 
     * @param newHasLandingPageURL the hasLandingPageURL property value to be added
     */
    void addHasLandingPageURL(Object newHasLandingPageURL);

    /**
     * Removes a hasLandingPageURL property value.<p>
     * 
     * @param oldHasLandingPageURL the hasLandingPageURL property value to be removed.
     */
    void removeHasLandingPageURL(Object oldHasLandingPageURL);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
