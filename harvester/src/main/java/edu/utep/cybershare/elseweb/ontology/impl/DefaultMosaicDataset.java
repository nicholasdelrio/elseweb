package edu.utep.cybershare.elseweb.ontology.impl;

import edu.utep.cybershare.elseweb.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultMosaicDataset <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */
public class DefaultMosaicDataset extends WrappedIndividualImpl implements MosaicDataset {

    public DefaultMosaicDataset(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#coversRegion
     */
     
    public Collection<? extends GeographicRegion> getCoversRegion() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_COVERSREGION,
                                               DefaultGeographicRegion.class);
    }

    public boolean hasCoversRegion() {
	   return !getCoversRegion().isEmpty();
    }

    public void addCoversRegion(GeographicRegion newCoversRegion) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_COVERSREGION,
                                       newCoversRegion);
    }

    public void removeCoversRegion(GeographicRegion oldCoversRegion) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_COVERSREGION,
                                          oldCoversRegion);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#coversTimePeriod
     */
     
    public Collection<? extends TimePeriod> getCoversTimePeriod() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_COVERSTIMEPERIOD,
                                               DefaultTimePeriod.class);
    }

    public boolean hasCoversTimePeriod() {
	   return !getCoversTimePeriod().isEmpty();
    }

    public void addCoversTimePeriod(TimePeriod newCoversTimePeriod) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_COVERSTIMEPERIOD,
                                       newCoversTimePeriod);
    }

    public void removeCoversTimePeriod(TimePeriod oldCoversTimePeriod) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_COVERSTIMEPERIOD,
                                          oldCoversTimePeriod);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasDataBand
     */
     
    public Collection<? extends DataBand> getHasDataBand() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASDATABAND,
                                               DefaultDataBand.class);
    }

    public boolean hasHasDataBand() {
	   return !getHasDataBand().isEmpty();
    }

    public void addHasDataBand(DataBand newHasDataBand) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASDATABAND,
                                       newHasDataBand);
    }

    public void removeHasDataBand(DataBand oldHasDataBand) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASDATABAND,
                                          oldHasDataBand);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasGeospatialProjection
     */
     
    public Collection<? extends Projection> getHasGeospatialProjection() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASGEOSPATIALPROJECTION,
                                               DefaultProjection.class);
    }

    public boolean hasHasGeospatialProjection() {
	   return !getHasGeospatialProjection().isEmpty();
    }

    public void addHasGeospatialProjection(Projection newHasGeospatialProjection) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASGEOSPATIALPROJECTION,
                                       newHasGeospatialProjection);
    }

    public void removeHasGeospatialProjection(Projection oldHasGeospatialProjection) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASGEOSPATIALPROJECTION,
                                          oldHasGeospatialProjection);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasManifestation
     */
     
    public Collection<? extends DatasetManifestation> getHasManifestation() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASMANIFESTATION,
                                               DefaultDatasetManifestation.class);
    }

    public boolean hasHasManifestation() {
	   return !getHasManifestation().isEmpty();
    }

    public void addHasManifestation(DatasetManifestation newHasManifestation) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASMANIFESTATION,
                                       newHasManifestation);
    }

    public void removeHasManifestation(DatasetManifestation oldHasManifestation) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASMANIFESTATION,
                                          oldHasManifestation);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasTheme
     */
     
    public Collection<? extends WrappedIndividual> getHasTheme() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASTHEME,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasTheme() {
	   return !getHasTheme().isEmpty();
    }

    public void addHasTheme(WrappedIndividual newHasTheme) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASTHEME,
                                       newHasTheme);
    }

    public void removeHasTheme(WrappedIndividual oldHasTheme) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASTHEME,
                                          oldHasTheme);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#wasOutputBy
     */
     
    public Collection<? extends DatasetProcessing> getWasOutputBy() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_WASOUTPUTBY,
                                               DefaultDatasetProcessing.class);
    }

    public boolean hasWasOutputBy() {
	   return !getWasOutputBy().isEmpty();
    }

    public void addWasOutputBy(DatasetProcessing newWasOutputBy) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_WASOUTPUTBY,
                                       newWasOutputBy);
    }

    public void removeWasOutputBy(DatasetProcessing oldWasOutputBy) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_WASOUTPUTBY,
                                          oldWasOutputBy);
    }


}
