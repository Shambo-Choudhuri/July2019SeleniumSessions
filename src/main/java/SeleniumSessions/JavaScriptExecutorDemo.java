package SeleniumSessions;

import static java.lang.System.out;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.JavaScriptUtility;
import UtilityMethods.TestUtils;

public class JavaScriptExecutorDemo {
	
	static WebDriver driver;
	static By Email=By.id("username");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver,"CHROME");
		
		TestUtils.launchURLUsingGET(driver, "https://app.hubspot.com/login");
		
		TestUtils.maximizeBrowser(driver);
		
		TestUtils.ExplicitlyWaitForPresenceofElement(driver, Email, 40);
		
		out.println(TestUtils.getPageTitle(driver));
		
		WebElement EmailID=TestUtils.getElement(driver, Email);
		
		
		JavaScriptUtility.click(driver, EmailID);
		
		Thread.sleep(2000);
		
		JavaScriptUtility.enterText(driver, "username", "test@gmail.com");
		
		Thread.sleep(2000);
		
		WebElement SignUpLink=driver.findElement(By.linkText("Sign up"));
		
		JavaScriptUtility.drawBorder(SignUpLink, driver);
		
		Thread.sleep(2000);

		JavaScriptUtility.flash(SignUpLink, driver);
		
		
		
		
		
		
		
		
		

	}

}
