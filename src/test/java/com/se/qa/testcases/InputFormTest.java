package com.se.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.se.qa.base.TestBase;
import com.se.qa.pages.DemoPageHelper;
import com.se.qa.pages.InputFormHelper;


public class InputFormTest extends TestBase {
	InputFormHelper inputFormHelper;
	DemoPageHelper demoPageHelper;
	
	public InputFormTest() {
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		openDemoWebsite();
		inputFormHelper = new InputFormHelper(); 
	}
	
	@Test (priority=0)	
	public void validateHomePageTitleTest(){
		String title=inputFormHelper.validateHomePageTitle();
		Assert.assertEquals(title, "Selenium Easy - Best Demo website to practice Selenium Webdriver Online");

	}
	
	@Test (priority=1)
	public void inputFormMultiSelectListDemoTest() throws InterruptedException{
		
		inputFormHelper.clickonInputFormDropdown();
		inputFormHelper.clickoninputFormSelectDropdownList();
		String actualstr=inputFormHelper.inputFormMultiSelectListDemo();
		Assert.assertEquals(actualstr, "Options selected are : Pennsylvania");	
	}
	
	
	@Test (priority=2)
	public void inputFormRadioButtonDemoTest(){
		
		inputFormHelper.clickonInputFormDropdown();
		inputFormHelper.clickonInputFormRadioButton();
		boolean flag = inputFormHelper.ValidateinputFormRadioButton();
		System.out.println(driver.getTitle());
		Assert.assertTrue(flag);
	}

	@Test (priority=3)
	public void inputFormSelectDropdownListTest(){
		
		inputFormHelper.clickonInputFormDropdown();
		inputFormHelper.clickoninputFormSelectDropdownList();
		String actualstr=inputFormHelper.inputFormSelectDropdownList();
		Assert.assertEquals(actualstr, "Day selected :- Sunday");	
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


	}

