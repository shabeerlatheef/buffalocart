package test;

import org.testng.Assert;
import org.testng.annotations.Test;

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
		
		//Assert.assertEquals(client, clientname);
		
		ClientListPage client = new ClientListPage(driver);
		client.select100();
		client.clientList();
	}

}
