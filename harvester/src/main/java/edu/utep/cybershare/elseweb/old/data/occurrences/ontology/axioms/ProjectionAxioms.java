package edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.data.occurrences.model.Projection;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.OntologyToolset;
import edu.utep.cybershare.elseweb.old.data.occurrences.ontology.axioms.Axioms;

public class ProjectionAxioms extends Axioms {

	private Projection projection;
	
	public ProjectionAxioms(OWLIndividual individual, Projection projection, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.projection = projection;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub		
		this.addTypeAxiom(this.vocabulary_data.getOWLClass_Projection());

		addEPSGCode();
		
	}
	
	private void addEPSGCode(){
		if(projection.isSet_epsgCode()){
			OWLLiteral epsgCodeLiteral = bundle.getDataFactory().getOWLLiteral(projection.getEpsgCode());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_data.getDataProperty_hasEPSGCode(), individual, epsgCodeLiteral);
			add(axiom);
		}
	}	
}
