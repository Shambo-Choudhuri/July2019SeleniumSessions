package SeleniumSessions;

import static java.lang.System.out;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityMethods.TestUtils;

public class LoginPage {
	
	static WebDriver driver;
	static By Email=By.id("username");
	static By Password=By.id("password");
	static By LoginButton=By.id("loginBtn");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver,"CHROME");
		
		TestUtils.maximizeBrowser(driver);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		TestUtils.launchURLUsingGET(driver, "https://app.hubspot.com/login");
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(Email));
		
		wait.until(ExpectedConditions.titleContains("HubSpot Login"));
		
		System.out.println(driver.getTitle());
		
		//TestUtils.sendText(driver, Password, "test@123"); 
		 
		
		
	
		  //TestUtils.clickOn(driver, LoginButton); Thread.sleep(5000);
		 
		
		//TestUtils.quitBrowser(driver);
		
		
		
		
		
		
		
		
		
		
		

	}

}
