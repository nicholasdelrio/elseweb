package edu.utep.cybershare.elseweb.old.data.banded.model;

import java.net.URI;

public class Measurement extends Element {

	private Observation observation;
	private Characteristic characteristic;
	private URI responsibleAgent;
	
	public Measurement(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}

	public boolean isSet_Observation(){
		return this.getObservation() != null;
	}
	
	public boolean isSet_charactersitc(){
		return this.getCharacteristic() != null;
	}
	
	public boolean isSet_responsibleAgent(){
		return this.getResponsibleAgent() != null;
	}

	public Observation getObservation() {
		return observation;
	}

	public void setObservation(Observation observation) {
		this.observation = observation;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public URI getResponsibleAgent() {
		return responsibleAgent;
	}

	public void setResponsibleAgent(URI responsibleAgent) {
		this.responsibleAgent = responsibleAgent;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic measuresCharacteristic) {
		this.characteristic = measuresCharacteristic;
	}
}
