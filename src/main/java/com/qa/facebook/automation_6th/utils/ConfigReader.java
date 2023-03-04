package com.qa.facebook.automation_6th.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/**
	 * This methed used to load the properties from config.Properties file
	 * @return it return properties prop
	 */
	
	
	
	public Properties initialize_Properties() {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("./src/test/resources/Config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	
	
	
}
