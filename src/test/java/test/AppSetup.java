package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class AppSetup extends BaseSetup {
	
	
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

}
