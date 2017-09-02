package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base_class {
	
	public Process process;
	public AppiumDriver driver;
	
		
	public void Start_Server() throws IOException, InterruptedException
	{
		//Start Server
				String Start_Server= "D:\\Appium\\node.exe   D:\\Appium\\node_modules\\appium\\bin\\appium.js";
				 process = Runtime.getRuntime().exec(Start_Server);
				
				if(process!= null)
				{
					System.out.println("Started the Appium Server");
				}
				else
				{
					System.out.println("NOT Started the Server");
				}
				
				Thread.sleep(12000);
				
				//**********************************************************
				
	}
	
	
	
	public void LaunchApp() throws InterruptedException, IOException
	{
		DesiredCapabilities capablities= new DesiredCapabilities();
		
		//device details
		capablities.setCapability("deviceName","GT-I9300I");
		capablities.setCapability("platformName","Android");
		capablities.setCapability("PlatformVersion","4.4.4");
		
		//app details
		capablities.setCapability("appPackage",Utility_Class.Reading_properties("Package_name"));
		capablities.setCapability("appActivity",Utility_Class.Reading_properties("Activity_name"));
		
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capablities);
		
		Thread.sleep(4000);		
		
		
	}
	
	public void Explicit_Wait(WebElement ele,long T1)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public String Capture_Screenshot(String TC_ID, String Order_Set) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Augbatch_files\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str));
		
		String Path= "D:\\Augbatch_files\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str;
		
		return Path;
		
	}
	
	
	public void Stop_Server() throws InterruptedException
	{
		
						
				if(process!=null)
				{
					process.destroy();
					Thread.sleep(4000);
					System.out.println("Stopped the Server");
					
				}
				
				
				
	}

}
