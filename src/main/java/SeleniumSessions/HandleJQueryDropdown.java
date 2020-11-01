package SeleniumSessions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class HandleJQueryDropdown {
	
	public static WebDriver driver;
	
	static By Dropdown=By.xpath("//div[@id='trickyid']//preceding-sibling::div[1]//descendant::tr[2]//td[3]//descendant::select//following-sibling::div//child::span");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		TestUtils.maximizeBrowser(driver);
		
		TestUtils.launchURLUsingGET(driver, "https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		TestUtils.PageLoadTimeOut(driver, 30);
		
		TestUtils.deleteAllCookies(driver);
		
		//TestUtils.ExplicityWaitForVisibilityOfElement(driver, Dropdown, 20);
		
		TestUtils.clickOn(driver, Dropdown);
		
		By dropdownOptions=By.xpath("//div[@id='trickyid']//preceding-sibling::div[1]//descendant::tr[2]//td[3]//descendant::select//following-sibling::div//child::ul//li//descendant::label[@class='checkbox']");
		
		//handleJQueryDropdown(driver,dropdownOptions,"Java","C#","Python");
		
		
		//handleJQueryDropdown(driver,dropdownOptions,"Oracle");
		
		//handleJQueryDropdown(driver,dropdownOptions,"Angular","Java","C#","Python");
		
		handleJQueryDropdown(driver,dropdownOptions,"ALL");
		
		
		}	
	
	public  static void handleJQueryDropdown(WebDriver driver,By locator,String... value)
	{
		List<WebElement> elements=driver.findElements(locator);
		
		Iterator<WebElement> itr=elements.iterator();
		
		int c=0;

		if(value[0].equalsIgnoreCase("ALL"))
		{
			while(itr.hasNext())
			{
				itr.next().click();
			}
		}
		else
		{
			while(itr.hasNext())
			{
				WebElement element=itr.next();
				
				for(int i=1;i<value.length;i++)
				{
					if(element.getText().equalsIgnoreCase(value[i]))
					{
						element.click();
						c++;
						break;
					}
				}
				
			
				if(c==value.length)
				{
					break;
				}
			
			}
		}
		
	}


	}
	
	