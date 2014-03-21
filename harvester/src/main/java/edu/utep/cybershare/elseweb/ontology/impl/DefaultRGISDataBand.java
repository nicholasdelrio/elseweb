package edu.utep.cybershare.elseweb.ontology.impl;

import edu.utep.cybershare.elseweb.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultRGISDataBand <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */
public class DefaultRGISDataBand extends WrappedIndividualImpl implements RGISDataBand {

    public DefaultRGISDataBand(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#encodingOfCharacteristic
     */
     
    public Collection<? extends Characteristic> getEncodingOfCharacteristic() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ENCODINGOFCHARACTERISTIC,
                                               DefaultCharacteristic.class);
    }

    public boolean hasEncodingOfCharacteristic() {
	   return !getEncodingOfCharacteristic().isEmpty();
    }

    public void addEncodingOfCharacteristic(Characteristic newEncodingOfCharacteristic) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ENCODINGOFCHARACTERISTIC,
                                       newEncodingOfCharacteristic);
    }

    public void removeEncodingOfCharacteristic(Characteristic oldEncodingOfCharacteristic) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ENCODINGOFCHARACTERISTIC,
                                          oldEncodingOfCharacteristic);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasBandIdentification
     */
     
    public Collection<? extends BandIdentification> getHasBandIdentification() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASBANDIDENTIFICATION,
                                               DefaultBandIdentification.class);
    }

    public boolean hasHasBandIdentification() {
	   return !getHasBandIdentification().isEmpty();
    }

    public void addHasBandIdentification(BandIdentification newHasBandIdentification) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASBANDIDENTIFICATION,
                                       newHasBandIdentification);
    }

    public void removeHasBandIdentification(BandIdentification oldHasBandIdentification) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASBANDIDENTIFICATION,
                                          oldHasBandIdentification);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasUnits
     */
     
    public Collection<? extends Unit> getHasUnits() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASUNITS,
                                               DefaultUnit.class);
    }

    public boolean hasHasUnits() {
	   return !getHasUnits().isEmpty();
    }

    public void addHasUnits(Unit newHasUnits) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASUNITS,
                                       newHasUnits);
    }

    public void removeHasUnits(Unit oldHasUnits) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASUNITS,
                                          oldHasUnits);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#representsEntity
     */
     
    public Collection<? extends Entity> getRepresentsEntity() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_REPRESENTSENTITY,
                                               DefaultEntity.class);
    }

    public boolean hasRepresentsEntity() {
	   return !getRepresentsEntity().isEmpty();
    }

    public void addRepresentsEntity(Entity newRepresentsEntity) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_REPRESENTSENTITY,
                                       newRepresentsEntity);
    }

    public void removeRepresentsEntity(Entity oldRepresentsEntity) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_REPRESENTSENTITY,
                                          oldRepresentsEntity);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#wasMeasuredBy
     */
     
    public Collection<? extends MODISMeasurement> getWasMeasuredBy() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_WASMEASUREDBY,
                                               DefaultMODISMeasurement.class);
    }

    public boolean hasWasMeasuredBy() {
	   return !getWasMeasuredBy().isEmpty();
    }

    public void addWasMeasuredBy(MODISMeasurement newWasMeasuredBy) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_WASMEASUREDBY,
                                       newWasMeasuredBy);
    }

    public void removeWasMeasuredBy(MODISMeasurement oldWasMeasuredBy) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_WASMEASUREDBY,
                                          oldWasMeasuredBy);
    }


    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#wasModelledBy
     */
     
    public Collection<? extends PRISMModelling> getWasModelledBy() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_WASMODELLEDBY,
                                               DefaultPRISMModelling.class);
    }

    public boolean hasWasModelledBy() {
	   return !getWasModelledBy().isEmpty();
    }

    public void addWasModelledBy(PRISMModelling newWasModelledBy) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_WASMODELLEDBY,
                                       newWasModelledBy);
    }

    public void removeWasModelledBy(PRISMModelling oldWasModelledBy) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_WASMODELLEDBY,
                                          oldWasModelledBy);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasMaximumValue
     */
     
    public Collection<? extends Object> getHasMaximumValue() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMAXIMUMVALUE, Object.class);
    }

    public boolean hasHasMaximumValue() {
		return !getHasMaximumValue().isEmpty();
    }

    public void addHasMaximumValue(Object newHasMaximumValue) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMAXIMUMVALUE, newHasMaximumValue);
    }

    public void removeHasMaximumValue(Object oldHasMaximumValue) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMAXIMUMVALUE, oldHasMaximumValue);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasMinimumValue
     */
     
    public Collection<? extends Object> getHasMinimumValue() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMINIMUMVALUE, Object.class);
    }

    public boolean hasHasMinimumValue() {
		return !getHasMinimumValue().isEmpty();
    }

    public void addHasMinimumValue(Object newHasMinimumValue) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMINIMUMVALUE, newHasMinimumValue);
    }

    public void removeHasMinimumValue(Object oldHasMinimumValue) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMINIMUMVALUE, oldHasMinimumValue);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasNoDataValue
     */
     
    public Collection<? extends Object> getHasNoDataValue() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASNODATAVALUE, Object.class);
    }

    public boolean hasHasNoDataValue() {
		return !getHasNoDataValue().isEmpty();
    }

    public void addHasNoDataValue(Object newHasNoDataValue) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASNODATAVALUE, newHasNoDataValue);
    }

    public void removeHasNoDataValue(Object oldHasNoDataValue) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASNODATAVALUE, oldHasNoDataValue);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasResolution
     */
     
    public Collection<? extends Object> getHasResolution() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASRESOLUTION, Object.class);
    }

    public boolean hasHasResolution() {
		return !getHasResolution().isEmpty();
    }

    public void addHasResolution(Object newHasResolution) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASRESOLUTION, newHasResolution);
    }

    public void removeHasResolution(Object oldHasResolution) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASRESOLUTION, oldHasResolution);
    }


}