package edu.utep.cybershare.elseweb.old.parameters.build.source.lifemapper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ParametersXML {
	
	private Document doc;
	private static String parametersXMLURL = "http://lifemapper.org/clients/algorithms.xml";
	
	public ParametersXML(){
		doc = getDocument();
	}
	
	public Document getDOMObject(){
		return doc;
	}
	
	private Document getDocument(){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(parametersXMLURL);
			return doc;
		}
		catch(Exception e){e.printStackTrace();}
		return null;
	}
}
