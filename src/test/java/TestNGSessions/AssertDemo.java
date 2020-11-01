package TestNGSessions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo {
	
	
	
		
	@Test(priority=1)
	public void test1()
	{
		//SoftAssert softAssert=new SoftAssert();
		Assert.assertEquals(true, false);   //---------------------//Hard Assertion
		//softAssert.assertEquals(true, true);
		System.out.println("End of TC1");
		//softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void test2()
	{
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(true, true);  //---------------------//Soft Assertion
		softAssert.assertEquals(true, true);
		softAssert.assertAll();
		System.out.println("End of TC2");
	}
	
	@Test(priority=3)
	public void test3()
	{
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(true, true);
		softAssert.assertAll();
		System.out.println("End of TC3");
	}
	
	
	
	
	

}
