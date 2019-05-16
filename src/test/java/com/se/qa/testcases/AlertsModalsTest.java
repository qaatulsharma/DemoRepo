package com.se.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.se.qa.base.TestBase;
import com.se.qa.pages.AlertModalsHelper;
public class AlertsModalsTest extends TestBase {
	
	AlertModalsHelper alertModalsHelper;
	
	public AlertsModalsTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		openDemoWebsite();
		alertModalsHelper= new AlertModalsHelper();
	}
	
	@Test (priority=1)
public void singlewindowpopuptest() {
		String title=alertModalsHelper.singlewindowpopup();
		Assert.assertEquals(title, "Selenium Easy (@seleniumeasy) on Twitter");

	}
	
	
	@Test (priority=2)
	public void multiplewindowpopuptest () {
		
		String title=alertModalsHelper.singlewindowpopup();
		Assert.assertEquals(title, "Selenium Easy (@seleniumeasy) on Twitter");
		
	}
	


	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


	}

