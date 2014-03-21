package edu.utep.cybershare.elseweb.ontology.impl;

import edu.utep.cybershare.elseweb.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultDate <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */
public class DefaultDate extends WrappedIndividualImpl implements Date {

    public DefaultDate(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasDateTime
     */
     
    public Collection<? extends Object> getHasDateTime() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDATETIME, Object.class);
    }

    public boolean hasHasDateTime() {
		return !getHasDateTime().isEmpty();
    }

    public void addHasDateTime(Object newHasDateTime) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDATETIME, newHasDateTime);
    }

    public void removeHasDateTime(Object oldHasDateTime) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASDATETIME, oldHasDateTime);
    }


}
