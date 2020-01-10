package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends TestBase{
	
	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(userid, password);
		logger.info("Entered username");
		//System.out.println("homepage title: "+driver.getTitle());
		
		if(driver.getTitle().equals("Dashboard- TechFios Test Application - Billing"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			System.out.println("homepage title: "+driver.getTitle());
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
