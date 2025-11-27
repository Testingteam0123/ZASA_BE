package tests.pm.productsettings;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.ColorSettings;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class ColorSettingsTest extends BaseTest {

	@DataProvider(name = "datas")
	public Object[][] data() {
		Faker f = new Faker();
		Object[][] data = new Object[1][2];

		for (int i = 0; i < 1; i++) {
			data[i][0] = "#" + f.color().name();
			data[i][1] = f.color().hex();
		}
		return data;
	}

	@Test(dataProvider = "datas", priority = 1)
	public void verifyAddColorfunctionality(String colorName, String colorCode) {

		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		ColorSettings cs = new ColorSettings(driver);
		
		try {
		test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		test.info("Adding the color details");
		cs.enterColorName(colorName, colorCode);
		
		String expectedmessage=cs.getColorAddedMessage();
		Assert.assertEquals(expectedmessage, "Color added successfully.");
		test.pass("Color added successfully.");
		
		
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
			throw e;
		}

	}

	@Test(priority = 2)
	public void verifyEditColor() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		ColorSettings cs = new ColorSettings(driver);
		
		try {
			
		test.info("Opening the Product Settings page");
		sp.openProductSettingspage();

		test.info("Editing the color details");
		cs.editColoring("#yellow", "#y10");
		cs.statusChange();
		String expectedmessage=cs.getColorUpdatedMessage();
		Assert.assertEquals(expectedmessage, "Color updated successfully.");
		test.pass("Color updated successfully.");
		
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}

	}

	@Test(priority = 3)
	public void verifyDeleteColor() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		ColorSettings cs = new ColorSettings(driver);
		try
		{
		test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		test.info("Deleting the color detail");
		cs.deleteColoring();
		String expectedmeessage=cs.getColorDeletedMessage();
		Assert.assertEquals(expectedmeessage, "Colour deleted successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
	}

}
