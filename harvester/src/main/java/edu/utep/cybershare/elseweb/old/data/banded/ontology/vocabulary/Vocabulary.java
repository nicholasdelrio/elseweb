package edu.utep.cybershare.elseweb.old.data.banded.ontology.vocabulary;

import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;


public abstract class Vocabulary {
	protected OntologyToolset bundle;
		
	public Vocabulary(OntologyToolset bundle){
		this.bundle = bundle;
	}
		
	public abstract String getNamespace();
}
