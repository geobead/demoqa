package com.demoqa.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.qa.util.BrowserFactory;

public class DemoQATests {

	//runs once per class
	@BeforeTest
	public void setUp() {
		System.out.println("This is setUp()");
	}
	
	@Test
	public void factoryPatternTest1() {
		WebDriver driver = BrowserFactory.getBrowser("chrome");
		WebDriver driver2 = BrowserFactory.getBrowser("chrome");
		if(driver.equals(driver2)) {
			System.out.println("same drivers");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//runs once per class
	@AfterTest
	public void tearDown() {
		System.out.println("This is tearDown()");
		BrowserFactory.closeAllDrivers();
	}
	
}
