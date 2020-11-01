package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

@Listeners(ExtentReportListener.class)
public class HomePageTest extends BaseTest {
	
	
	public HomePage homePage;
	
	
	@BeforeClass
	public void homeSetup() throws InterruptedException
	{
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test
	public void verifyHomePageTitle()
	{
		Assert.assertEquals(homePage.verifyHomePageTitle(),Constants.HOME_PAGE_TITLE );
		
	}
	
	@Test
	public void verifyHeaderText()
	{
		Assert.assertEquals(homePage.verifyHeaderText(),Constants.HOME_PAGE_HEADER_TEXT);
	}
	
	

	
	

}
