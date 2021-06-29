package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ExcelUtils;

public class AppSetup extends BaseSetup {
	
	
	@BeforeTest
	public void appsetup()
	{
	driver.get("https://erp.buffalocart.com/login");
	driver.manage().window().maximize();
	}
	
}
	
	
