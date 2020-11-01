package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class HandlingStaleElementReferenceException {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		driver.manage().window().maximize();
		
		TestUtils.launchURLUsingGET(driver, "https://www.google.com/");
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		By locator=By.linkText("Gmail");
		
		WebElement element=driver.findElement(locator);
		
		element.click();
		
		TestUtils.backwardBrowser(driver);
		
		element=driver.findElement(locator);
		
		element.click();
		
		
		
		
		

	}

}
