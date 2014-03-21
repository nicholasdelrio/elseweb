package edu.utep.cybershare.elseweb.old.data.banded.ontology.axioms;

import javax.xml.bind.DatatypeConverter;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;

import edu.utep.cybershare.elseweb.old.data.banded.model.Duration;
import edu.utep.cybershare.elseweb.old.data.banded.ontology.OntologyToolset;

@SuppressWarnings("serial")
public class DurationAxioms extends Axioms{

	private Duration duration;
	public DurationAxioms(Duration duration, OWLIndividual individual, OntologyToolset bundle) {
		super(individual, bundle);
		// TODO Auto-generated constructor stub
		this.duration = duration;
	}

	@Override
	public void setAxioms() {
		// TODO Auto-generated method stub
		this.addTypeAxiom(this.vocabulary_ELSEWEB.getOWLClass_Duration());
		addEndDate();
		addStartDate();
	}

	private void addEndDate(){
		if(duration.isSet_endDate()){
			OWLLiteral endDateLiteral = bundle.getDataFactory().getOWLLiteral(DatatypeConverter.printDate(duration.getEndDate()), this.vocabulary_XSD.getDataType_dateTime());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_ELSEWEB.getDataProperty_hasEndDate(), individual, endDateLiteral);
			add(axiom);
		}
	}
	
	private void addStartDate(){
		if(duration.isSet_startDate()){
			OWLLiteral startDateLiteral = bundle.getDataFactory().getOWLLiteral(DatatypeConverter.printDate(duration.getStartDate()), this.vocabulary_XSD.getDataType_dateTime());
			OWLAxiom axiom = bundle.getDataFactory().getOWLDataPropertyAssertionAxiom(vocabulary_ELSEWEB.getDataProperty_hasStartDate(), individual, startDateLiteral);
			add(axiom);
		}
	}

}
