package UtilityMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestUtils {
	
	/*
	 * 	Launch a browser with no URL i.e Launch a driver Session
	 * 
	 * 
	 */
	
	public static WebDriver launchBrowser(WebDriver driver,String browserName) //throws Exception
	{
		
		 switch(browserName)
		 {
		 	case "CHROME":
		 			WebDriverManager.chromedriver().setup();
		 			driver=new ChromeDriver();
		 			break;
		 			
		 	case "FIREFOX":
		 			WebDriverManager.firefoxdriver().setup();
		 			driver=new FirefoxDriver();
		 			break;
		 			
		 	/*default:
		 		 	throw new Exception("NoSuchBrowserException");*/
		 }
		 
		 return driver;
	}
	
	/*
	 * RETURNS THE URL in which the driver object currently has control
	 */
	
	public static String getCurrentUrl(WebDriver driver)
	{
		return(driver.getCurrentUrl());
	}
	
	/*
	 * Launch the specified URL 
	 */
	public static void launchURLUsingGET(WebDriver driver,String URL)
	{
		driver.get(URL);
	}
	
	public static void launchURLUsingNavigate(WebDriver driver,String URL)
	{
		driver.navigate().to(URL);
	}
	
	/*
	 * Return the Page Title
	 */
	
	public static String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	/*
	 * Click on a particular WebElement using a specific locator
	 */
	
	public static void clickOn(WebDriver driver,By locator)
	{
		getElement(driver,locator).click();
	}
	
	/*
	 * Quit the Browser or driver session
	 */
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	/*
	 * Refresh the browser
	 */
	
	public static void refreshBrowser(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	/*
	 * Back and Forward operations
	*/
	
	public static void forwardBrowser(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	public static void backwardBrowser(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	/*
	 * Accept the Alert
	 */
	public static String acceptAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		String getTextOfAlert=alert.getText();
		alert.accept();
		return getTextOfAlert;
	}
	
	/*
	 * Dismiss the Alert
	 */
	
	public static String dismissAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		String getTextOfAlert=alert.getText();
		alert.dismiss();
		return getTextOfAlert;
	}
	
	/*
	 *  Return the Page Source of the current window
	 */
	
	public static String getPageSource(WebDriver driver)
	{
		return driver.getPageSource();
	}
	
	/*
	 *  Clears the Value
	 */
	
	public static void clearText(WebDriver driver,By locator)
	{
		getElement(driver,locator).clear();
	}
	
	/*
	 * Send value to a TextBox/EditBox
	 */
	
	public static void sendText(WebDriver driver,By locator,String str)
	{
		getElement(driver,locator).sendKeys(str);
	}
	
	/*
	 *  Return a single WebElement
	 */
	
	public static WebElement getElement(WebDriver driver,By locator)
	{
		return driver.findElement(locator);
	}
	
	
	/*
	 * Maximize the Browser
	 */
	
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	public static Set<String> getWindowHandles(WebDriver driver)
	{
		return driver.getWindowHandles();
	}
	
	public static String getWindowHandle(WebDriver driver)
	{
		return driver.getWindowHandle();
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	
	public static String getAttributeValueOfElement(WebDriver driver,By locator,String attribute)
	{
		return(getElement(driver,locator).getAttribute(attribute));
	}	
	
	public static void selectItemFromDropdownUsingSelectClass(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static List<WebElement> getMultipleElements(WebDriver driver,By locator)
	{
		return driver.findElements(locator);
	}
	
	public static void selectItemFromDropdownWithoutUsingSelectClass(WebDriver driver,String text,By locator)
	{
		List<WebElement> elements=getMultipleElements(driver,locator);
		
		System.out.println("Total Number of Elements = " +elements.size());
		
		Iterator<WebElement> itr=elements.iterator();
		
		while(itr.hasNext())
		{
			WebElement element=itr.next();
			String elementText=element.getText();
			
			if(elementText.equals(text))
			{
				element.click();
			}
		}
		
	}
	
	public static void handleFramesUsingFrameName(WebDriver driver,String frameName) throws InterruptedException
	{
		driver.switchTo().frame(frameName);
		Thread.sleep(3000);
		
	}
	
	public static void handleFramesUsingFrameIndex(WebDriver driver,int frameIndex) throws InterruptedException
	{
		driver.switchTo().frame(frameIndex);
		Thread.sleep(3000);
		
	}
	
	public static void handleFramesUsingFrameElement(WebDriver driver,WebElement frameElement) throws InterruptedException
	{
		driver.switchTo().frame(frameElement);
		Thread.sleep(3000);
		
	}
	
	public static void switchToParentWindowFromFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public static void mouseHoverOperation(WebDriver driver,WebElement target)
	{
		Actions action=new Actions(driver);
		action.moveToElement(target).build().perform();
	}
	
	public static void DragAndDropOperation(WebDriver driver,WebElement source,WebElement target)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}
	
	public static void RightClickOperation(WebDriver driver,WebElement target)
	{
		Actions action=new Actions(driver);
		action.contextClick(target).build().perform();
	}
	
	public static void ActionsClassSendKeysOperation(WebDriver driver,WebElement target,String value)
	{
		Actions action=new Actions(driver);
		action.sendKeys(target,value).build().perform();
	}
	
	public static void ActionsClassClickOperation(WebDriver driver,WebElement target)
	{
		Actions action=new Actions(driver);
		action.click(target).build().perform();
	}
	
	public static void TakeScreenshotOfEntirePage(WebDriver driver,String FileName)
	{
		//Screenshot Captured
		
		//WebDriver driver=new ChromeDriver();
		
		//TakesScreenshot driver=new ChromeDriver();
		
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Store/Copy the captured screenshot in a file
		try 
		{
			FileUtils.copyFile(screenshot,new File("./target/Screenshots/" + FileName + ".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void ImplicitlyWait(WebDriver driver,long TotalWaitingTime)
	{
		driver.manage().timeouts().implicitlyWait(TotalWaitingTime,TimeUnit.SECONDS);
	}
	
	public static void ExplicityWaitForElementToBeClickable(WebDriver driver,WebElement element,long TotalWaitingTime)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,TotalWaitingTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
	
	
	public static void PageLoadTimeOut(WebDriver driver,long TotalWaitingTime)
	{
		driver.manage().timeouts().pageLoadTimeout(TotalWaitingTime, TimeUnit.SECONDS);
	}
	
	public static void deleteAllCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}

	public static void ExplicitlyWaitForPresenceofElement(WebDriver driver, By locator, long TotalWaitingTime) {
		
		/*Driver will wait till the Presence of element located detected in HTML DOM
		Once detected in HTML DOM it does not mean that element will be visible in the UI at once.It may take some time.
		Hence important to use visibilityOfElementLocated() method to ensure that driver waits till the element is visible both in DOM and in UI*/
		
		WebDriverWait wait=new WebDriverWait(driver,TotalWaitingTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void ExplicityWaitForVisibilityOfElement(WebDriver driver,By locator,long TotalWaitingTime,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,TotalWaitingTime);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void ExplicityWaitForAlerts(WebDriver driver,long TotalWaitingTime)
	{
		try
		{	//This is for only JavaScript Alerts
			WebDriverWait wait=new WebDriverWait(driver,TotalWaitingTime);
			wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void ExplicityWaitForVisibilityOfMultipleElements(WebDriver driver,List<WebElement> elements,long TotalWaitingTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,TotalWaitingTime);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements)); 
	}
	
	public static WebElement useFluentWait(WebDriver driver,long TotalWaitingTime,long pollingPeriodTime,final By locator)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
							.withTimeout(TotalWaitingTime,TimeUnit.SECONDS)
							.pollingEvery(pollingPeriodTime, TimeUnit.SECONDS)
							.ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(new Function<WebDriver,WebElement>()
		{

			@Override
			public WebElement apply(WebDriver driver) 
			{
				// TODO Auto-generated method stub
				return driver.findElement(locator);
			}
		
		});
		
		return element;
		
	}
	
	//The above Fluent Wait can be written like below as well
	
	public static WebElement useFluentWaitDifferently(WebDriver driver,long TotalWaitingTime,long pollingPeriodTime,final By locator)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
							.withTimeout(TotalWaitingTime,TimeUnit.SECONDS)
							.pollingEvery(pollingPeriodTime, TimeUnit.SECONDS)
							.ignoring(NoSuchElementException.class);
		
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	//Custom Wait[Not recomended to use]
	
	public static WebElement customWait(WebDriver driver,By locator,long TotalWaitingTime) throws InterruptedException
	{
		WebElement element=null;
		
		for(int i=1;i<=TotalWaitingTime;i++)
		{
			try
			{
				element=getElement(driver, locator);
				break;
			}
			catch(Exception e)
			{
				System.out.println("Waiting for Element to be present on the page " +i +"secs");
				Thread.sleep(1000);
			}
		}
		
		if(element==null)
		{
			throw new NoSuchElementException("Element Not Found");
		}
		
		else
		{
			return element;
		}
		
		
	}
	
	public static void handleJQueryDropdown(WebDriver driver,By locator,String... value)
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
				
				for(String value1:value)
				{
					if(element.getText().equalsIgnoreCase(value1))
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

	


	public static void ExplicitWaitForPageTitle(WebDriver driver,String title,long TotalWaitingTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,TotalWaitingTime);
		wait.until(ExpectedConditions.titleContains(title));
	}

}


	
	
			
		
							
	


	
	
	
	
	
	

	
	

	
	

	
	
	
	
	
	


