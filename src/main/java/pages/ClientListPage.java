package pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClientListPage {
	
WebDriver driver;
	
	public ClientListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Next']")
	public WebElement nextbutton;
	
	@FindBy(xpath="//select[@name='DataTables_length']")
	public WebElement select;
	
	@FindBy(xpath="//a[text()='Client List']")
	public WebElement clientList;
	
		
	//(//a[text()='Next']//parent::li)/preceding-sibling::li[1]
	
	public void select100() 
	{
		Select dropdown = new Select(select);
		 dropdown.selectByValue("100");	
		 select.click();
	}
	
	
	public void clientList()
	{
		
		String parentWindow = driver.getWindowHandle();
		//System.out.println(parentWindow);
		List<WebElement> clients = driver.findElements(By.xpath("//a[contains(text(),'Obsqura')]"));
		for (WebElement client:clients)
		{
			String parentclient = client.getText();
			System.out.println("parent window client name: " +parentclient);
			
			
			
			if(client.getText().contains("Obsqura"))
			{
				//client.click();
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
				client.sendKeys(selectLinkOpeninNewTab);
				Set<String> newBrowser = driver.getWindowHandles();
				for(String i:newBrowser)
				{
					//System.out.println(i);
				    if(!(i.equals(parentWindow)))
				    {
				    	driver.switchTo().window(i);
				    	//System.out.println(driver.getCurrentUrl());
				        WebElement clientname = driver.findElement(By.xpath("//div[@class='col-md-6']//div[@class='col-md-6']"));
						String childclient = clientname.getText();
				        System.out.println("Client name: "+childclient);
						driver.close();
						//  System.out.println("Close child window browser");
						
						
				       }
					}			
				}
			driver.switchTo().window(parentWindow);
		}
	}
}
	
	


