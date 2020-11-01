package SeleniumSessions;

import org.openqa.selenium.WebDriver;

import UtilityMethods.TestUtils;

import static UtilityMethods.TestUtils.*;

public class TakeScreenshotDemo {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=launchBrowser(driver, "FIREFOX");
		
		launchURLUsingGET(driver, "https://www.cricinfo.com");
		Thread.sleep(5000);
		
		TakeScreenshotOfEntirePage(driver,"CricinfoHomePage");
		closeBrowser(driver);
		
		
		
		
		
		
		

	}

}
