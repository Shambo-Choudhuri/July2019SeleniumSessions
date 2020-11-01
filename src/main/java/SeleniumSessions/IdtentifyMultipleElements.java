package SeleniumSessions;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;
import static java.lang.System.*;

public class IdtentifyMultipleElements {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		driver.manage().window().maximize();
		
		TestUtils.launchURLUsingGET(driver, "https://www.google.com/");
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		By locator=By.tagName("a");
		
		List<WebElement> ListOfLinks=driver.findElements(locator);
		
		out.println("Total Number of Links " +ListOfLinks.size());
		
		Iterator<WebElement> itr=ListOfLinks.iterator();
		
		int c=0;
		
		while(itr.hasNext())
		{
			String str=itr.next().getText();
			
			if(str.equals(""))
			{
				continue;
			}
			else
			{
				c++;
				out.println(str);
				
			}
		}
		
		out.println("Number of Links with Visible text " +c);
		
		TestUtils.quitBrowser(driver);

	}

}
