package com.se.qa.base;

import org.openqa.selenium.By;
//import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.se.qa.util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class TestBase {

	protected static WebDriver driver; 
	public static Properties prop;
	public static String Baselocation=System.getProperty("user.dir");


	public TestBase(){

		try{
			prop= new Properties();
			FileInputStream ip = new FileInputStream(Baselocation+
					"/src/main/java/com/se/qa/config/config.properties");
			prop.load(ip);

		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}

	}
		
	// Initialize Browser
	//Maximize, DeleteAllCookies, manage timeouts and open URL
	
	public static void initialization(){
		String browsername=prop.getProperty("browser");
		System.out.println(Baselocation);

		if (browsername.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", Baselocation+"/lib/chromedriver.exe");
			driver=new ChromeDriver();
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);*/
		}
		else if (browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", Baselocation+"/lib/GeckoDriver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
	}
	
	//Open Demo Website
	public static void openDemoWebsite(){
		driver.findElement(By.xpath("//a[contains(text(),'Demo Website!')]")).click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	}
}
