package SeleniumSessions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;
import static java.lang.System.*;

public class HandleBrowserWindowPopUps {
	
	static WebDriver driver;
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TestUtils.launchBrowser(driver, "CHROME");
		
		
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		
		List<WebElement> elements=driver.findElements(By.xpath("//a[contains(text(),'Good PopUp ')]"));
		Iterator<WebElement> itr1=elements.iterator();
		
		while(itr1.hasNext())
		{
			itr1.next().click();
			Thread.sleep(3000);
		}
		
		
		Set<String> handler=TestUtils.getWindowHandles(driver);
		
		String ParentWindowID=TestUtils.getWindowHandle(driver);
		
		Iterator<String> itr=handler.iterator();
		
		while(itr.hasNext())
		{
			String str=itr.next();
			
			if(str.equals(ParentWindowID))
			{
				out.println("This is Parent Window ID");
			}
			
			else
			{
				out.println("This is a Child Window ID");
				driver.switchTo().window(str);
				Thread.sleep(3000);
				out.println(TestUtils.getPageTitle(driver));
				TestUtils.closeBrowser(driver);
			}
		}
		
		driver.switchTo().window(ParentWindowID);
		
		Thread.sleep(3000);
		
		TestUtils.quitBrowser(driver);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
