	package com.se.qa.util;

import com.se.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	
	public static long IMPLICIT_WAIT=10;
	
	public void switchtoframe(){
		driver.switchTo().frame("mainpanel");
	}
	

}
