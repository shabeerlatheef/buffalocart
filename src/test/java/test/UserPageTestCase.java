package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import pages.AllUserPage;
import pages.CreateUserPage;
import pages.HomePage;
import pages.UserProfilePage;

public class UserPageTestCase extends LoginPageTestCase {
	
	
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
