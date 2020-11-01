package TestNGSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionsDemo {
	
	@Test(expectedExceptions=Exception.class)
	public void test1()
	{
		
		System.out.println("Test1");
		int i=9/0;
	}
	

}
