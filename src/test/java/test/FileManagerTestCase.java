package test;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.FileManagerPage;
import pages.HomePage;

public class FileManagerTestCase extends AppSetup {
	
	
	@Test
	public void Filemanger() 
	{
		
		HomePage searchFileManager = new HomePage(driver);
		searchFileManager.searchmenu("File Manager");
		searchFileManager.fileManagerClick();
		
		FileManagerPage file = new FileManagerPage(driver);
		file.createNewfolder("shabeer");
		file.createNewfile("SHABEER", "txt");
		
	}
	

}
