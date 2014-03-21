package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public abstract class Element {
	private String identification;
	
	public Element(String identification){
		if(identification == null)
			throw new IllegalArgumentException("Element ID must not be null.");
		
		this.identification = identification;
	}
	
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public abstract void accept(Visitor visitor);
}
