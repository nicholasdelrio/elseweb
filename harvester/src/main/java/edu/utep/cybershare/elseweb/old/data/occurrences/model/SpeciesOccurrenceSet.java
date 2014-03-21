package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public class SpeciesOccurrenceSet extends Element{

	private Species species;
	private int numberOfOccurrences;
	private int occurrenceSetID;
	
	public SpeciesOccurrenceSet(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		this.numberOfOccurrences = 0;
		this.occurrenceSetID = 0;
	}
	
	public boolean isSet_species(){return this.species != null;}
	public boolean isSet_numberOfOccurrences(){return this.numberOfOccurrences != 0;}
	public boolean isSet_occurrenceSetID(){return this.occurrenceSetID != 0;}
	
	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public int getNumberOfOccurrences() {
		return numberOfOccurrences;
	}

	public void setNumberOfOccurrences(int numberOfOccurrences) {
		this.numberOfOccurrences = numberOfOccurrences;
	}

	public int getOccurrenceSetID() {
		return occurrenceSetID;
	}

	public void setOccurrenceSetID(int occurrenceSetID) {
		this.occurrenceSetID = occurrenceSetID;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
