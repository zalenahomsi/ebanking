package testcases;

import java.io.IOException;

import org.openqa.selenium.By;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.XLUtils;

public class LoginDDT extends TestBase {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pass) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(user, pass);
		
		String title=driver.getTitle();
		
	
		
		Thread.sleep(3000);
		
		
	if(title.equalsIgnoreCase("Dashboard- TechFios Test Application - Billing")) {
		
		System.out.println(title);
		logger.info("login passed");
		Thread.sleep(3000);
	}else {
		
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button")).click();
		logger.info("credentials invalid");
	}
	
	
	
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/testdata/LoginData.xlsx";//C:\Users\Dell\eclipse-workspace(v09-19)\ebanking\src\test\java\testdata\LoginData.xlsx
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	

}
