package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetup\\chromedriver.exe\\");
		
		WebDriver driver=new ChromeDriver();
		
		//driver.navigate().to("https://www.amazon.com");
		
		driver.get("https://www.google.com");
		
		//String title=driver.getTitle();
		
		//System.out.println(title);
		
		WebElement element=driver.findElement(By.xpath("//input[@type='text']"));
		
		
		flash(driver,element);
		
		Thread.sleep(2000);
	
		driver.close();
		
	//	driver.get("https://www.gmail.com");
		
		

	}
	
	public  static void flash(WebDriver driver,WebElement element)
	{
		//WebDriver driver=new ChromeDriver();
		
		//JavascriptExecutor js=new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		String bgColor=element.getCssValue("backgroundColor");
		
		for(int i=0;i<1;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgColor,element,driver);
			
		}
		
	}
	
	private  static void changeColor(String color,WebElement element,WebDriver driver)
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
	

	
	

}
