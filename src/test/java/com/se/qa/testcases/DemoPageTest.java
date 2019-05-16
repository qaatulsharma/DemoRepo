package com.se.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.se.qa.base.TestBase;
import com.se.qa.pages.DemoPageHelper;
//import com.se.qa.pages.InputFormHelper;

public class DemoPageTest extends TestBase {

	DemoPageHelper demoPageHelper;

	public DemoPageTest(){
		super();
	};

	@BeforeMethod
	public void setUp(){
		initialization();
		demoPageHelper = new DemoPageHelper(); 
	}
	

	@Test (priority=1)
	public void demoPageTitleTest(){
		String title=demoPageHelper.validateDemoPageTitle();
		Assert.assertEquals(title, "Learn Selenium with Best Practices and Examples | Selenium Easy");

	}

	@Test (priority=2)
	public void validateDemoPageLinkAvailableTest(){
		Boolean Flag=demoPageHelper.validateDemoPageLinkAvailable();
		Assert.assertTrue(Flag);
	
	}
	@Test (priority=3)
	public void openDemoPageTest(){
		demoPageHelper.openDemoPage();	
	
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

//Test cases should be independent
//Before each test case launch the browser and login
//@test -- execute test cases
//after each test case  close the browser