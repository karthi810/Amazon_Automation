package com.test.pageobj;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.utilities.TestApp;


public class ItemDetail_PageObject extends TestApp {

	TestApp testApp_obj = new TestApp();
	
	
	public ItemDetail_PageObject(WebDriver driver) {
		TestApp.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="newBuyBoxPrice")
	WebElement price;
	
	@FindBy(xpath = "//span[@id='submit.add-to-cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
	WebElement proceedToCheckout;
	
	@FindBy(xpath = "//div[@class='a-row a-spacing-micro']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement finalAmount;
	
	@FindBy(xpath = "//input[@id = 'ap_email']")
	WebElement loginUsername;
	
	public void addToCart() throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) TestApp.webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
			
		addToCartButton.click();
		seleniumUtil.explicitWait(1000, proceedToCheckout, TestApp.webDriver);
	
		if(finalAmount.getText()!=null) {
			proceedToCheckout.click();
				
			seleniumUtil.explicitWait(1000, loginUsername, webDriver);
			loginUsername.isDisplayed();
		}
		else {
			System.out.println("Check item quantity!");
		}
		
		
	}
	
}
