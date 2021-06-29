package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.Screenshots;

public class BaseSetup
{

WebDriver driver;

 
 	@BeforeSuite
	@Parameters("browser")
	
	public void browsersetup(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Driver\\geckodriver\\geckodriver.exe" );  
	 		DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
	 	    capabilities.setCapability("marionette",true);  
	 	    driver= new FirefoxDriver(capabilities);
		}
		
	}
	
	@AfterSuite
    public void quit()
    {
        driver.quit();
        System.out.println("quit the browser");
    }
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			TakesScreenshot takescreenshot=(TakesScreenshot)driver;
			File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\91773\\eclipse-workspace\\Buffalocart\\fail_screenshot"));
		}
		else if(ITestResult.SUCCESS==result.getStatus())
		{
			Screenshots s = new Screenshots();
			s.takeScreenshots(driver, result.getName().toString()+"_success");
		}
		
		driver.close();
	}
	
	public void logWith(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignInButton();
	}
	
	public void navigateToMenu(String menuName)
	{
		HomePage clientmenu = new HomePage(driver);
		clientmenu.searchmenu(menuName);
		clientmenu.clientClick();
	}

}




