package TestNGSessions;

import org.testng.annotations.Test;

public class InvocationCountDemo {
	
	@Test(invocationCount=10,expectedExceptions=Exception.class)
	public void test()
	{
		System.out.println("Create User Accounts");
		int i=9/0;//AE
	}

}
