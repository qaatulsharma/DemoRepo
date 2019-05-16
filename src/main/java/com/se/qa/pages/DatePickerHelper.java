
package com.se.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.se.qa.base.TestBase;
import com.se.qa.util.TestUtil;

public class DatePickerHelper extends TestBase {

	//Page Factory or OR:
	@FindBy (xpath="//a[contains(text(),'Demo Website!')]")
	WebElement demoWebsite;
	
	@FindBy (xpath="(//div [contains(text(),'Select List Demo')])[1]")
	WebElement SelectListDemoSection;

	// Initializing the PageObjects
	public DatePickerHelper(){
		PageFactory.initElements(driver, this);
	}

	// Actions

			public void selectCalendarDate(){

			List<WebElement>  col= driver.findElements(By.xpath("//div[@class='datepicker-years']//tbody/tr/td/span"));
			System.out.println(col.size());

			//Select Year 

			for (int i =1; i <col.size(); i++) {

				String yr= driver.findElement(By.xpath("//div[@class='datepicker-years']//tbody/tr/td/span["+i+"]")).getText();
				//System.out.println(yr);

				if (yr.equals("2018")){
					driver.findElement(By.xpath("//div[@class='datepicker-years']//tbody/tr/td/span["+i+"]")).click();

					break;
				}

			}

			//Select Month

			for (int i =1; i <col.size(); i++) {

				String month= driver.findElement(By.xpath("//div[@class='datepicker-months']//tbody/tr/td/span["+i+"]")).getText();
				//System.out.println(month);

				if (month.equals("Mar")){
					driver.findElement(By.xpath("//div[@class='datepicker-months']//tbody/tr/td/span["+i+"]")).click();
					break;
				}

			}

			//Select Day
			List<WebElement>  rowList= driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody/tr"));
			System.out.println("Row Count is:"+rowList.size());
			List<WebElement>  colList = driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody/tr[1]/td"));
			System.out.println("Column size is:" + colList.size());


			for (int i = 1; i < rowList.size(); i++)
			{
				boolean found=false;
				for (int j = 1; j < colList.size(); j++)
				{
					String d = driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println("//div[@class='datepicker-days']//tbody/tr["+i+"]/td["+j+"]");
					if(d.equals("15"))
					{ 
						driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody/tr["+i+"]/td["+j+"]")).click();
						found=true;
						break;
					}
				}
				if(found)
				{
					break;
				}
			}



}}