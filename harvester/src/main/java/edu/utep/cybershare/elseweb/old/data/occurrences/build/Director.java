package edu.utep.cybershare.elseweb.old.data.occurrences.build;

import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import edu.utep.cybershare.elseweb.old.data.occurrences.build.source.lifemapper.OccurrenceSetsXML;

public class Director {
	
	private Builder builder;
	
	public Director(Builder builder){
		this.builder = builder;
	}
	
	public void construct(OccurrenceSetsXML occurrenceSetsXML){
		Document document = occurrenceSetsXML.getDOMObject();
		
		NodeList occurrenceSets = document.getElementsByTagName("lm:item");
		
		Element occurrenceSetMetadata;
		for(int i = 0; i < occurrenceSets.getLength(); i ++){
			//System.out.println("building RDF for occurrence dataset number: " + (i + 1));
			occurrenceSetMetadata = (Element)occurrenceSets.item(i);
			buildDataset(occurrenceSetMetadata);
		}
	}
	
	private void buildDataset(Element occurrenceSetMetadata){

		String epsgCode = occurrenceSetMetadata.getElementsByTagName("lm:epsgcode").item(0).getTextContent().trim();
				
		String occurrenceSetID = occurrenceSetMetadata.getElementsByTagName("lm:id").item(0).getTextContent().trim();

		String metadataURL = occurrenceSetMetadata.getElementsByTagName("lm:metadataUrl").item(0).getTextContent().trim();
		
		String rlon = null, ulat = null, llon = null, llat = null;

		if(occurrenceSetMetadata.getElementsByTagName("lm:maxX").getLength() > 0)
			rlon = occurrenceSetMetadata.getElementsByTagName("lm:maxX").item(0).getTextContent().trim();

		if(occurrenceSetMetadata.getElementsByTagName("lm:maxY").getLength() > 0)
			ulat = occurrenceSetMetadata.getElementsByTagName("lm:maxY").item(0).getTextContent().trim();
		
		if(occurrenceSetMetadata.getElementsByTagName("lm:minX").getLength() > 0)
			llon = occurrenceSetMetadata.getElementsByTagName("lm:minX").item(0).getTextContent().trim();
		
		if(occurrenceSetMetadata.getElementsByTagName("lm:minX").getLength() > 0)
			llat = occurrenceSetMetadata.getElementsByTagName("lm:minX").item(0).getTextContent().trim();

		String numberOfOccurrences = occurrenceSetMetadata.getElementsByTagName("lm:queryCount").item(0).getTextContent().trim();

		String speciesName = occurrenceSetMetadata.getElementsByTagName("lm:title").item(0).getTextContent().trim();
				
		try{
			builder.buildSpeciesOccurrenceLayer(Integer.valueOf(occurrenceSetID), Integer.valueOf(numberOfOccurrences), speciesName);
			builder.buildRegion(Double.valueOf(llon), Double.valueOf(rlon), Double.valueOf(llat), Double.valueOf(ulat));
			builder.buildDataset(speciesName, Integer.valueOf(epsgCode), new URL(metadataURL));
		}catch(Exception e){e.printStackTrace();}
		
		builder.assemble();
	}
		
}
