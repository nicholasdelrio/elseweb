package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public class Layer extends Element {
	
	private SpeciesOccurrenceSet occurrenceSet;
	
	
	public Layer(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}
	

	public boolean isSet_occurrenceSet(){return this.occurrenceSet != null;}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}


	/**
	 * @return the occurrenceSet
	 */
	public SpeciesOccurrenceSet getOccurrenceSet() {
		return occurrenceSet;
	}


	/**
	 * @param occurrenceSet the occurrenceSet to set
	 */
	public void setOccurrenceSet(SpeciesOccurrenceSet occurrenceSet) {
		this.occurrenceSet = occurrenceSet;
	}
	
	

}
