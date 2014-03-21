package edu.utep.cybershare.elseweb.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: ConvertedDataset <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */

public interface ConvertedDataset extends RGISPrepublishedRasterDataset {

    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#coversRegion
     */
     
    /**
     * Gets all property values for the coversRegion property.<p>
     * 
     * @returns a collection of values for the coversRegion property.
     */
    Collection<? extends GeographicRegion> getCoversRegion();

    /**
     * Checks if the class has a coversRegion property value.<p>
     * 
     * @return true if there is a coversRegion property value.
     */
    boolean hasCoversRegion();

    /**
     * Adds a coversRegion property value.<p>
     * 
     * @param newCoversRegion the coversRegion property value to be added
     */
    void addCoversRegion(GeographicRegion newCoversRegion);

    /**
     * Removes a coversRegion property value.<p>
     * 
     * @param oldCoversRegion the coversRegion property value to be removed.
     */
    void removeCoversRegion(GeographicRegion oldCoversRegion);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#coversTimePeriod
     */
     
    /**
     * Gets all property values for the coversTimePeriod property.<p>
     * 
     * @returns a collection of values for the coversTimePeriod property.
     */
    Collection<? extends TimePeriod> getCoversTimePeriod();

    /**
     * Checks if the class has a coversTimePeriod property value.<p>
     * 
     * @return true if there is a coversTimePeriod property value.
     */
    boolean hasCoversTimePeriod();

    /**
     * Adds a coversTimePeriod property value.<p>
     * 
     * @param newCoversTimePeriod the coversTimePeriod property value to be added
     */
    void addCoversTimePeriod(TimePeriod newCoversTimePeriod);

    /**
     * Removes a coversTimePeriod property value.<p>
     * 
     * @param oldCoversTimePeriod the coversTimePeriod property value to be removed.
     */
    void removeCoversTimePeriod(TimePeriod oldCoversTimePeriod);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasDataBand
     */
     
    /**
     * Gets all property values for the hasDataBand property.<p>
     * 
     * @returns a collection of values for the hasDataBand property.
     */
    Collection<? extends DataBand> getHasDataBand();

    /**
     * Checks if the class has a hasDataBand property value.<p>
     * 
     * @return true if there is a hasDataBand property value.
     */
    boolean hasHasDataBand();

    /**
     * Adds a hasDataBand property value.<p>
     * 
     * @param newHasDataBand the hasDataBand property value to be added
     */
    void addHasDataBand(DataBand newHasDataBand);

    /**
     * Removes a hasDataBand property value.<p>
     * 
     * @param oldHasDataBand the hasDataBand property value to be removed.
     */
    void removeHasDataBand(DataBand oldHasDataBand);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasGeospatialProjection
     */
     
    /**
     * Gets all property values for the hasGeospatialProjection property.<p>
     * 
     * @returns a collection of values for the hasGeospatialProjection property.
     */
    Collection<? extends Projection> getHasGeospatialProjection();

    /**
     * Checks if the class has a hasGeospatialProjection property value.<p>
     * 
     * @return true if there is a hasGeospatialProjection property value.
     */
    boolean hasHasGeospatialProjection();

    /**
     * Adds a hasGeospatialProjection property value.<p>
     * 
     * @param newHasGeospatialProjection the hasGeospatialProjection property value to be added
     */
    void addHasGeospatialProjection(Projection newHasGeospatialProjection);

    /**
     * Removes a hasGeospatialProjection property value.<p>
     * 
     * @param oldHasGeospatialProjection the hasGeospatialProjection property value to be removed.
     */
    void removeHasGeospatialProjection(Projection oldHasGeospatialProjection);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasManifestation
     */
     
    /**
     * Gets all property values for the hasManifestation property.<p>
     * 
     * @returns a collection of values for the hasManifestation property.
     */
    Collection<? extends DatasetManifestation> getHasManifestation();

    /**
     * Checks if the class has a hasManifestation property value.<p>
     * 
     * @return true if there is a hasManifestation property value.
     */
    boolean hasHasManifestation();

    /**
     * Adds a hasManifestation property value.<p>
     * 
     * @param newHasManifestation the hasManifestation property value to be added
     */
    void addHasManifestation(DatasetManifestation newHasManifestation);

    /**
     * Removes a hasManifestation property value.<p>
     * 
     * @param oldHasManifestation the hasManifestation property value to be removed.
     */
    void removeHasManifestation(DatasetManifestation oldHasManifestation);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasTheme
     */
     
    /**
     * Gets all property values for the hasTheme property.<p>
     * 
     * @returns a collection of values for the hasTheme property.
     */
    Collection<? extends WrappedIndividual> getHasTheme();

    /**
     * Checks if the class has a hasTheme property value.<p>
     * 
     * @return true if there is a hasTheme property value.
     */
    boolean hasHasTheme();

    /**
     * Adds a hasTheme property value.<p>
     * 
     * @param newHasTheme the hasTheme property value to be added
     */
    void addHasTheme(WrappedIndividual newHasTheme);

    /**
     * Removes a hasTheme property value.<p>
     * 
     * @param oldHasTheme the hasTheme property value to be removed.
     */
    void removeHasTheme(WrappedIndividual oldHasTheme);


    /* ***************************************************
     * Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#wasOutputBy
     */
     
    /**
     * Gets all property values for the wasOutputBy property.<p>
     * 
     * @returns a collection of values for the wasOutputBy property.
     */
    Collection<? extends DatasetProcessing> getWasOutputBy();

    /**
     * Checks if the class has a wasOutputBy property value.<p>
     * 
     * @return true if there is a wasOutputBy property value.
     */
    boolean hasWasOutputBy();

    /**
     * Adds a wasOutputBy property value.<p>
     * 
     * @param newWasOutputBy the wasOutputBy property value to be added
     */
    void addWasOutputBy(DatasetProcessing newWasOutputBy);

    /**
     * Removes a wasOutputBy property value.<p>
     * 
     * @param oldWasOutputBy the wasOutputBy property value to be removed.
     */
    void removeWasOutputBy(DatasetProcessing oldWasOutputBy);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
