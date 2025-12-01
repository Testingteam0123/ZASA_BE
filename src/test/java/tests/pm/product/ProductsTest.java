package tests.pm.product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.common.SidePages;
import pageObjects.pm.product.ProductPage;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class ProductsTest extends BaseTest {

	//@Test(priority = 1)
	public void verifyAddUniformProduct() {

		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		ProductPage p = new ProductPage(driver);
		try {
			test.info("Opening the Product Module");
			sp.openProductPage();
			test.info("Adding a Uniform product in the product module");
			p.addUniformProduct("Uniform Shirt", "25");

			String actualSuccessMessage = p.ProductAddedMessage();
			Assert.assertEquals(actualSuccessMessage, "Product added successfully.");
			test.pass("Uniform product added successfully");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}

	//@Test(priority = 4)
	public void verifyDeleteProduct() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		ProductPage p = new ProductPage(driver);
		try {
			test.info("Opening the Product module");
			sp.openProductPage();
			test.info("Deleting a product from Product module");
			p.deleteProduct();

			String actualDeleteMessage = p.getDeleteMessage();

			Assert.assertEquals(actualDeleteMessage, "Product deleted successfully.");
			test.pass("Deleted the product successfully");
		} catch (Exception e) {
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}

	//@Test(priority = 2)
	public void verifyAddStationaryProduct() {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		ProductPage p = new ProductPage(driver);
		try {
			test.info("Opening the Product module");
		sp.openProductPage();

		test.info("Adding a Stationary product in the product module");
		p.addStationaryProduct("scissors", "25");

		String actualSuccessMessage = p.ProductAddedMessage();
		Assert.assertEquals(actualSuccessMessage, "Product added successfully.");
		test.pass("Stationary product added successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed" + e.getMessage());
			throw e;
		}
		// verifyDeleteProduct();
	}

	//@Test(priority = 3)
	public void verifyEditProduct() throws InterruptedException {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		ProductPage p = new ProductPage(driver);
		try {
			test.info("Opening the Product module");
		sp.openProductPage();

		test.info("Editing a product in the product module");
		p.editProduct("edited product");

		String actualSuccessMessage = p.productUpdatedSuccessMessage();
		Assert.assertEquals(actualSuccessMessage, "Product updated successfully.");
		test.pass("Product edited successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed" + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void checkThePolicyUpdateFunction()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		ProductPage p = new ProductPage(driver);
		try {
			test.info("Opening the Product module");
			sp.openProductPage();
			test.info("Updating the policy of the product");
			p.policyUpdate();
			
			String expectedMessage=p.getPolicyUpdateMessage();
			Assert.assertEquals(expectedMessage, "Policy updated successfully.");
			test.pass("Policy updated successfully.");
			
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
	}

}
