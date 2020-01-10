package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	
WebDriver ldriver;
	
	public AddProductPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"side-menu\"]/li[6]/a/span[1]")
	@CacheLookup
	WebElement productservices;
	
	@FindBy(css="a[href='http://techfios.com/test/billing/?ng=ps/p-new/']")
	@CacheLookup
	WebElement newproduct;
	
	@FindBy(id="name")
	@CacheLookup
	WebElement productname;
	
	@FindBy(id="sales_price")
	@CacheLookup
	WebElement salesprice;
	
	@FindBy(id="item_number")
	@CacheLookup
	WebElement itemnumber;
	
	@FindBy(id="description")
	@CacheLookup
	WebElement description;
	
	
	@CacheLookup
	@FindBy(id ="submit")
	WebElement btnSubmit;
	
	@CacheLookup
	@FindBy(xpath ="//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[3]/a/span")
	WebElement welcometester;
	
	@CacheLookup
	@FindBy(xpath ="//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[3]/ul/li[5]/a")
	WebElement logout;

	
//action
	public void addnewproduct(String Name,String price,String item,String desc) {
		
		productservices.click();
		newproduct.click();
		productname.clear();
		productname.sendKeys(Name);
		salesprice.clear();
		itemnumber.clear();
		itemnumber.sendKeys(String.valueOf(item));
		salesprice.clear();
		salesprice.sendKeys(String.valueOf(price));
		description.clear();
		description.sendKeys(desc);
		
		btnSubmit.click();
		welcometester.click();
		logout.click();
		
		
		
	
		
		
		
		
	}
}
