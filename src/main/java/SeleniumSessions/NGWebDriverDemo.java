package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import UtilityMethods.TestUtils;

public class NGWebDriverDemo {
	
	static WebDriver driver;
	static NgWebDriver ngWebDriver;
	
	static ByAngularModel input1=ByAngular.model("first");
	static ByAngularModel input2=ByAngular.model("second");
	static ByAngularModel operatorDropdown=ByAngular.model("operator");
	static ByAngularButtonText GoButton=ByAngular.buttonText("Go!");
	static By result=By.tagName("h2");
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver=TestUtils.launchBrowser(driver, "CHROME");
		
		JavascriptExecutor jsDriver=(JavascriptExecutor)driver;
		
		//JavascriptExecutor jsDriver=new ChromeDriver();
		
		ngWebDriver=new NgWebDriver(jsDriver);
		
		TestUtils.launchURLUsingGET(driver,"http://www.way2automation.com/angularjs-protractor/calc/");
		
		ngWebDriver.waitForAngularRequestsToFinish();
		
		String text=doSum("10","20");
		
		System.out.println(text);
		
		
		
		
		
		}
	
	public static String doSum(String v1,String v2)
	{
		WebElement dropdown=TestUtils.getElement(driver, operatorDropdown);
		
		WebElement first_input=TestUtils.getElement(driver, input1);
		first_input.sendKeys(v1);
		
		Select select=new Select(dropdown);
		select.selectByValue("DIVISION");
		
		WebElement second_input=TestUtils.getElement(driver, input2);
		second_input.sendKeys(v2);
		
		TestUtils.clickOn(driver, GoButton);
		
		ngWebDriver.waitForAngularRequestsToFinish();
		
		WebElement text=TestUtils.getElement(driver, result);
		
		return text.getText();
	}

}
