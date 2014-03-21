package edu.utep.cybershare.elseweb.old.data.banded.util;

import java.net.URI;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

public class StringManipulation {
	public static String SHAsum(byte[] convertme){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-1"); 
			return byteArray2Hex(md.digest(convertme));
		}catch(Exception e){e.printStackTrace();}
		return null;
	}

	private static String byteArray2Hex(final byte[] hash) {
	    Formatter formatter = new Formatter();
	    for (byte b : hash) {
	        formatter.format("%02x", b);
	    }
	    String hex = formatter.toString();
	    formatter.close();
	    return hex;
	}
	
	public static String makeURICompliantFragment(String candidateIRIFragment, String baseURI){		
		/*String newIRIFragment = candidateIRIFragment
				.replaceAll("[^A-Za-z0-9\\s]", "")
				.replaceAll("\\s", "-");*/
		String newIRIFragment = candidateIRIFragment.replaceAll(" ", "-");
		
		if(!baseURI.endsWith("/"))
			baseURI += "/";
			
		try{
			new URI(baseURI + newIRIFragment);
			return newIRIFragment;
		}
		catch(Exception e){
			System.err.println("Offending Name: " + candidateIRIFragment);
			for(int i = 0; i < candidateIRIFragment.length(); i ++)
				System.err.println("character: " + candidateIRIFragment.charAt(i) + ", value: " + candidateIRIFragment.codePointAt(i));
			e.printStackTrace();
		}
		return null;
	}
	public static String encodeValueForXML(List<String> list){
		String stringList = "";
		for(String item : list)
			stringList += StringManipulation.encodeValueForXML(item) + ",";
		
		if(stringList.isEmpty())
			stringList="nullvalue";

		return stringList;
	}
	public static String encodeValueForXML(String value){
		if(value != null && !value.isEmpty()){
			String text = StringEscapeUtils.escapeXml(value);
			text = StringEscapeUtils.escapeHtml(text);
			return text;
		}
					
		return "nullvalue";
	}
	
	public static URI isURI(String uriString){
		URI uri = null;
		try{uri = new URI(uriString);}
		catch(Exception e){e.printStackTrace();}
		return uri;
	}
}
