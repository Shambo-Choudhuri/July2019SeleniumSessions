package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import UtilityMethods.TestUtils;

public class HandleAuthenticationPopUp {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		TestUtils.maximizeBrowser(driver);
		
		String Username="admin";
		
		String Password="admin";
		
		TestUtils.launchURLUsingGET(driver, "http://" +Username+ ":" +Password+ "@" + "the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(5000);
		
		
		
		
		

	}

}
