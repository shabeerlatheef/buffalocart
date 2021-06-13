package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserProfilePage;
import pages.AllUserPage;
import pages.CreateUserPage;

public class LoginTestCase {
	
	WebDriver driver;
	
	@BeforeSuite
	public void browsersetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@BeforeTest
	public void appsetup()
	{
	driver.get("http://buffalocart.com/demo/erp/login");
	driver.manage().window().maximize();
	}
	
	@AfterSuite
    public void quit()
    {
       driver.quit();
        System.out.println("quit the browser");
    }
	
	@BeforeTest
	public void loginTest() throws InterruptedException, IOException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("admin");
		loginPage.enterPassword("123456");
		loginPage.clickSignInButton();
	}
		
		@Test
		public void userTest() throws InterruptedException, IOException
		{
		HomePage homepage = new HomePage(driver);
		homepage.userClick();
	
		UserProfilePage newUsertab = new UserProfilePage(driver);
		newUsertab.clickNewUser();
		
		CreateUserPage createUser = new CreateUserPage(driver);
		createUser.enterFullName("shabeer");
		createUser.enterEmploymentId("ab1012");
		createUser.enterUserName("shabeerlatheef");
		createUser.enterPassword("test123");
		createUser.enterConfirmPassword("test123");
		createUser.enterEmail("shabeerlatheef@gmail.com");
		createUser.selectLocale("Malayalam (India)");
		createUser.selectAdmin("Admin");
		createUser.uploadImage("E:\\java program\\image\\image.JPG");
		createUser.selectDesignation("Manager");
		createUser.submitCreateUserbutton();
		
		
		//UserProfilePage allUsertab = new UserProfilePage(driver);
		//allUsertab.searchuser("shabeer");
		
		
		TakesScreenshot tk = ((TakesScreenshot)driver);
        File file = tk.getScreenshotAs(OutputType.FILE);
        File destFile = new File("login.png");
        FileUtils.copyFile(file,destFile);
	}
		
		@Test
		public void deleteuser() throws InterruptedException
		{
			HomePage homepage = new HomePage(driver);
			homepage.userClick();
					
			UserProfilePage select100user = new UserProfilePage(driver);
			select100user.select100();
			
			AllUserPage alluser = new AllUserPage(driver);
			alluser.searchname("shabeer");
			alluser.deletebutton();
			
			
		}
	
	

}
