package testcases;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AddProductPage;
import pages.LoginPage;
import utilities.XLUtils;

public class AddProductTest extends TestBase {
	
	@Test(dataProvider="product")
	public void productDDT(String Name,String price,String item,String desc) throws InterruptedException
	{
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(userid, password);

		System.out.println("homepage title: "+driver.getTitle());
		logger.info("login successful");
		Thread.sleep(3000);
		
		logger.info("filling up new product data..");
		AddProductPage cp=new AddProductPage(driver);
		cp.addnewproduct(Name,price,item,desc);
		logger.info("product being added");
		Thread.sleep(3000);
		
			
		
		
		
	}
	
	
	@DataProvider(name="product")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/testdata/product.xlsx";//C:\Users\Dell\eclipse-workspace(v09-19)\ebanking\src\test\java\testdata\LoginData.xlsx
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String proddata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
			proddata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return proddata;
	}


}
