package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public class Region extends Element{
	
	private double llon;
	private double rlon;
	private double llat;
	private double ulat;
	
	public Region(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		
		llon = 0;
		rlon = 0;
		llat = 0;
		ulat = 0;
	}
	
	public boolean isSet_llon(){
		return this.getLlon() != 0;
	}
	
	public boolean isSet_rlon(){
		return this.getRlon() != 0;
	}
	
	public boolean isSet_llat(){
		return this.getLlat() != 0;
	}
	
	public boolean isSet_ulat(){
		return this.getUlat() != 0;
	}

	public double getLlon() {
		return llon;
	}

	public void setLlon(double llon) {
		this.llon = llon;
	}

	public double getRlon() {
		return rlon;
	}

	public void setRlon(double rlon) {
		this.rlon = rlon;
	}

	public double getLlat() {
		return llat;
	}

	public void setLlat(double llat) {
		this.llat = llat;
	}

	public double getUlat() {
		return ulat;
	}

	public void setUlat(double ulat) {
		this.ulat = ulat;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
