package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public class Species extends Element {

	private String canonicalName;
	
	public Species(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSet_canonicalName(){return this.canonicalName != null;}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	/**
	 * @return the canonicalName
	 */
	public String getCanonicalName() {
		return canonicalName;
	}

	/**
	 * @param canonicalName the canonicalName to set
	 */
	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}

}
