package edu.utep.cybershare.elseweb.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.UUID;

public class FileSupport{
	
	private static final String JSON_SPEC_FILENAME = "specification.json";
	private static final String SPEC_FILENAME = "specification.owl";
	
	private ServerInformation serverInformation;
	private String uuid;
	
	private File specFileName;
	private File specFilePath;
	
	private File jsonSpecFileName;
	private File jsonSpecFilePath;
	
	public FileSupport(){
		serverInformation = new ServerInformation();
		uuid = UUID.randomUUID().toString();
		
		specFileName = this.getRandomFile(SPEC_FILENAME);
		specFilePath = serverInformation.getSpecificationFilePath(specFileName);
		
		jsonSpecFileName = this.getRandomFile(JSON_SPEC_FILENAME);
		jsonSpecFilePath = serverInformation.getSpecificationFilePath(jsonSpecFileName);
	}
	
	public String getID(){return uuid;}
	
	public URL dumpJSONSpecification(String contents){
		writeTextFile(contents, jsonSpecFilePath);
		return serverInformation.getSpecificationURL(jsonSpecFileName);
	}
	
	public File getSpecificationFilePath(){
		return specFilePath;
	}
	
	public URL getSpecificationURL(){
		return serverInformation.getSpecificationURL(specFileName);
	}
	
	private File getRandomFile(String fileName){
		String[] fileNameParts = fileName.split("\\.");
		String name = fileNameParts[0];
		String extension = fileNameParts[1];
		String wcsResponseFileName = name + "-" + uuid + "." + extension;
		File wcsResponseFile = new File(wcsResponseFileName);	
		
		return wcsResponseFile;
	}
		
	public static void writeTextFile(String contents, File file){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(contents);
			out.close();
		}
		catch (Exception e){e.printStackTrace();}
	}
	
	public static void writeBinaryFile(byte[] contents, File file){
		try{
			FileOutputStream out = new FileOutputStream(file);
			out.write(contents);
			out.close();
		}
		catch (Exception e){e.printStackTrace();}
	}

	public static byte[] readBinaryFile(File file){
		byte[] contents = new byte[0];
		try{
			FileInputStream in = new FileInputStream(file);
			contents = new byte[(int) file.length()];
			in.read(contents);
			in.close();
		}
		catch (Exception e){e.printStackTrace();}
		return contents;
	}

	public static String readTextFile(File file){
		String contents = null;
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;

			while ((line = in.readLine()) != null){
				if (contents == null)
					contents = line + "\n";
				else
					contents = contents + line + "\n";
			}
			in.close();
		}
		catch (Exception e){e.printStackTrace();}
		return contents;
	}
}