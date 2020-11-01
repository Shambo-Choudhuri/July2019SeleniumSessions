package SeleniumSessions;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class HashMapDemo {
	
	static WebDriver driver;
	static By Email=By.name("username");
	static By Pwd=By.name("password");
	


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver,"CHROME");
		
		TestUtils.maximizeBrowser(driver);
		
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		TestUtils.launchURLUsingGET(driver, "https://classic.crmpro.com/");
		
		TestUtils.ImplicitlyWait(driver, 20);
		
		out.println(TestUtils.getPageTitle(driver));
		
		WebElement Username=TestUtils.getElement(driver,Email);
		WebElement Password=TestUtils.getElement(driver,Pwd);
		
		HashMap<String,String> userData=new HashMap<String,String>();
		
		userData.put("Admin","Admin_123");
		userData.put("Patient","Patient_123");
		userData.put("Doctor","Doctor_123");
		userData.put("Nurse", "Nurse_123");
		
		System.out.println(userData);
		
		Set<Entry<String, String>> entries=userData.entrySet();
		
		Iterator<Entry<String, String>> itr=entries.iterator();
		
		while(itr.hasNext())
		{
						
			Map.Entry<String,String> m=(Map.Entry<String,String>)itr.next();
			
			System.out.println(m.getKey()+"----"+m.getValue());
			
			Username.clear();
			Password.clear();
			
			if(m.getKey().equals("Admin"))
			{
				
				Username.sendKeys("Admin");
				Password.sendKeys(m.getValue());
				Thread.sleep(2000);
				continue;
			}
			else if(m.getKey().equals("Patient"))
			{
				
				Username.sendKeys("Patient");
				Password.sendKeys(m.getValue());
				Thread.sleep(2000);
				continue;
			}
			else if(m.getKey().equals("Doctor"))
			{
				
				Username.sendKeys("Doctor");
				Password.sendKeys(m.getValue());
				Thread.sleep(2000);
				continue;
			}
			else 
			{
				
				Username.sendKeys("Nurse");
				Password.sendKeys(m.getValue());
				Thread.sleep(2000);
				continue;
			}
			
			
			
			
		}
		
		
		
		
		
		
		

	}

}
