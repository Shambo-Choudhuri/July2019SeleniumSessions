package SeleniumSessions;

import static java.lang.System.out;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.excel.lib.util.XLS_Reader;

import UtilityMethods.TestUtils;
import UtilityMethods.XLS_Reader;

public class GettingDataFromExcelFile {

	
		public static WebDriver driver;
		
		public static By Username=By.name("username");
		public static By Password=By.name("password");
		

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			
			driver=TestUtils.launchBrowser(driver, "CHROME");
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			TestUtils.launchURLUsingGET(driver, "https://classic.crmpro.com/");
			
			
			
			
			TestUtils.maximizeBrowser(driver);
			
			out.println(TestUtils.getPageTitle(driver));
			
			XLS_Reader xls_Reader=new XLS_Reader("./src/main/java/com/excel/lib/util/Excel_Test_Data.xlsx");
			
			int RowCount=xls_Reader.getRowCount("Sheet1");
			
			System.out.println("Row Count="+RowCount);
			
			
			for(int RowNumber=2;RowNumber<=RowCount;RowNumber++)
			{
				String Username_Data=xls_Reader.getCellData("Sheet1", "Username",RowNumber );
				String Password_Data=xls_Reader.getCellData("Sheet1", "Password",RowNumber);
				
				WebElement Username_Field=TestUtils.getElement(driver, Username);
				WebElement Password_Field=TestUtils.getElement(driver, Password);
				
				
				Username_Field.clear();
				TestUtils.ActionsClassSendKeysOperation(driver, Username_Field, Username_Data);
				Password_Field.clear();
				TestUtils.ActionsClassSendKeysOperation(driver, Password_Field, Password_Data);
			}

	}

}
