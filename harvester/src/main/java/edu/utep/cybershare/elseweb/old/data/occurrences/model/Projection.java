package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public class Projection extends Element {

	private int epsgCode;
	
	public Projection(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		this.epsgCode = 0;
	}

	public boolean isSet_epsgCode(){return this.epsgCode != 0;}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @return the epsgCode
	 */
	public int getEpsgCode() {
		return epsgCode;
	}

	/**
	 * @param epsgCode the epsgCode to set
	 */
	public void setEpsgCode(int epsgCode) {
		this.epsgCode = epsgCode;
	}

}
