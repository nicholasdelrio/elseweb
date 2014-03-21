package edu.utep.cybershare.elseweb.build;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.model.OWLIndividual;

public class Inventory {
	
	private HashSet<OWLIndividual> owlIndividuals;	
	private SecureRandom random;
	private String baseURI;
	
	public Inventory(String baseURI){
		owlIndividuals = new HashSet<OWLIndividual>();
		random = new SecureRandom();
		
		this.baseURI = baseURI;
		
		if(!baseURI.endsWith("/"))
			this.baseURI = baseURI + "/";
	}
		
	public void addToInventory(WrappedIndividual individual) throws DuplicateOWLIndividualException {
		OWLIndividual owlIndividual = individual.getOwlIndividual();
		if(owlIndividuals.contains(owlIndividual))
			throw new KeyAlreadyExistsException("ERROR: An OWLIndividual already exists with the following IRI: " + owlIndividual.toStringID());
			
		owlIndividuals.add(owlIndividual);
	}

	public String getRandomInstanceURI(String fragment) {
		String randomID = new BigInteger(130, random).toString(32);
		return baseURI + fragment + "-" + randomID;
	}
	
	public String getInstanceURI(String fragment){
		return baseURI + fragment;
	}
}