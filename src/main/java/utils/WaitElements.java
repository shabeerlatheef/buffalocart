package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElements {
	public WebDriver driver;
	public WaitElements(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForElement(int t, String path)
	{
		WebDriverWait wait=new WebDriverWait(driver, t);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path))));
	}
	public void WaitForAlert(int t)
	{
		WebDriverWait wait = new WebDriverWait(driver, t);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void fluentWait(int t, String path)
	{
		Wait wait = new FluentWait(driver).pollingEvery(Duration.ofSeconds(t)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path))));
	}

}
