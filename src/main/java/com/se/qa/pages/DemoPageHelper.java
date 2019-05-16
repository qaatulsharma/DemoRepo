package com.se.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.se.qa.base.TestBase;
import com.se.qa.util.TestUtil;

public class DemoPageHelper extends TestBase {

	//Page Factory or OR:
	
	@FindBy (xpath="//a[contains(text(),'Demo Website!')]")
	WebElement demoWebsite;
	
	@FindBy (xpath="(//div [contains(text(),'Select List Demo')])[1]")
	WebElement SelectListDemoSection;

	// Initializing the PageObjects
	public DemoPageHelper(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateDemoPageTitle(){
		return driver.getTitle();
	}

	public boolean validateDemoPageLinkAvailable(){
		return demoWebsite.isDisplayed();
	}
	public InputFormHelper openDemoPage(){
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		demoWebsite.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		return new InputFormHelper();
		}
}