package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
	public static void main(String[] args){

		String url = "http://shop.demoqa.com/";
		
		// Create a new instance of the Firefox driver
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mr Truong\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		
		// Launch the Online Store Website
		driver.get(url);

		// Print a Log In message to the screen
		System.out.println(url);

		// Wait for 5 Sec
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close the driver
		driver.quit();
	}
}
