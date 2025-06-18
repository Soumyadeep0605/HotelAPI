package API_Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class XMLTemplateUpdater {
	
	public static String getUpdatedXML(String filepath, Map<String,String> dataMap) throws IOException
	{
		String xml= new String(Files.readAllBytes(Paths.get(filepath)));
		
		for(Map.Entry<String,String> entry : dataMap.entrySet())
		{
			String placeholder= "${"+ entry.getKey() + "}";
			xml= xml.replace(placeholder, entry.getValue());
		}
		
		return xml;
		
	}

}
