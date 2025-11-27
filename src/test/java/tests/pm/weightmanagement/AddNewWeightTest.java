package tests.pm.weightmanagement;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.common.SidePages;
import pageObjects.pm.weightmanagement.WeightManagementPage;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class AddNewWeightTest extends BaseTest {

	@Test
	public void addNewWeightTest() {

		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		WeightManagementPage weightPage = new WeightManagementPage(driver);
		try {
			test.info("Opening the Weight Management");
			sp.openWeightManagementpage();
			test.info("Adding Weight for the product");
			weightPage.addNewWeight("8");
			String expectedMessage = weightPage.getWeightUpdatedMessage();
			Assert.assertEquals(expectedMessage, "Weights updated successfully!");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}

}
