package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BugsPage {
	
WebDriver driver;
	
	public BugsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[text()='New Bugs']")
	public WebElement newbugsTab;
	
	public void clickNewBug() throws InterruptedException
	{
		newbugsTab.click();
		Thread.sleep(5000);
	}
}
