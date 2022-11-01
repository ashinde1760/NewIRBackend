package com.example.InvestorRelationBackend.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	public static Properties getPropertiesFromResources(String filename)
	{
		Properties properties=new Properties();
		InputStream stream=ReadProperties.class.getClassLoader().getResourceAsStream(filename);
	  try
	  {
		  properties.load(stream); 
		  
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
		  
	  }
	  return properties;
	
	}

}
