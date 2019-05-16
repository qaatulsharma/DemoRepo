package com.se.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.se.qa.base.TestBase;



public class DragandDropTest extends TestBase {
	
	public DragandDropTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		openDemoWebsite();
	}
	
	@Test (priority=1)	
	
	public void DragandDropedTest() throws InterruptedException{
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Others')]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Drag and Drop')]")).click();
		
		WebElement From=driver.findElement(By.xpath("//span[contains(text(),'Draggable 1')]"));
		WebElement To = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		//Using Action class for drag and drop.	
		 Actions act=new Actions(driver);					
		//Dragged and dropped.		
		 act.dragAndDropBy(From,100, 20);
		//act.dragAndDrop(From,To).build().perform();
		/* act
		   .clickAndHold(From)
		   .moveToElement(To)      // !!! SET BREAKPOINT HERE !!!
		   .release()
		   .perform();*/
		// act.clickAndHold(From).moveByOffset(20, 0).release(From).perform();
		// driver.wait(10);

		From=driver.findElement(By.xpath("//span[contains(text(),'Draggable 2')]"));
		To = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		//Dragged and dropped.		
		act.dragAndDrop(From,To).build().perform();
		
	
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}


	}

