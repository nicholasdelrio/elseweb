package edu.utep.cybershare.elseweb.ontology.impl;

import edu.utep.cybershare.elseweb.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultFileManifestation <br>
 * @version generated on Thu Feb 13 13:45:51 GMT-07:00 2014 by nick
 */
public class DefaultFileManifestation extends WrappedIndividualImpl implements FileManifestation {

    public DefaultFileManifestation(OWLOntology ontology, IRI iri) {
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
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasFileDownloadURL
     */
     
    public Collection<? extends Object> getHasFileDownloadURL() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASFILEDOWNLOADURL, Object.class);
    }

    public boolean hasHasFileDownloadURL() {
		return !getHasFileDownloadURL().isEmpty();
    }

    public void addHasFileDownloadURL(Object newHasFileDownloadURL) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASFILEDOWNLOADURL, newHasFileDownloadURL);
    }

    public void removeHasFileDownloadURL(Object oldHasFileDownloadURL) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASFILEDOWNLOADURL, oldHasFileDownloadURL);
    }


    /* ***************************************************
     * Data Property http://ontology.cybershare.utep.edu/ELSEWeb/elseweb-data.owl#hasLandingPageURL
     */
     
    public Collection<? extends Object> getHasLandingPageURL() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLANDINGPAGEURL, Object.class);
    }

    public boolean hasHasLandingPageURL() {
		return !getHasLandingPageURL().isEmpty();
    }

    public void addHasLandingPageURL(Object newHasLandingPageURL) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLANDINGPAGEURL, newHasLandingPageURL);
    }

    public void removeHasLandingPageURL(Object oldHasLandingPageURL) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASLANDINGPAGEURL, oldHasLandingPageURL);
    }


}