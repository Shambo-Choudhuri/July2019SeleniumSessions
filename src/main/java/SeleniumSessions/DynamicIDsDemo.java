package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class DynamicIDsDemo {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver,"CHROME");
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		TestUtils.launchURLUsingGET(driver, "https://app.hubspot.com/login");
		
		TestUtils.maximizeBrowser(driver);
		
		//WebDriver driver=new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//JavascriptExecutor js=new ChromeDriver();
		
		js.executeScript("document.querySelector(\"*[type='email']\").getAttribute(\"id\")");
		
		//By Email=By.id(usernameID);
		
		//WebElement element=TestUtils.getElement(driver, Email);
		
		//TestUtils.ActionsClassSendKeysOperation(driver, element, "shambo.choudhuri9@gmail.com");
		
		
		
		
		

	}

}
