package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllUserPage {
	
WebDriver driver;
	
	public AllUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[text()='Search all columns:']//input[@type='search']")
	public WebElement searchuser;
	
	@FindBy(xpath="//a[@title='Click to Delete ']")
	public WebElement delete;
	
	
	@FindBy(xpath="//button[text()='Proceed Anyway!']")
	public WebElement deleteconfirm;
	
	@FindBy(xpath="//div[text()='User Delete Successfully!']")
	public WebElement deletesuccess;
	
	
	

	public void searchname(String searchname) throws InterruptedException {
		Thread.sleep(5000);
		searchuser.sendKeys(searchname);
		Thread.sleep(5000);
	}



	public void deletebutton() throws InterruptedException {
		delete.click();
		Thread.sleep(5000);
		deleteconfirm.click();
		Thread.sleep(5000);
		deletesuccess.isDisplayed();
		
		System.out.println("user Deleted " +deletesuccess.isDisplayed());
		
	}
	

}
