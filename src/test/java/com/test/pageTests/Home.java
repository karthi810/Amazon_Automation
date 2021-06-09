package com.test.pageTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pageobj.Home_PageObject;
import com.test.pageobj.ItemDetail_PageObject;
import com.test.pageobj.Select_PageObject;
import com.test.utilities.TestApp;

public class Home extends TestApp{
	
	Home_PageObject home_obj;
	Select_PageObject select_obj; 
	ItemDetail_PageObject itemDetail_obj;
	
	
	
	@BeforeTest
	public void set_loginDependencies() throws Exception{
		
		home_obj = new Home_PageObject(webDriver);
		select_obj = new Select_PageObject(webDriver);
		itemDetail_obj = new ItemDetail_PageObject(webDriver);
		
		seleniumUtil.gotoURL(sURL);
		
	}
	
	
	@Test(priority = 1)
	public void TC_1() throws Exception {
		
		select_obj = home_obj.searchItem();

	}
	@Test(priority = 2)
	public void TC_2() throws Exception{
		itemDetail_obj = select_obj.selectItem();
		
	}
	
	@Test(priority = 3)
	public void TC_3() throws Exception{
		itemDetail_obj.addToCart();
	}
	

}
