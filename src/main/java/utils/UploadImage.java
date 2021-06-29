package utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UploadImage {
	
	
	public static void uploadImage(WebDriver driver, WebElement uploadimage, String loc) 
	{
    Actions obj = new Actions(driver);
    obj.moveToElement(uploadimage).click().build().perform();
	try 
	{
		Robot robot =new Robot();
		robot.setAutoDelay(2000);
		StringSelection stringSelection = new StringSelection(loc);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    

}
