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


public class SignUpTest {
	
	WebDriver driver;
	By SignUpLink=By.cssSelector(".private-link.uiLinkWithoutUnderline.uiLinkDark.m-left-1>i18n-string");
	
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
		System.out.println("Sign Up Test");
	}
	
	@Test(priority=2)
	public void validateSignUpFunctionality()
	{
		System.out.println("Login Test");

	}
	
	@AfterTest
	public void tearDown()
	{
		quitBrowser(driver);
	}

}
