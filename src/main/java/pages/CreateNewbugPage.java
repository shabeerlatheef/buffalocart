package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewbugPage {
	
WebDriver driver;
	
	public CreateNewbugPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='bug_title']")
	public WebElement bugTitle;
	
	
	@FindBy(xpath="//select[@id='check_related']")
	public WebElement bugrelatedto;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement save;
	
	
	
	

	public void enterbugtitle(String title) {
		bugTitle.sendKeys(title);
		
	}
	
	public void clickSave() {
		save.click();
		
	}
	
	
	public void selectRelatedto() 
	{
		Select dropdown = new Select(bugrelatedto);
		 dropdown.selectByValue("0");	
		 bugrelatedto.click();
	}

}
