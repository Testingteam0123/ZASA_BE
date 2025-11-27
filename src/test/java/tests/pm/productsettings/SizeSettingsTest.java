package tests.pm.productsettings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.SizeSettings;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class SizeSettingsTest extends BaseTest {

	@DataProvider(name = "Sizes")
	public Object[][] data() {
		Faker f = new Faker();
		Object[][] data = new Object[1][1];
		for (int i = 0; i < 1; i++) {
			int randomSize = f.number().numberBetween(28, 50);
			data[i][0] = String.valueOf(randomSize); // convert to String if needed
		}

		return data;
	}

	 @Test(dataProvider = "Sizes")
	public void verifyAddSizefunctionality(String size) {

		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		SizeSettings ss = new SizeSettings(driver);
		try {
			test.info("Opening the Product Settings page");
			sp.openProductSettingspage();
			test.info("Adding the size");
			ss.enterSize(size);
			String expectedMessage = ss.getSizeAddedMessage();
			Assert.assertEquals(expectedMessage, "Size added successfully.");
			test.pass("Size added Successfully.");
		} catch (Exception e) {
			test.fail("Failed: " + e.getMessage());
			throw e;
		}

	}

	 @Test(priority = 2)
	public void verifySizeEditFunctionality() {

		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		SizeSettings ss = new SizeSettings(driver);
		
		try
		{
		test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		test.info("Editing the size");
		ss.editSize("42");

		String expectedMessage = ss.getSizeUpdatedMessage();
		Assert.assertEquals(expectedMessage, "Size updated successfully.");
		test.pass("Size updated successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
			throw e;
		}

	}

	@Test(priority = 3)
	public void verifySizeDeleteFunctionality() {

		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		SizeSettings ss = new SizeSettings(driver);
 		
		try {
			test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		
		test.info("Deleting the size");

		ss.deleteSize();

		String expectedMessage = ss.getSizeDeletedMessage();
		Assert.assertEquals(expectedMessage, "Size deleted successfully.");
		test.pass("Size deleted successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
			throw e;
		}
	}

}
