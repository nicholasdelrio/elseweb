package edu.utep.cybershare.elseweb.old.data.occurrences.ontology;

import java.net.URI;
import java.util.Hashtable;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Element;
import edu.utep.cybershare.elseweb.old.data.occurrences.util.StringManipulation;

public class Individuals {

	private static Hashtable<String, OWLNamedIndividual> individuals = new Hashtable<String, OWLNamedIndividual>();
	
	public static boolean doesIndividualExist(Element element, OntologyToolset bundle){
		String individualName = StringManipulation.makeURICompliantFragment(element.getIdentification(), bundle.getBaseIRI());
		String individualIRI = bundle.getIndividualIRI(individualName);
		return individuals.get(individualIRI) != null;
	}
	
	public static OWLNamedIndividual getIndividual(URI uri, OntologyToolset bundle){
		return getIndividual(uri.toASCIIString(), bundle);
	}
	
	public static OWLNamedIndividual getIndividual(Element element, OntologyToolset bundle){

		if(element.getIdentification().startsWith("?"))
			System.out.println("boooo");
		
		String individualName = StringManipulation.makeURICompliantFragment(element.getIdentification(), bundle.getBaseIRI());
		String individualIRI = bundle.getIndividualIRI(individualName);
		
		return getIndividual(individualIRI, bundle);
	}
	
	public static OWLNamedIndividual getIndividual(Element element, OntologyToolset bundle, String postfix){
		
		if(element.getIdentification().startsWith("?"))
			System.out.println("boooo");
		
		String individualName = StringManipulation.makeURICompliantFragment(element.getIdentification() + postfix, bundle.getBaseIRI());
		String individualIRI = bundle.getIndividualIRI(individualName);
		
		return getIndividual(individualIRI, bundle);
	}
	
	private static OWLNamedIndividual getIndividual(String uri, OntologyToolset bundle){		
		OWLNamedIndividual individual = individuals.get(uri);
		
		if(individual == null){
			individual = bundle.getDataFactory().getOWLNamedIndividual(IRI.create(uri));
			individuals.put(uri, individual);
		}
		return individual;
	}
}
