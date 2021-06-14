package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	/*
	public static void takeScreenshotFromMyApp(WebDriver driver, String name)

	{
		try {
	TakesScreenshot tk = ((TakesScreenshot)driver);
    File file = tk.getScreenshotAs(OutputType.FILE);
    File destFile = new File(name + ".png");
    FileUtils.copyFile(file,destFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	*/
	
	public static void takeScreenShotInApp(WebDriver driver, String name) {
        try {
            TakesScreenshot tk = ((TakesScreenshot)driver);
            File file = tk.getScreenshotAs(OutputType.FILE);
            File destFile  = new File(name+".png");
            FileUtils.copyFile(file,destFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
	
}