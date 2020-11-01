package TestNGSessions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import UtilityMethods.TestUtils;

import static UtilityMethods.TestUtils.*;



public class LoginTestHubSpotTest {
	
	WebDriver driver;
	By SignUpLink=By.cssSelector(".private-link.uiLinkWithoutUnderline.uiLinkDark.m-left-1>i18n-string");
	By Email=By.id("username");
	By Password=By.id("password");
	By LoginButton=By.id("loginBtn");
	By CreateAccountLink=By.cssSelector("button.continue-new.text-center");
	
	@BeforeTest
	@Parameters({"url","browser"})
	public void setUp(String targetUrl,String browser) throws Exception
	{
		driver=launchBrowser(driver,browser);
		launchURLUsingGET(driver,targetUrl);
		//maximizeBrowser(driver);
		deleteAllCookies(driver);
		ImplicitlyWait(driver,20);
		PageLoadTimeOut(driver,20);
	}
	
	@Test(priority=1)
	public void signUpLinkTest()
	{
		Assert.assertEquals(false, true);
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitle() throws InterruptedException
	{
		
		Assert.assertEquals(false, true);
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		quitBrowser(driver);
	}


}
