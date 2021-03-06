package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Screenshots;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='User']")
	public WebElement UserTab;
	
	@FindBy(xpath="//input[@id='s-menu']")
	public WebElement searchmenu;
	
	@FindBy(xpath="//a[@title='Bugs']")
	public WebElement bugsTab;
	
	
	@FindBy(xpath="//a[@title='Client']")
	public WebElement clientTab;
	
	@FindBy(xpath="//a[@title='File Manager']")
	public WebElement fileManagerTab;
	
	
	public void userClick()
	{
		UserTab.click();
		
	}
	
	public void bugsClick()
	{
		bugsTab.click();
		
	}


	public void searchmenu(String items) {
		searchmenu.sendKeys(items);
		
		
		Screenshots.takeScreenshots(driver, "search_menu_" +items);
		
	}
	
	public void clientClick()
	{
		
		clientTab.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Client']")));
		
	}

	public void fileManagerClick()
	{
		fileManagerTab.click();
		
		
	}
	
	
	
	

}
