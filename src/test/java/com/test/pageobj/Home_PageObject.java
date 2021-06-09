package com.test.pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.utilities.TestApp;

import junit.framework.Assert;

public class Home_PageObject extends TestApp{

	TestApp testApp_obj = new TestApp();
	
	WebDriver driver;
	
	public Home_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath = "//span[contains(text(), '\"qa testing for beginners\"')]")
	WebElement searchResults;
	
	public Select_PageObject searchItem() throws Exception{
		
		seleniumUtil.explicitWait(10, searchTextBox, driver);
		
		searchTextBox.clear();
		searchTextBox.sendKeys(sBookName);
	
		searchButton.click();
		
		seleniumUtil.explicitWait(10, searchResults, driver);
		
		
		return new Select_PageObject(webDriver);
		
	}
}
