package com.se.qa.testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.se.qa.base.TestBase;

public class TableSortSearchTest extends TestBase {
	
	public TableSortSearchTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		openDemoWebsite();
	}
	
	@Test (priority=1)
	public void tableSearchTest() {
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Table')]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Table Sort & Search')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input")).sendKeys("San Francisco");
		String searchvalue = driver.findElement(By.xpath("//tr[1]//td[3]")).getText();
		System.out.println(searchvalue);
		Assert.assertEquals(searchvalue, "San Francisco");	
	}
	
	
	@Test (priority=2)

	public void tableSortTest() {
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Table')]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Table Sort & Search')]")).click();
		driver.findElement(By.xpath("//th[contains(text(),'Age')]")).click();
		String sortvalue = driver.findElement(By.xpath("//tr[1]//td[4]")).getText();
		System.out.println(sortvalue);
		Assert.assertEquals(sortvalue, "19");	
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


	}

