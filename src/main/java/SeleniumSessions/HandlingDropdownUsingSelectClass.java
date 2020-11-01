package SeleniumSessions;

import static UtilityMethods.TestUtils.*;
import static java.lang.System.out;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class HandlingDropdownUsingSelectClass {
	
	//Page Objects
	
	static WebDriver driver;
	static By DayDropdown=By.xpath("//select[@id='day']");
	static By DayDropdownMenu=By.xpath("//select[@id='day']//option");
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=launchBrowser(driver,"CHROME");
		
		launchURLUsingGET(driver, "https://www.facebook.com");
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		maximizeBrowser(driver);
		
		WebElement dayDropdown=driver.findElement(DayDropdown);
		
		clickOn(driver, DayDropdown);
		Thread.sleep(3000);
		
		/*
		 * List<WebElement> elements=getMultipleElements(driver, DayDropdown);
		 * 
		 * Iterator<WebElement> itr=elements.iterator();
		 * 
		 * while(itr.hasNext()) { out.println(itr.next().getText()); }
		 * 
		 * 
		 * selectItemFromDropdownUsingSelectClass(dayDropdown, "25");
		 * Thread.sleep(3000);
		 */
		
		selectItemFromDropdownWithoutUsingSelectClass(driver,"20",DayDropdownMenu);
		Thread.sleep(3000);
		
		clickOn(driver, DayDropdown);
		Thread.sleep(3000);
		
		quitBrowser(driver);
		
		
		
		
		
		
		

	}

}
