package com.se.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.se.qa.base.TestBase;

public class InputFormHelper extends TestBase {

	//Page Factory or OR:
	@FindBy (xpath="//h3[contains(text(),'Welcome to Selenium Easy')])]")
	WebElement welcomeMessage;

	@FindBy (xpath="//a[contains(text(), 'Input Forms')] //parent::li[@class='dropdown']")
	WebElement inputFormDropdownMenu;
	
	@FindBy (xpath="//*[@class='dropdown-menu']/li[4]/a[@href='./basic-select-dropdown-demo.html']")
	WebElement inputFormSelectDropdownList;

	@FindBy (xpath="//*[@class='dropdown-menu']/li[3]/a[@href='./basic-radiobutton-demo.html']")
	WebElement inputFormRadioButtonDemo;	


	// Initializing the PageObjects
	public InputFormHelper(){
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
		public void clickonInputFormDropdown(){
			inputFormDropdownMenu.click();
	}
		
		public void clickoninputFormSelectDropdownList(){
			inputFormSelectDropdownList.click();
	}
		public String ValidateinputFormMultiSelectListDemoTest(){
			return driver.getTitle();
		}
		
		public void clickonInputFormRadioButton(){
						inputFormRadioButtonDemo.click();
		}
		public boolean ValidateinputFormRadioButton(){
			boolean flag = driver.findElement(By.xpath("//div[contains(text(),'Radio Button Demo')]")).isDisplayed();
			return flag;
		}
		public String inputFormMultiSelectListDemo(){
			WebElement mySelectElement = driver.findElement(By.xpath("//select[@id='multi-select']"));
			Select dropdown= new Select(mySelectElement);
			 List<WebElement> options = dropdown.getOptions();
			 for (WebElement option : options) {
			 System.out.println(option.getText());  
			 }
			driver.findElement(By.xpath("//option[contains(text(),'New York')]")).click();
			driver.findElement(By.xpath("//option[contains(text(),'Pennsylvania')]")).click();
			driver.findElement(By.xpath("//button[@id='printAll']")).click();
			String actualstr=driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
			System.out.println(actualstr);
			return actualstr;
		}
		public String inputFormSelectDropdownList(){
			boolean flag = driver.findElement(By.xpath("//h3[contains(text(),'This would be your first example on select dropd d')]")).isDisplayed();
			Assert.assertTrue(flag);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//select[@id='select-demo']")).click();
			driver.findElement(By.xpath("//Option[@value='Sunday']")).click();
			String actualstr=driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
			System.out.println(actualstr);
			return actualstr;
		}
}
