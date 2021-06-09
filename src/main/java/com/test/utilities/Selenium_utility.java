package com.test.utilities;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.webdriver.Webdriver_Manager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_utility extends TestApp {

	//Webdriver_Manager webDriverManager = new Webdriver_Manager();
	
//	public WebDriver launchApp() {
//		
//		webDriverManager.launchApp(sBrowserName);
//		return webDriverManager.getDriver();
//	}
//	
//	public void quitApp() {
//		webDriverManager.quitApp();
//	}
	
	
	public void gotoURL(String url) {
		webDriver = webDriverManager.getDriver();
		System.out.println("Web Driver in gotoURL : "+webDriver);
		webDriver.get(url);
		webDriver.manage().window().maximize();
	}

	public void loginDetails(WebElement elem, String val) {
		elem.clear();
		elem.sendKeys(val);
	}

	public void login(WebElement elem) {
		elem.click();
	}

	public void explicitWait(int sec, WebElement elem, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(elem));
	}

	
	
	public void clearField(WebElement ele) {
		ele.clear();
	}
	
	public void sendData(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	public static void readConfigFile(String configFilePath) throws Exception {
		//String configFilePath = System.getProperty("user.dir") + "/config.properties";
		FileInputStream configFile = new FileInputStream(configFilePath);

		Properties pObj = new Properties();
		pObj.load(configFile);
		System.getProperties().putAll(pObj);
		
		sBookName = pObj.getProperty("BookName");
		sBrowserName = pObj.getProperty("browser");
		sURL = pObj.getProperty("URL");
		
		/*
		 * String credentialsAndURL = "";
		 * 
		 * credentialsAndURL = System.getProperty("username") + " " +
		 * System.getProperty("password") + " " + System.getProperty("url") + " " +
		 * System.getProperty("kayakURL"); return credentialsAndURL;
		 */
	}

}
