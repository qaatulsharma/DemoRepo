package com.se.qa.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.se.qa.base.TestBase;


public class AlertModalsHelper extends TestBase {

	//Page Factory or OR:
	@FindBy (xpath="//a[contains(text(),'Demo Website!')]")
	WebElement demoWebsite;

	@FindBy (xpath="(//div [contains(text(),'Select List Demo')])[1]")
	WebElement SelectListDemoSection;

	// Initializing the PageObjects
	public AlertModalsHelper(){
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String singlewindowpopup() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Alerts & Modals')]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Window Popup Modal')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]")).click();

		Set<String> allWindowHandler = driver.getWindowHandles();

		Iterator<String> it=allWindowHandler.iterator();

		String parentWindowId =it.next();
		System.out.println("Parent WindowId: "+parentWindowId);

		String childWindowId=it.next();
		System.out.println("Pop-up WindowId: "+childWindowId);

		driver.switchTo().window(childWindowId);

		System.out.println("Child Window Title :"+driver.getTitle());
		return driver.getTitle();

	}

	public String multiplewindowpopup() {

		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Alerts & Modals')]")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Window Popup Modal')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]")).click();
		driver.findElement(By.xpath("//a[@id='followall']")).click();
		Set<String> allWindowHandler = driver.getWindowHandles();

		Iterator<String> it=allWindowHandler.iterator();

		String parentWindowId =it.next();
		System.out.println("Parent WindowId: "+parentWindowId);

		String childWindowId=it.next();
		System.out.println("Pop-up 1 WindowId: "+childWindowId);

		String childWindow2Id=it.next();
		System.out.println("Pop-up 2 WindowId: "+childWindow2Id);

		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window Title :"+driver.getTitle());
		String WindowTitle=driver.getTitle();
		if(WindowTitle.equals("Selenium Easy - Window Popup Modal Demo")) {
			driver.switchTo().window(childWindowId);
			System.out.println("Child1 Window Title :"+driver.getTitle());
			WindowTitle=driver.getTitle();
			if(WindowTitle.equals("Sign in – Google accounts")) {
				driver.switchTo().window(childWindow2Id);
				System.out.println("Child 2 Window Title :"+driver.getTitle());
				WindowTitle= driver.getTitle();
			}
		}
		return WindowTitle;
	}
	
}
