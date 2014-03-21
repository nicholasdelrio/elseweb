package edu.utep.cybershare.elseweb.ontology.impl;

import edu.utep.cybershare.elseweb.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultMODISMeasurement <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */
public class DefaultMODISMeasurement extends WrappedIndividualImpl implements MODISMeasurement {

    public DefaultMODISMeasurement(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-edac.owl#wasAssociatedWith
     */
     
    public Collection<? extends Processor> getWasAssociatedWith() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_WASASSOCIATEDWITH,
                                               DefaultProcessor.class);
    }

    public boolean hasWasAssociatedWith() {
	   return !getWasAssociatedWith().isEmpty();
    }

    public void addWasAssociatedWith(Processor newWasAssociatedWith) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_WASASSOCIATEDWITH,
                                       newWasAssociatedWith);
    }

    public void removeWasAssociatedWith(Processor oldWasAssociatedWith) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_WASASSOCIATEDWITH,
                                          oldWasAssociatedWith);
    }


}
