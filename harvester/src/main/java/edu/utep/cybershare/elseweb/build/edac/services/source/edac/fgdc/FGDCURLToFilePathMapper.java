package edu.utep.cybershare.elseweb.build.edac.services.source.edac.fgdc;

import java.io.File;
import java.net.URL;

import edu.utep.cybershare.elseweb.old.data.banded.util.FilePath;

public class FGDCURLToFilePathMapper {
	
	public static File getFilePath(URL url){
		String partialPath = url.getPath();
		File fgdcFile = new File(FilePath.EDAC_METADATA_DIR + partialPath);
		if(fgdcFile.exists())
			return fgdcFile;
		else{
			System.out.println("required file does not exist: " + fgdcFile.getAbsolutePath());
			return null;
		}
	}
}
