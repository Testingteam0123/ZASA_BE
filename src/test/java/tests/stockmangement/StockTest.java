package tests.stockmangement;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.common.SidePages;
import pageObjects.stockmanagement.StockPage;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class StockTest extends BaseTest {

	@Test(priority = 1)
	public void verifyStockTable() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sidePages = new SidePages(driver);
		StockPage stockPage = new StockPage(driver);
		try {
			test.info("Opening to the stock management module");
			sidePages.openStocksPage();
			assertTrue(stockPage.isStockTableDisplayed(), "Stock table is NOT displayed!");
			System.out.println("Stock table is displayed");
			test.pass("Stock table is displayed");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}

	}

	@Test(priority = 2)
	public void verifyStockTableRowCount() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sidePages = new SidePages(driver);
		StockPage stockPage = new StockPage(driver);

		try {
			test.info("Opening to the stock management module");
			sidePages.openStocksPage();
			test.info("Verify the stock table has how many rows");
			int rowCount = stockPage.getStockTableRowCount();
			System.out.println("Number of rows in a stock table: " + rowCount);
			test.pass("Number of rows in a stock table: " + rowCount);
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 3)
	public void navigateThroughStockPages() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sidePages = new SidePages(driver);
		StockPage stockPage = new StockPage(driver);

		try {
			test.info("Opening to the stock management module");
			sidePages.openStocksPage();
			test.info("Clicking on the pagenation of stock table");
			stockPage.clickNextButton();
			System.out.println("Navigated to the next page of the stock table.");
			test.pass("Navigated to the next page of the stock table.");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}

}
