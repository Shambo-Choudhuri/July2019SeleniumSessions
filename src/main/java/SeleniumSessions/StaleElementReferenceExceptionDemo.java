package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class StaleElementReferenceExceptionDemo {
	
	public static WebDriver driver;
	static By Email=By.name("username");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver,"CHROME");
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		TestUtils.launchURLUsingGET(driver, "http://www.crmpro.com/");
		
		TestUtils.maximizeBrowser(driver);
		
		WebElement element=driver.findElement(Email);//ID1=b5dad6cb-9068-433f-a752-55bcf9985fc7
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		element=driver.findElement(Email);//ID2=b4afb09f-1cbe-4b37-a9a1-0ba14bacf61f
		
		element.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
