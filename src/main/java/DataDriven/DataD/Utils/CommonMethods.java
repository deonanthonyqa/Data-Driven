package DataDriven.DataD.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import DataDriven.DataD.testBase.Base;


public class CommonMethods {
	
	static String timeStamp;
	static String screenShotName;

	public void scrollToView(WebElement ele) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)Base.getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(3000);
	}

	 
	
	public void click(WebElement ele){
		ele.click();
	}
	
	public void sendKeys(WebElement ele, String value)
	{
		ele.sendKeys(value);
	}
	
	public String getTitleofPage() {
		return Base.getDriver().getTitle();
	}

	public String takeScreenshot(String name, WebDriver driver) throws IOException {
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		screenShotName=name+"-"+timeStamp;
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ScreenShots/"+screenShotName+".png";
		File dest = new File(destination);
		FileHandler.copy(src,dest);
		
	
	return destination;
	}
}
