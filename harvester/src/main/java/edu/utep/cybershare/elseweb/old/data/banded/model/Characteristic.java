package edu.utep.cybershare.elseweb.old.data.banded.model;

public class Characteristic extends Element{

	private String themeKey;
	
	public Characteristic(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	public boolean isSet_themekey(){
		return this.getThemekey() != null;
	}
	
	public String getThemekey(){
		return this.themeKey;
	}
	
	public void setThemekey(String themekey){
		this.themeKey = themekey;
	}
}
