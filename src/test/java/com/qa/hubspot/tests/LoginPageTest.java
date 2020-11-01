package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("Epic-101:Design of Login Page")
@Story("Story-102:Design Basic Login Page with Sign Up,Title and Login Form...")
public class LoginPageTest extends BaseTest
{
	
	
	@Test(priority=1)
	@Description("This is Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitle()
	{
		Assert.assertEquals(loginPage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE, "The Login Page Title does not match");
	}
	
	@Test(priority=2,enabled=false)
	@Description("This is Sign Up Link Presence Test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkPresence()
	{
		Assert.assertTrue(loginPage.verifySignUpLink(), "Sign Up Link is not present");
	}
	
	@Test(priority=3,enabled=false)
	@Description("This is Login Test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() throws InterruptedException
	{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

}
