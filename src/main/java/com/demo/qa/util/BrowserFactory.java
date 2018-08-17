package com.demo.qa.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	
	
	/*
	 *  Factory method for getting browsers
	 */
	
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = drivers.get("firefox");
			if(driver==null) {
				driver = new FirefoxDriver();
				drivers.put("firefox", driver);
			}
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=drivers.get("chrome");
			if(driver==null) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Mr Truong\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				drivers.put("chrome", driver);
			}
		}
		return driver;
	}
	
	public static void closeAllDrivers() {
		for(String key: drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
