package DataDriven.DataD.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigDetails {

	
	public  String getPropertyValue(String property) {
		
		
		
		String configPath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Config.properties";
		System.out.println(configPath + "this is config path");
		//inputStream = null;
		Properties prop = new Properties();
		try {
		FileInputStream  inputStream = new FileInputStream(configPath);	
		prop.load(inputStream);	
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	 
    return prop.getProperty(property);
	
	}
	
}
