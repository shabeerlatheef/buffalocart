package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientListPage {
	
WebDriver driver;
	
	public ClientListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Next']")
	public WebElement nextbutton;
	
	
	public void clientList()
	{
		List<WebElement> clients = driver.findElements(By.xpath("//a[contains(text(),'Obsqura')]"));
		
		for (WebElement client:clients)
		{
			System.out.println(client.getText());
			
			if(client.getText().contains("Obsqura"))
			{
				//client.click();
				
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
				client.sendKeys(selectLinkOpeninNewTab);
				
				
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				WebElement clientname = driver.findElement(By.xpath("//div[@class='col-md-6']//div[@class='col-md-6']"));
				System.out.println(clientname.getText());
				driver.navigate().back();
				
			}
			
		
	}
	
	}
}
	
	

