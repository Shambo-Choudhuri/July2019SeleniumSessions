package TestNGSessions;

import org.testng.annotations.Test;

public class DependsOnMethodDemo {
	
	@Test(priority=1)
	public void loginTest()
	{
		System.out.println("Login Test");
		int i=9/0;
	}
	
	@Test(priority=2,dependsOnMethods= {"loginTest"},alwaysRun=true)
	public void HomePageTest()
	{
		System.out.println("HomePage Test");
		//int i=9/0;
	}

	
	@Test(priority=3,dependsOnMethods= {"loginTest","HomePageTest"},alwaysRun=true)
	public void DashboardTest()
	{
		System.out.println("Dashboard Test");
		//int i=9/0;
	}


}
