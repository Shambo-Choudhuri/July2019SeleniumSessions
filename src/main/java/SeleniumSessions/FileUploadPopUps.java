package SeleniumSessions;

import static org.openqa.selenium.By.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import UtilityMethods.TestUtils;
import static UtilityMethods.TestUtils.*;

public class FileUploadPopUps {
	
	static WebDriver driver;
	static By UploadButton=xpath("//input[@id='fileupload']");

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		
		driver=launchBrowser(driver,"CHROME");
		
		launchURLUsingGET(driver, "https://html.com/input-type-file/");
		
		Thread.sleep(5000);
		
		sendText(driver, UploadButton,"C:\\Users\\lenovo\\Desktop\\Writing Task 2 Tips.png");
		
		Thread.sleep(5000);
		
		quitBrowser(driver);
		
		

	}

}
