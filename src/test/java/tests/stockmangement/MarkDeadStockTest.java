package tests.stockmangement;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.common.SidePages;
import pageObjects.stockmanagement.MarkDeadStockPage;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;


@Listeners(ExtentTestListener.class)
public class MarkDeadStockTest extends BaseTest{
	
	

	@Test(priority = 1)
	public void verifyMarkDeadStock()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sidePages = new SidePages(driver);
		MarkDeadStockPage mp= new MarkDeadStockPage(driver);
		try
		{
		  test.info("Opening to the stock management module");
		  sidePages.openMarkDeadStock();
		  assertTrue(mp.isMarkDeadTableDisplayed(), "Mark Dead Stock is NOT displayed!");
			System.out.println("Mark Dead Stock is displayed");
			test.pass("Mark Dead Stock is displayed");
		  
		}
		catch(Exception e)
		{
		  test.fail("Failed"+e.getMessage());
		  throw e;
		}
		
	}
	
	@Test(priority = 2)
	public void verifyAddMarkDeadFunctionality()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sidePages = new SidePages(driver);
		MarkDeadStockPage mp= new MarkDeadStockPage(driver);
		try {
			 test.info("Opening to the stock management module");
			//sidePages.openMarkDeadStock();
			 test.info("Adding the Mark Dead Count");
			 mp.addMarkDead("8");
			 String expectedMesssage=mp.getStockMarkedMessage();
			 Assert.assertEquals(expectedMesssage, "Dead stock marked successfully!");
			 test.pass("Dead stock marked successfully!");
			
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
	}
	
	
	@Test(priority = 3)
	public void verifyStockSummaryHistory()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sidePages = new SidePages(driver);
		MarkDeadStockPage mp= new MarkDeadStockPage(driver);
		try
		{
			 test.info("Opening to the stock management module");
			//sidePages.openMarkDeadStock();
			 test.info("Verifying the Stock summary history");
			 mp.viewStockHistory();
			 test.pass("Stock summary history displayed successfully");
		}
		catch(Exception e)
		{
			test.fail("Stock summary history displayed successfully");
			throw e;
		}
		
	}

}
