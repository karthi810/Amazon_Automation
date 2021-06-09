package com.test.driverutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface DriverManage_Interface {

	public WebDriver launchApp(String sBrowserName);
	public void quitApp();
}
