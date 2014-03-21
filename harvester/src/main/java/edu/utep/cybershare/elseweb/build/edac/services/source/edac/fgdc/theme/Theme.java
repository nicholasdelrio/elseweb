package edu.utep.cybershare.elseweb.build.edac.services.source.edac.fgdc.theme;

import java.util.ArrayList;

public class Theme {
	
	private String themekt;
	private ArrayList<String> themekey;

	public Theme(){
		themekey = new ArrayList<String>();
	}
	
	public void setThemekt(String themekt){
		this.themekt = themekt;
	}
	
	public void addThemekey(String themekey){
		this.themekey.add(themekey);
	}
	
	public String getThemekt(){
		return themekt;
	}
	
	public int getNumberOfThemeKeys(){
		return themekey.size();
	}
	
	public String getThemekey(){
		return themekey.get(0);
	}
	
	public String getSatellite(){
		return themekey.get(0);
	}
	
	public String getSensor(){
		return themekey.get(1);
	}
}