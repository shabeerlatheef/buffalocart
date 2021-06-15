package test;

import org.testng.annotations.Test;

import pages.ClientListPage;
import pages.HomePage;

public class ClientPageTestCase extends LoginPageTestCase{
	
	@Test
	public void clientsearch()
	{
		HomePage clientmenu = new HomePage(driver);
		clientmenu.searchmenu("Client");
		clientmenu.clientClick();
		
		ClientListPage client = new ClientListPage(driver);
		client.clientList();
	}

}