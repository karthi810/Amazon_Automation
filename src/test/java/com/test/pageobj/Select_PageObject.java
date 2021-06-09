package com.test.pageobj;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.utilities.TestApp;

public class Select_PageObject extends TestApp{

TestApp testApp_obj = new TestApp();
	
	//WebDriver driver;
	public Select_PageObject(WebDriver driver) {
		TestApp.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//a[@class='a-link-normal a-text-normal'][1]")
	WebElement firstBook;
	
	@FindBy(xpath = "//div[@data-index='1']/div/span/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[2]/a[@class='a-size-base a-link-normal a-text-normal']/span[@class='a-price']/span[@class='a-offscreen']")
	public WebElement price;
	
	@FindBy(xpath = "//span[@id='submit.add-to-cart']")
	WebElement addToCartButton;
	
	public ItemDetail_PageObject selectItem() throws Exception{

		
		seleniumUtil.explicitWait(1000, firstBook, TestApp.webDriver);
		
		iPrice = price.getText();
		firstBook.isEnabled();
		firstBook.click();
	
		JavascriptExecutor js = (JavascriptExecutor) TestApp.webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		
		
		seleniumUtil.explicitWait(1000, addToCartButton, TestApp.webDriver);
		
		return new ItemDetail_PageObject(TestApp.webDriver);
	}
}
