package edu.utep.cybershare.elseweb.old.data.occurrences.build.source.lifemapper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class OccurrenceSetsXML {
	
	private Document doc;
	private static String occurrenceSetsXMLURL = "http://www.lifemapper.org/services/sdm/occurrences/xml?minimumNumberOfPoints=100&perPage=1000&fullObjects=1";
	
	public OccurrenceSetsXML(){
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
			doc = docBuilder.parse(occurrenceSetsXMLURL);
			return doc;
		}
		catch(Exception e){e.printStackTrace();}
		return null;
	}
}
