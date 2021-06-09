package com.test.utilities;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Utilities {
	
	public static String sPackageName;
	public static String sActivity;
	public static String sPlatformName;
	public static String sDeviceName;
	public static String sURL;
	
	static Properties props = new Properties();
	static FileInputStream fileIn = null;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public static String JsonFileRead_toString(String sPathOfJson) throws Exception {

		byte[] encoded = Files.readAllBytes(Paths.get(sPathOfJson));
		return new String(encoded, StandardCharsets.UTF_8);

	}
	
	public void loadLog4jProperty(String PropertiesFilePath) throws Exception {
		log.info("Log4j Property file Path :" + PropertiesFilePath);
		fileIn = new FileInputStream(PropertiesFilePath);
		props.load(fileIn);
		PropertyConfigurator.configure(props);
	}

}
