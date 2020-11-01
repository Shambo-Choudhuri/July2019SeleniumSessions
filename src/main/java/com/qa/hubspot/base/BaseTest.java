package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ElementUtils;

public class BaseTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	
	
	
	@BeforeTest
	public void setUp() throws Exception
	{
		
		  basePage=new BasePage();
		  
		  prop=basePage.init_prop();
		  
		  driver=basePage.init_driver(prop);
		 
		  loginPage=new LoginPage(driver);
		  
		  
	
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
