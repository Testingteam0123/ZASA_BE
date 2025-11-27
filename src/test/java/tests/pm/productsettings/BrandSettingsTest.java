package tests.pm.productsettings;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.BrandSettings;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class BrandSettingsTest extends BaseTest {

	@DataProvider(name = "brandDatas")
	public Object[][] branddata() {
		Faker f = new Faker();
		Object[][] branddata = new Object[1][5];
		for (int i = 0; i < 1; i++) {
			branddata[i][0] = f.name().firstName();
			branddata[i][1] = f.internet().emailAddress();
			branddata[i][2] = f.number().digits(5);
			branddata[i][3] = f.name().fullName();
			branddata[i][4] = "9" + f.phoneNumber().subscriberNumber(8);
		}
		return branddata;
	}

	@Test(dataProvider = "brandDatas")
	public void verifyAddBrandfunctionality(String name, String email, String code, String continfo, String phoneNo) {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		BrandSettings bs = new BrandSettings(driver);
		try {
			test.info("Opening the Product Settings page");
			sp.openProductSettingspage();
			test.info("Adding Brand details");
			bs.enterBrand(name, email, code, continfo, phoneNo);
			String expectedmessage = bs.getBrandAddedMessage();
			Assert.assertEquals(expectedmessage, "Brand added successfully.");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}
}
