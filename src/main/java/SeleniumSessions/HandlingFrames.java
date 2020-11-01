package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static UtilityMethods.TestUtils.*;

import java.util.List;

import UtilityMethods.TestUtils;

public class HandlingFrames {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		launchURLUsingGET(driver, "http://www.londonfreelance.org/courses/frames/index.html");
		
		Thread.sleep(5000);
		
		maximizeBrowser(driver);
		
		WebElement frameElement=driver.findElement(By.xpath("//frame[@name='main']"));
		
		handleFramesUsingFrameElement(driver, frameElement);
		
		String text=driver.findElement(By.cssSelector("body > h2")).getText();
		
		System.out.println(text);
		
		switchToParentWindowFromFrame(driver);
		
		List<WebElement> Frame_Count=driver.findElements(By.tagName("frame"));
		
		System.out.println(Frame_Count.size());
		
		
		
		
		
		
		
		
		
		
		
	}

}
