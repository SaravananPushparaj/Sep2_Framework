package Generic_Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility_Class {

	
	public static String Reading_properties(String sKey) throws IOException
	{
		FileInputStream fis= new FileInputStream("Aug1batch.properties");
		Properties prop= new Properties();
		
		prop.load(fis);
		
		return prop.getProperty(sKey);
		
		
		
	}
	
}
