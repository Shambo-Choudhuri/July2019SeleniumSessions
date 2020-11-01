package SeleniumSessions;

import static java.lang.System.out;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class AlertHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		TestUtils.launchURLUsingNavigate(driver, "https://mail.rediff.com/cgi-bin/login.cgi");
		
		Thread.sleep(5000);
		
		String getCurrentURL=TestUtils.getCurrentUrl(driver);
		
		out.println(getCurrentURL);
		
		out.println(TestUtils.getPageTitle(driver));
		
		if(TestUtils.getPageTitle(driver).equals("Rediffmail"))
		{
			out.println("Title is Correct");
		}
		else
		{
			out.println("Title is InCorrect");
		}
		
		/*By locator=By.xpath("//input[@title='Sign in']");
		
		TestUtils.clickOn(driver, locator);*/
		
		//OR
		
		/*By locator=By.xpath("//input[@title='Sign in']");
		
		TestUtils.getElement(driver, locator).click();*/
		
		
		Thread.sleep(5000);
		
		String AlertText=TestUtils.acceptAlert(driver);
		
		out.println(AlertText);
		
		if(AlertText.equals("Please enter a valid user name"))
		{
			out.println("Alert Text is correct");
		}
		else
		{
			out.println("Alert Text is incorrect");
		}
		
		TestUtils.quitBrowser(driver);
		
		

	}

}
