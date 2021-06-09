package com.test.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.driverutilities.DriverManage_Interface;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver_Manager implements Webdriver_interface, DriverManage_Interface {

	public WebDriver driver;

	@Override
	public WebDriver launchApp(String sBrowserName) {
		if (sBrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(sBrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;

	}

	@Override
	public void quitApp() {
		driver.quit();

	}

	@Override
	public WebDriver getDriver() {
		
		return driver;
	}

}
