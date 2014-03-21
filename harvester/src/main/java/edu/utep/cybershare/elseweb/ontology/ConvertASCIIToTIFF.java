package edu.utep.cybershare.elseweb.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: ConvertASCIIToTIFF <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */

public interface ConvertASCIIToTIFF extends DatasetProcessing {

    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#hadInput
     */
     
    /**
     * Gets all property values for the hadInput property.<p>
     * 
     * @returns a collection of values for the hadInput property.
     */
    Collection<? extends RGISPrepublishedRasterDataset> getHadInput();

    /**
     * Checks if the class has a hadInput property value.<p>
     * 
     * @return true if there is a hadInput property value.
     */
    boolean hasHadInput();

    /**
     * Adds a hadInput property value.<p>
     * 
     * @param newHadInput the hadInput property value to be added
     */
    void addHadInput(RGISPrepublishedRasterDataset newHadInput);

    /**
     * Removes a hadInput property value.<p>
     * 
     * @param oldHadInput the hadInput property value to be removed.
     */
    void removeHadInput(RGISPrepublishedRasterDataset oldHadInput);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#wasAssociatedWith
     */
     
    /**
     * Gets all property values for the wasAssociatedWith property.<p>
     * 
     * @returns a collection of values for the wasAssociatedWith property.
     */
    Collection<? extends Processor> getWasAssociatedWith();

    /**
     * Checks if the class has a wasAssociatedWith property value.<p>
     * 
     * @return true if there is a wasAssociatedWith property value.
     */
    boolean hasWasAssociatedWith();

    /**
     * Adds a wasAssociatedWith property value.<p>
     * 
     * @param newWasAssociatedWith the wasAssociatedWith property value to be added
     */
    void addWasAssociatedWith(Processor newWasAssociatedWith);

    /**
     * Removes a wasAssociatedWith property value.<p>
     * 
     * @param oldWasAssociatedWith the wasAssociatedWith property value to be removed.
     */
    void removeWasAssociatedWith(Processor oldWasAssociatedWith);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}