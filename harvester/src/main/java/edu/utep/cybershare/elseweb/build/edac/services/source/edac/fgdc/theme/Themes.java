package edu.utep.cybershare.elseweb.build.edac.services.source.edac.fgdc.theme;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Themes {	

	private static final String THEMEKT_ISO_19115_Topic_Categories = "ISO 19115 Topic Categories";
	private static final String THEMEKY_GCMD_Science = "GCMD Science";
	private static final String THEMEKY_EDAC = "None";
	private static final String THEME_CF = "CF";
	
	private Theme theme_ISO_19115_Topic_Categories;
	private Theme theme_GCMD_Science;
	private Theme theme_EDAC_Prism;
	private Theme theme_EDAC_MODIS;
	private Theme theme_CF;
	
	public Themes(Document fgdcDoc){
		NodeList themes = fgdcDoc.getElementsByTagName("theme");
		for(int i = 0; i < themes.getLength(); i ++)
			setTheme(getTheme(themes.item(i)));
	}
	
	private Theme getTheme(Node aThemeNode){
		NodeList themeParts = aThemeNode.getChildNodes();
		Node themePart;
		String tagName;
		String tagValue;
		Theme aTheme = new Theme();
		for(int i = 0; i < themeParts.getLength(); i ++){
			themePart = themeParts.item(i);
			tagName = themePart.getNodeName();
			tagValue = themePart.getTextContent();
			if(tagName.equals("themekt"))
				aTheme.setThemekt(tagValue);
			else if(tagName.equals("themekey"))
				aTheme.addThemekey(tagValue);
		}
		return aTheme;
	}
	
	private void setTheme(Theme aTheme){
		if(aTheme.getThemekt().equals(Themes.THEMEKT_ISO_19115_Topic_Categories))
			this.theme_ISO_19115_Topic_Categories = aTheme;
		else if(aTheme.getThemekt().equals(Themes.THEMEKY_GCMD_Science))
			this.theme_GCMD_Science = aTheme;
		else if(aTheme.getThemekt().equals(Themes.THEMEKY_EDAC))
			setSourceTheme(aTheme);
		else if(aTheme.getThemekt().equals(Themes.THEME_CF))
			this.theme_CF = aTheme;
	}
	
	private void setSourceTheme(Theme sourceTheme){
		if(sourceTheme.getNumberOfThemeKeys() == 2)
			this.theme_EDAC_Prism = sourceTheme;
		else
			this.theme_EDAC_MODIS = sourceTheme;
	}
	
	public Theme getTheme_ISO_19115_Topic_Categories(){
		return this.theme_ISO_19115_Topic_Categories;
	}
	
	public Theme getTheme_GCMD_Science(){
		return this.theme_GCMD_Science;
	}
	
	public Theme getTheme_CF(){
		return this.theme_CF;
	}
	
	public Theme getTheme_EDAC_Prism(){
		return this.theme_EDAC_Prism;
	}
	
	public Theme getTheme_EDAC_MODIS(){
		return this.theme_EDAC_MODIS;
	}
}