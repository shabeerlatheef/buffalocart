package test;


import java.io.IOException;


import org.testng.annotations.BeforeTest;


import pages.LoginPage;


public class LoginPageTestCase extends AppSetup {
	
	@BeforeTest
	public void loginTest() throws InterruptedException, IOException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("admin");
		loginPage.enterPassword("123456");
		loginPage.clickSignInButton();
	}
			

}
