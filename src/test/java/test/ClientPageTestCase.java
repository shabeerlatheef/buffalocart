package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ClientListPage;
import pages.HomePage;
import pages.UserProfilePage;

public class ClientPageTestCase extends AppSetup{
	
	@Test
	public void clientsearch()
	{
		logWith("admin", "123456");
		navigateToMenu("Client");
		HomePage clientmenu = new HomePage(driver);
		
		clientmenu.clientClick();
		SoftAssert softAssertion= new SoftAssert();
		String expectedTitle = "https://erp.buffalocart.com/admin/client/manage_client";
        String originalTitle = driver.getCurrentUrl();
        Assert.assertEquals(originalTitle, expectedTitle);
        
        softAssertion.assertEquals(originalTitle, expectedTitle);
		
		ClientListPage client = new ClientListPage(driver);
		client.select100();
		client.clientList();
	}

}
