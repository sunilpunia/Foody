package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class manageConfigProperties {
	
	Properties pro;
	public manageConfigProperties() {
		
		try {
			//File src=new File("./resources/data.properties");
			File src=new File("./Config/Config.properties");
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);			
		} 
		catch (Exception e) {
			System.err.println("Exception is =="+ e.getMessage());	
		}
	}
	
	public String getDataFromConfig(String keyToSearch) {
		
		    return pro.getProperty(keyToSearch);
	}
	
	
	public String getBrowser() {
		
		 return pro.getProperty("browser");
	}

	public String getStgURL() {
		 return pro.getProperty("stgURL");
	}
		 
    public String getTestUrl() {
    	 return pro.getProperty("qaURL");
    }
		 
    public String getExcelPath() {
   	 return pro.getProperty("excel1");
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
