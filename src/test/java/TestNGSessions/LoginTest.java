package TestNGSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import UtilityMethods.TestUtils;

import static UtilityMethods.TestUtils.*;


public class LoginTest {
	
	static WebDriver driver;
	static By SignUpLink=By.cssSelector(".private-link.uiLinkWithoutUnderline.uiLinkDark.m-left-1>i18n-string");
	static By Email=By.id("username");
	static By Password=By.id("password");
	static By LoginButton=By.id("loginBtn");
	
	/*
	 * @BeforeSuite public void BeforeSuite() { System.out.println("Before Suite");
	 * }
	 */
	
	/*
	 * @BeforeTest public void BeforeTest() { System.out.println("Before Test"); }
	 * 
	 * @BeforeClass public void BeforeClass() { System.out.println("Before Class");
	 * }
	 */
	
	
	@BeforeTest
	public void setUp()
	{
		driver=launchBrowser(driver,"CHROME");
		launchURLUsingGET(driver,"https://app.hubspot.com/login");
		maximizeBrowser(driver);
		deleteAllCookies(driver);
		ImplicitlyWait(driver,20);
		PageLoadTimeOut(driver,20);
	}
	
	  @BeforeClass 
	  public void BeforeClass() 
	  { 
		  System.out.println("Before Class"); 
	  }
	 
	
	@Test(priority=1)
	public void signUpLinkTest()
	{
		Assert.assertTrue(getElement(driver, SignUpLink).isDisplayed(), "SignUpLink is not Present");
	}
	
	/*
	 * @Test(priority=2) public void verifyLoginPageTitle() throws
	 * InterruptedException { TestUtils.ExplicitWaitForPageTitle(driver,
	 * "HubSpot Login", 20); Assert.assertEquals(getPageTitle(driver),
	 * "HubSpot Login", "Login Page Title is not verified");
	 * //System.out.println("End Here!!"); //Thread.sleep(5000);
	 * 
	 * }
	 * 
	 * @Test(priority=3) public void loginTest() throws InterruptedException {
	 * //Thread.sleep(5000); WebElement Username=getElement(driver, Email);
	 * WebElement Pwd=getElement(driver, Password); WebElement
	 * Login=getElement(driver, LoginButton);
	 * 
	 * ActionsClassSendKeysOperation(driver, Username,
	 * "shambo.choudhuri9@gmail.com"); ActionsClassSendKeysOperation(driver,
	 * Pwd,"pHc#m8m6"); ActionsClassClickOperation(driver, Login);
	 * 
	 * //Thread.sleep(5000);
	 * 
	 * launchURLUsingNavigate(driver,
	 * "https://app.hubspot.com/dashboard-library/8048101");
	 * 
	 * Assert.assertEquals(getPageTitle(driver), "Dashboard Library",
	 * "Home Page Title is not verified");
	 * 
	 * }
	 */	
	/*
	 * @Test(priority=4,enabled=false) public void testEnabled() {
	 * System.out.println("This Test is Skipped"); }
	 * 
	 * @Test(priority=5) public void testWithoutPriority1() {
	 * System.out.println("This Test is without any Priority"); }
	 * 
	 * @Test(priority=5) public void testWithoutPriority2() {
	 * System.out.println("This is not a good practice"); }
	 * 
	 * @Test public void test1() { System.out.println("Test1"); }
	 * 
	 * @Test public void test2() { System.out.println("Test2"); }
	 * 
	 */	
	
	@AfterTest
	public void tearDown()
	{
		quitBrowser(driver);
	}
	
	
	  @AfterClass 
	  public void AfterClass() 
	  { 
		  System.out.println("After Class"); 
	  }
	 
	
	/*
	  @AfterTest public void AfterTest() { System.out.println("After Test"); }
	  
	  @AfterSuite public void AfterSuite() { System.out.println("After Suite"); }
	*/
	 

}
