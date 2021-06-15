package test;


import org.testng.annotations.Test;

import pages.BugsPage;
import pages.CreateNewbugPage;
import pages.HomePage;

public class BugPageTestCase extends LoginPageTestCase{
	
	@Test
	public void createNewBug() throws InterruptedException
	{
		HomePage menuitems = new HomePage(driver);
		menuitems.searchmenu("Bugs");
		menuitems.bugsClick();
		
		BugsPage newbug = new BugsPage(driver);
		Thread.sleep(5000);
		newbug.clickNewBug();
		
		CreateNewbugPage bug = new CreateNewbugPage(driver);
		bug.enterbugtitle("test");
		bug.selectRelatedto();
		bug.clickSave();
	}
}
