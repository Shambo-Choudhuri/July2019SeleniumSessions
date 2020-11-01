package TestNGSessions;

import static UtilityMethods.TestUtils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UtilityMethods.TestUtils;

public class AssertionsDemo {
	
	WebDriver driver;
	By SignUpLink=By.cssSelector(".private-link.uiLinkWithoutUnderline.uiLinkDark.m-left-1>i18n-string");
	By Email=By.id("username");
	By Password=By.id("password");
	By LoginButton=By.id("loginBtn");
	final SoftAssert softAssert=new SoftAssert();
	
	@BeforeMethod
	public void setUp()
	{
		driver=launchBrowser(driver,"CHROME");
		launchURLUsingGET(driver,"https://app.hubspot.com/login");
		maximizeBrowser(driver);
		deleteAllCookies(driver);
		ImplicitlyWait(driver,20);
		PageLoadTimeOut(driver,30);
		SoftAssert softAssert=new SoftAssert();
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle() throws InterruptedException
	{
		TestUtils.ExplicitWaitForPageTitle(driver, "HubSpot Login", 20);
		
		//Assert.assertEquals(getPageTitle(driver), "HubSpot Login", "Login Page Title is not verified");
		
		//Assert.assertEquals(getPageTitle(driver), "HubSpot Login");
		
		System.out.println("Soft Assertion1");
		
		//SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(TestUtils.getCurrentUrl(driver), "https://app.hubspot.com/login123");
		
		System.out.println("Soft Assertion2");
		
		softAssert.assertAll();
		
		
	} 
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		
		WebElement Username=getElement(driver, Email);
		WebElement Pwd=getElement(driver, Password);
		WebElement Login=getElement(driver, LoginButton);
		
		ActionsClassSendKeysOperation(driver, Username, "shambo.choudhuri9@gmail.com");
		Thread.sleep(2000);
		ActionsClassSendKeysOperation(driver, Pwd,"pHc#m8m6");
		Thread.sleep(2000);
		ActionsClassClickOperation(driver, Login);
		
		Thread.sleep(5000);
		
		launchURLUsingNavigate(driver,"https://app.hubspot.com/dashboard-library/8048101");
		
		//Assert.assertEquals(getPageTitle(driver), "Dashboard Library", "Home Page Title is not verified");
		
		TestUtils.ExplicitWaitForPageTitle(driver, "Dashboard Library", 20);
		
		//SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(TestUtils.getPageTitle(driver), "Dashboard Library123");
		
		System.out.println("Soft Assertion1");
		
		softAssert.assertAll();
		
		
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitBrowser(driver);
	}

	
	

}
