package edu.utep.cybershare.elseweb.ontology.impl;

import edu.utep.cybershare.elseweb.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultOGCServiceManifestation <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */
public class DefaultOGCServiceManifestation extends WrappedIndividualImpl implements OGCServiceManifestation {

    public DefaultOGCServiceManifestation(OWLOntology ontology, IRI iri) {
        super(ontology, iri);
    }





    /* ***************************************************
     * Object Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#encodedInFormat
     */
     
    public Collection<? extends Format> getEncodedInFormat() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ENCODEDINFORMAT,
                                               DefaultFormat.class);
    }

    public boolean hasEncodedInFormat() {
	   return !getEncodedInFormat().isEmpty();
    }

    public void addEncodedInFormat(Format newEncodedInFormat) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ENCODEDINFORMAT,
                                       newEncodedInFormat);
    }

    public void removeEncodedInFormat(Format oldEncodedInFormat) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ENCODEDINFORMAT,
                                          oldEncodedInFormat);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasCapabilitiesDocumentURL
     */
     
    public Collection<? extends Object> getHasCapabilitiesDocumentURL() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCAPABILITIESDOCUMENTURL, Object.class);
    }

    public boolean hasHasCapabilitiesDocumentURL() {
		return !getHasCapabilitiesDocumentURL().isEmpty();
    }

    public void addHasCapabilitiesDocumentURL(Object newHasCapabilitiesDocumentURL) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCAPABILITIESDOCUMENTURL, newHasCapabilitiesDocumentURL);
    }

    public void removeHasCapabilitiesDocumentURL(Object oldHasCapabilitiesDocumentURL) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCAPABILITIESDOCUMENTURL, oldHasCapabilitiesDocumentURL);
    }


}
