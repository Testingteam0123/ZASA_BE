package tests.pm.productbarcodeprinting;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.common.SidePages;
import pageObjects.pm.productbarcodeprinting.ProductBarcodePrintingPage;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class ProductBarcodePrintingTest extends BaseTest {

	@Test
	public void productBarcodePrintingTest() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		ProductBarcodePrintingPage pbp = new ProductBarcodePrintingPage(driver);
		try {
			test.info("Opening the Product Barcode Printing Module");
			sp.openProductBarcodePrintingPage();
			test.info("Entering no of prints that is required");
			pbp.enterNoOfPrints("5");
			pbp.selectChkBox();
			test.info("Click the print barcode button top get the prints");
			pbp.clickPrintBarcodes();

			String expectedMessage = pbp.getPdfDownloadedMessage();
			Assert.assertEquals(expectedMessage, "PDF downloaded successfully.");
			test.pass("PDF downloaded successfully.");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}

	}

}
