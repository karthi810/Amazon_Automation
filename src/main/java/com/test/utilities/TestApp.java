package com.test.utilities;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.jayway.jsonpath.JsonPath;

import com.test.webdriver.Webdriver_Manager;

public class TestApp {
	
	public static String sConfig;
	public static String sBrowserName;
	public static String sBookName;
	public static String sURL;
	public static String iPrice;
	
	

		
	public static WebDriver webDriver;
	public static Webdriver_Manager webDriverManager = new Webdriver_Manager();
	public static Selenium_utility seleniumUtil = new Selenium_utility();
	public static Utilities utility_obj = new Utilities();
	
			
	@BeforeSuite
	public void setAppConfig() throws Exception{
		
		String sPathOfConfigJson = System.getProperty("user.dir")+"/resources/TestData/config.properties";
		
		seleniumUtil.readConfigFile(sPathOfConfigJson);
		
		//sConfig = Utilities.JsonFileRead_toString(sPathOfConfigJson);
		
		System.out.println(sBookName+ sBrowserName+ sURL);
		
			//launching the Browser ---> chrome or firefox. ( depends on the value given in json file )
			webDriver = webDriverManager.launchApp(sBrowserName);
			System.out.println("Web Driver in Test APP : "+webDriver);
		
	
		
	}
	
	@AfterSuite
	public void quitApp(){
		
			webDriverManager.quitApp();

	}
	

}
