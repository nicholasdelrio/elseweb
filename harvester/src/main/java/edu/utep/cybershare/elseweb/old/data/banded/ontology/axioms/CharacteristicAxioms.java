package edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms;

import org.semanticweb.owlapi.model.OWLIndividual;

import edu.utep.cybershare.elseweb.old.data.banded.model.Characteristic;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;

public class CharacteristicAxioms extends Axioms {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Characteristic characteristic;
	
	public CharacteristicAxioms(Characteristic characteristic, OWLIndividual individual, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		
		this.characteristic = characteristic;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addTypeAxiom(vocabulary_OBOE.getOWLClass_Characteristic());
		
		if(characteristic.isSet_themekey()){
			this.addTypeAxiom(mapper.getCharacteristicOntClass(characteristic.getThemekey()));
		}
	}
}
