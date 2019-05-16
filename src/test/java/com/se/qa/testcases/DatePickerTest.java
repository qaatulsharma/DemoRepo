package com.se.qa.testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.se.qa.base.TestBase;
import com.se.qa.pages.DatePickerHelper;




public class DatePickerTest extends TestBase {
	DatePickerHelper datePickerHelper;
	public DatePickerTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		openDemoWebsite();
		datePickerHelper = new DatePickerHelper(); 
	}
	
	@Test (priority=1)	
	
	public void BootstrapDatePickerTest(){
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Date pickers')]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Date Picker')]")).click();
		driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-th']")).click();
		driver.findElement(By.xpath("//td[@class='old day'][contains(text(),'29')]")).click();
		//datePickerHelper.selectCalendarDate();
		String SelectedDate=driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).getText();
		System.out.println(SelectedDate);
		//Assert.assertEquals(SelectedDate, "02/05/2019");
		Assert.assertTrue(SelectedDate.equals("02/05/2019"));
		
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


	}

