package tests.QP.quotationmanagement;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import org.testng.Assert;
import pageObjects.QP.quotationmanagement.PurchaseManagementPage;
import pageObjects.common.SidePages;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class PurchaseManagementTest extends BaseTest{
	
	@Test
	public void addpurchaseManagementTest()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		PurchaseManagementPage pmp= new PurchaseManagementPage(driver);
		try {
		test.info("Opening the Quotation and Purchase module");
		sp.openPurchaseManagementPage();
		test.info("In the Purchase management adding the purchase order");
		pmp.clickAddPurchaseOrder();
		pmp.selectPurchaseOrderOption();
		
		String purchaseordersuccessmsg=pmp.getPurchaseOrderAddedMessage();
		Assert.assertEquals(purchaseordersuccessmsg, "Purchase Order added successfully.");
		test.pass("Purchase Order added successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
	}
	
	@Test(priority=2)
	public void deletePurchaseOrderTest()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		PurchaseManagementPage pmp= new PurchaseManagementPage(driver);
		try {
		test.info("Opening the Quotation and Purchase module");
		sp.openPurchaseManagementPage();
		test.info("In the Purchase management deleting the purchase order");
		pmp.deletePurchaseOrder();
		String purchaseorderdeletemsg=pmp.getPurchaseOrderDeletedMessage();
		Assert.assertEquals(purchaseorderdeletemsg, "Purchase Order deleted successfully.");
		test.pass("Purchase Order deleted successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
		
	}
	
	@Test(priority=3)
	public void approvePurchaseOrderTest()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		PurchaseManagementPage pmp= new PurchaseManagementPage(driver);
		try {
		test.info("Opening the Quotation and Purchase module");
		sp.openPurchaseManagementPage();
		test.info("In the Purchase management approving the status of purchase order");
		pmp.changeStatusToApproved("Approved");
		
		String purchaseorderapprovemsg=pmp.getPurchaseStatusUpdatedMessage();
		Assert.assertEquals(purchaseorderapprovemsg, "Purchase status updated successfully.");
		test.pass("Purchase status updated successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
	}
	

}
