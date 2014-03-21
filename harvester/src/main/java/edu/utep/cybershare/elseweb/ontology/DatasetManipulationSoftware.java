package edu.utep.cybershare.elseweb.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: DatasetManipulationSoftware <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */

public interface DatasetManipulationSoftware extends Processor {

    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#hasProcessorName
     */
     
    /**
     * Gets all property values for the hasProcessorName property.<p>
     * 
     * @returns a collection of values for the hasProcessorName property.
     */
    Collection<? extends Object> getHasProcessorName();

    /**
     * Checks if the class has a hasProcessorName property value.<p>
     * 
     * @return true if there is a hasProcessorName property value.
     */
    boolean hasHasProcessorName();

    /**
     * Adds a hasProcessorName property value.<p>
     * 
     * @param newHasProcessorName the hasProcessorName property value to be added
     */
    void addHasProcessorName(Object newHasProcessorName);

    /**
     * Removes a hasProcessorName property value.<p>
     * 
     * @param oldHasProcessorName the hasProcessorName property value to be removed.
     */
    void removeHasProcessorName(Object oldHasProcessorName);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
