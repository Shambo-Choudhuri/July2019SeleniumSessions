package SeleniumSessions;

import static UtilityMethods.TestUtils.launchBrowser;
import static UtilityMethods.TestUtils.launchURLUsingGET;
import static java.lang.System.out;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class WaitsDemo {
	
	public static WebDriver driver;
	
	static By EmailAddress=By.xpath("//input[@id='username']");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=launchBrowser(driver, "CHROME");
		
		//TestUtils.PageLoadTimeOut(driver, 10);
		
		TestUtils.deleteAllCookies(driver);
		
		//TestUtils.ImplicitlyWait(driver, 20);
		
		launchURLUsingGET(driver, "https://app.hubspot.com/login");
		
		//System.out.println(TestUtils.getCurrentUrl(driver));
		
		//TestUtils.maximizeBrowser(driver);
		
		//out.println(TestUtils.getPageTitle(driver));
		
		
		
		//TestUtils.ExplicitlyWaitForPresenceofElement(driver, EmailAddress, 20);
		
	//WebElement EmailID=TestUtils.getElement(driver, EmailAddress);
		
		
		
		//TestUtils.ActionsClassSendKeysOperation(driver, EmailID, "test@gmail.com");
		
		TestUtils.customWait(driver,EmailAddress,2).sendKeys("test@gmail.com");
		
		TestUtils.closeBrowser(driver);
		
		
		
		
		
		
		
		

	}

}
