package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='user_name']")
	public WebElement loginUserName;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement loginPassword;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	public WebElement loginButton;
	
	
	
	public void enterUsername(String username)
	{
		loginUserName.sendKeys(username);
		System.out.println(username);
	}
	
	public void enterPassword(String password)
	{
		loginPassword.sendKeys(password);
		System.out.println(password);
	}
	
	public void clickSignInButton()
	{
		loginButton.click();
	}

}
