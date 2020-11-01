package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.utils.ElementUtils;
import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage
{
	public WebDriver driver;
	public Properties prop;
	public ElementUtils elementUtils;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	/*During Parallel Execution any one Thread will be eligible to use getDriver() method 
	 since it is synchronized and Thread-Safe*/
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
		 
	}
	
	
	
	
	
	public WebDriver init_driver(Properties prop) throws Exception
	{
		String browserName=null;
		
		if(System.getProperty("browser")==null)
		{
			browserName=prop.getProperty("browser"); 
		}
		
		else
		{
			browserName=System.getProperty("browser");
		}
		
		System.out.println("Tests Running on" +browserName + "browser");
		  
		  
		  
		  optionsManager=new OptionsManager(prop);
		 
		
		
		
		switch(browserName)
		{
			case "chrome":
					WebDriverManager.chromedriver().setup();
					tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));//driver=new ChromeDriver();
					break;
					
			case "firefox":
				    WebDriverManager.firefoxdriver().setup();
				    tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));//driver=new FirefoxDriver();
				    break;
				    
		    default:
		    	   throw new Exception("NoSuchBrowserException");
				    
		}
		
		WebDriver driver=getDriver();
		
		elementUtils=new ElementUtils(driver);
		
		elementUtils.maximizeBrowser(driver);
		elementUtils.deleteAllCookies(driver);
		elementUtils.ImplicitlyWait(driver, 20);
		elementUtils.PageLoadTimeOut(driver, 20);
		
		elementUtils.launchURLUsingGET(driver, prop.getProperty("url"));
		
		
		return driver;//returning a ThreadLocal WebDriver object and not a normal WebDriver object
	}
	
	
	public Properties init_prop()
	{
		prop=new Properties();
		
		String path=null;
		String env=null;
		
		try 
		{
			env=System.getProperty("env");
			
			if(env==null)
			{
				System.out.println("Please Enter a Test Environment");
			}
			else
			{
				switch(env)
				{
					
							
					case "QA":
						// "." reflects the current project path...no need to mention the full project path
							path=".\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
							break;
					case "UAT":
						// "." reflects the current project path...no need to mention the full project path
							path=".\\src\\main\\java\\com\\qa\\hubspot\\config\\uat.config.properties";
							break;
					
					default:
							System.out.println("Please Enter a valid Test Environment");
							break;
							
				}
			}
			
			
			FileInputStream FIS = new FileInputStream(path);
			
			try 
			{
				prop.load(FIS);
			} 
			catch (IOException e) 
			{
				
				e.getMessage();
			}

		} 
		catch (FileNotFoundException e) 
		{
			
			e.getMessage();
		}
		
		return prop;
		
				
		
		
	}
	
	//Take Screenshots
	
	public String getScreenshot() throws IOException
	{
		
		//TakesScreenshot driver=new ChromeDriver();
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		//System.getProperty("user.dir")-----Get the Root Directory of the Current Maven Project
		
		//  ".//"----------Get the Root Directory of the Current Maven Project
		
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	
	
	
}
