package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static UtilityMethods.TestUtils.*;
import static java.lang.System.out;

public class GetAttributeOperation {
	
	static WebDriver driver;
	static By Username=By.xpath("//input[@name='username']");
	static By Password=By.xpath("//input[@name='password']");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=launchBrowser(driver,"CHROME");
		
		launchURLUsingGET(driver, "https://www.crmpro.com/");
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		maximizeBrowser(driver);
		
		sendText(driver, Username, "test@gmail.com");
		Thread.sleep(3000);
		
		out.println(getAttributeValueOfElement(driver, Username, "value"));
		out.println(getAttributeValueOfElement(driver, Password, "value"));
		
		
		sendText(driver, Password, "test@123");
		Thread.sleep(3000);
		
		
		
		quitBrowser(driver);
		
		
		
		

	}

}
