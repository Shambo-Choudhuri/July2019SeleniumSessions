package TestNGSessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRetryTest {
	
	@Test(priority=1)
	public void test1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test(priority=2)
	public void test2()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test(priority=3)
	public void test3()
	{
		Assert.assertEquals(true, true);
	}
	
	

}
