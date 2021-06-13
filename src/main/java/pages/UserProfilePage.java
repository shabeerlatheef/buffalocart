package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserProfilePage {
	WebDriver driver;
	
	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='New User']")
	public WebElement newUserTab;
	
	@FindBy(xpath="//a[text()='All Users']")
	public WebElement allUserTab;
	
	@FindBy(xpath="(//input[@type='search'])[2]")
	public WebElement search;
	
	
	@FindBy(xpath="//select[@name='DataTables_length']")
	public WebElement select;
	
	@FindBy(xpath="//a[text()='All Users']")
	public WebElement alluser;
	
	
	
	
	
	public void select100() 
	{
		Select dropdown = new Select(select);
		 dropdown.selectByValue("100");	
		 select.click();
	}
	
	public void clickNewUser()
	{
		newUserTab.click();
	}
	
	public void searchuser(String name)
	{
		search.sendKeys(name);
	}

}
