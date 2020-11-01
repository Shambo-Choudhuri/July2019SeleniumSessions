package SeleniumSessions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UtilityMethods.TestUtils;

public class HandleWebTables {
	
	public static WebDriver driver;
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		TestUtils.maximizeBrowser(driver);
		
		TestUtils.launchURLUsingGET(driver, "https://www.w3schools.com/html/html_tables.asp");
		
		TestUtils.PageLoadTimeOut(driver, 30);
		
		TestUtils.deleteAllCookies(driver);
		
		TestUtils.ImplicitlyWait(driver, 20);
		
		By Rows=By.xpath("//table[@id='customers']//tr");
		
		List<WebElement> rows=TestUtils.getMultipleElements(driver, Rows);
		
		int RowSize=rows.size();
		
		System.out.println("Row Size = "+RowSize);
		
		By Columns=By.xpath("//table[@id='customers']//tr[2]//td");
		
		List<WebElement> columns=TestUtils.getMultipleElements(driver, Columns);
		
		System.out.println("Column Size = "+columns.size());
		
		for(int i=2;i<=RowSize;i++)
		{
			System.out.println("\n");
			
			for(int j=1;j<=columns.size();j++)
			{
				WebElement element=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]"));
				System.out.print(" "+ element.getText());
			}
		}
		
		
		
		
	}

}
