package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.UploadImage;

public class CreateUserPage {
	
	WebDriver driver;
	
	public CreateUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='fullname']")
	public WebElement fullName;
	
	@FindBy(xpath="//input[@name='employment_id']")
	public WebElement employmentId;
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passWord;
	
	@FindBy(xpath="//input[@name='confirm_password']")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement email;
	
	
	
	@FindBy(xpath="//select[@id='user_type']")
	public WebElement select;
	 
	@FindBy(xpath="//input[@id='myImg']")
	public WebElement uploadimage;
	
	//WebElement chooseFile = driver.findElement(By.id("custom-input"));
	//chooseFile.sendKeys("E:\java program\image\image.JPG");
	
	@FindBy(xpath="//span[text()='English (United States)']")
	public WebElement locale;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__option--highlighted']")
	public WebElement selectlan;
	
	
		
	@FindBy(xpath="//span[@title='Select Designation']")
	public WebElement designation;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	public WebElement input;
	
	
	@FindBy(xpath = "//button[text()='Create User']")
	public WebElement submit;
	
	
	
	
	
	
	
	
	
	public void enterFullName(String fullname)
	{
		fullName.sendKeys(fullname);
	}





	public void enterEmploymentId(String emid) {
		employmentId.sendKeys(emid);
		
	}





	public void enterUserName(String username)
	{
		userName.sendKeys(username);
		
	}
	
	public void enterPassword(String password)
	{
		passWord.sendKeys(password);
		
	}





	public void enterConfirmPassword(String confirmpw)
	{
		confirmPassword.sendKeys(confirmpw);
		
	}





	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
		
	}
	
	public void selectAdmin(String value) 
	{
		Select dropdown = new Select(select);
		 dropdown.selectByVisibleText(value);	
		 select.click();
	}
	
	public void uploadImg(String loc)
	{
		
		//Actions ob = new Actions(driver);
		//ob.moveToElement(uploadimage).click().build().perform();
		//uploadimage.sendKeys(link);
		
		UploadImage.uploadImage(driver, uploadimage, loc);
		
		}
	
	
	
	
	
	
	
	
	
	public void selectLocale(String lan) throws InterruptedException
	{
		locale.click();
		Thread.sleep(5000);
		input.sendKeys(lan);
		Thread.sleep(5000);
		selectlan.click();
		
	}





	public void selectDesignation(String position)
	{
		
		designation.click();
		input.sendKeys(position);
		selectlan.click();
				
	
	}





	public void submitCreateUserbutton() 
	{
	submit.click();	
		
	}
	

}
