package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileManagerPage {
	
WebDriver driver;
	
	public FileManagerPage(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='New folder']")));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@title='New folder']")
	public WebElement newfolderCreate;
	
	@FindBy(xpath="//div[@title='New text file']")
	public WebElement newfileCreate;
	
	@FindBy(xpath="//input[@type='text' and @size='42']")
	public WebElement searchfield;
	
	
	
	public void createNewfolder(String foldername) 
	{
		newfolderCreate.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		  Action keydown = actionProvider.keyDown(Keys.SHIFT).sendKeys(foldername).build();
		  keydown.perform();
		
		
		
		System.out.println("hi");
		
	}
	
	public void createNewfile(String foldername, String filename)
	{
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("/div[@title='"+foldername+"']"));
		actions.doubleClick(elementLocator).perform();
		
		System.out.println();
		
		newfileCreate.click();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		  Action keydown = actionProvider.keyDown(Keys.SHIFT).sendKeys(filename).build();
		  System.out.println("hh");
		
	}
	
}
