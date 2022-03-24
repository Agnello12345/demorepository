package com.crm.autodesk.generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile_Utility 
{
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
	    Properties prop = new Properties();
	    prop.load(fis);
	    String value = prop.getProperty(key);
	    return value;
	    }
	
}
