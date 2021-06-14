package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		
		Screenshots.takeScreenShotInApp(driver, "search_Menu_" +items);
		
	}
	
	
	
	
	

}
