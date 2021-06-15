package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSetup {
	
WebDriver driver;
	
	@BeforeSuite
	public void browsersetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterSuite
    public void quit()
    {
       driver.quit();
        System.out.println("quit the browser");
    }

}
