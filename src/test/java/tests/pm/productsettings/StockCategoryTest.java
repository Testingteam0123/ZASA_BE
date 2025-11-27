package tests.pm.productsettings;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.StockCategory;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class StockCategoryTest extends BaseTest{
	
	@DataProvider(name="stockData")
	public Object[][] datas()
	{
		Object[][] stockdata= new Object [1][2];
		Faker f= new Faker();
		for(int i=0;i<1;i++)
		{
			stockdata[i][0]=f.funnyName().name();
			stockdata[i][1]=f.funnyName().name();
		}
		return stockdata;
	}
	
	@Test(dataProvider = "stockData")
	public void verifyAddStockfunctionality(String name,String address)
	{
		
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		StockCategory sc= new StockCategory(driver);
		
		try
		{
			test.info("Opening the Product Settings page");
	       sp.openProductSettingspage();
			
	       test.info("Adding the stock category");
		sc.addStockCategory(name, address);
		String expectedMessage=sc.getStockAddedMessage();
		Assert.assertEquals(expectedMessage, "Stock Category added successfully.");
		test.pass("Stock Category added successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	        throw e;  
		}
	}

}
