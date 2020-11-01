package UtilityMethods;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptUtility {
	
	/*[JavascriptExecutor interface enables the driver to access the Javascript code 
	for basic Operations which the Selenium ClientLibrary does not provide any methods/APIs]*/
	
	public static void flash(WebElement element,WebDriver driver)
	{
		//WebDriver d=new ChromeDriver();
		
		//JavascriptExecutor js=new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		String bgColor=element.getCssValue("backgroundColor");
		
		for(int i=0;i<20;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgColor,element,driver);
			
		}
		
	}
	
	private static void changeColor(String color,WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException ie)
		{
			
		}
	}
	
	public static void navigateToWebsite(WebDriver driver,String url)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location='"+url+"'");
	}
	
	public static void getPageTitle(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		System.out.println(title);
	}
	
	public static void enterText(WebDriver driver,String ID,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+ID+"').value='"+value+"'");
	}
	
	public static void click(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public static void drawBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	
	public static void generateAlert(WebDriver driver,String message)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void refreshBrowser(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getPageInnerText(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String PageText=js.executeScript("return document.documentElement.innerText;").toString();
		return PageText;
	}
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
		
	
	
	
	
	
	
	
	
		
		
	
	
	
		
		
		
		
		
		
		
		
		
		
	}


