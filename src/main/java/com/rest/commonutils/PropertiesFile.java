package com.rest.commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	private PropertiesFile() {
		
	}
	
	private static final String CURRENT_DIR = System.getProperty("user.dir");

	/**
	 * This method is used to get the values from the properites file
	 * 
	 * @param propetiesFileName - Properties file name
	 * @param key               - key from properties file
	 * @return - value for the key from properties file
	 */
	public static String getPropertyValue(String propetiesFileName, String key) {

		try (InputStream input = new FileInputStream(CURRENT_DIR + propetiesFileName)) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
