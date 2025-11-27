package tests.QP.quotationmanagement;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import org.testng.Assert;


import pageObjects.QP.quotationmanagement.QuotationManagementPage;
import pageObjects.common.SidePages;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class QuotationMangementTest extends BaseTest{
	
	@Test(priority = 1)
	public void addQuotation()
	{
		
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		QuotationManagementPage qmp= new QuotationManagementPage(driver);
		try {
		test.info("Opening the Quotation and Purchase module");	
		sp.openQuotationManagementPage();
	    test.info("Adding Quotation to the Quotation Management Module");
		qmp.clickAddQuotation();
		qmp.selectSupplierCordova();
		qmp.selectCategoryUniform();
		qmp.selectProduct();
		qmp.clickAddBtnOfProduct(0);
		qmp.clickAddBtnOfProduct(0);
		qmp.clickAddBtnOfProduct(0);
		qmp.clickSaveBtn();
		
		String quotationsucessmsg=qmp.getQuotationAddedMessage();
		
		Assert.assertEquals(quotationsucessmsg, "Quotation added successfully.");
		test.pass("Quotation added successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
		
	}
	
	//@Test(priority=2)
	public void approveQuotation()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		QuotationManagementPage qmp= new QuotationManagementPage(driver);
		try {
		test.info("Opening the Quotation and Purchase module");	
		sp.openQuotationManagementPage();
		test.info("Approving the Quotation status in Quotation Management Module");
		qmp.approveStatus("Approved");
		String expectedMessage=qmp.getQuotationStatusUpdatedMesssage();
		Assert.assertEquals(expectedMessage, "Quotation status updated successfully.");
		test.pass("Quotation status updated successfully.");
		
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
	}
	
	//@Test(priority=3)
	public void deleteQuotation()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp = new SidePages(driver);
		QuotationManagementPage qmp= new QuotationManagementPage(driver);
		try {
			test.info("Opening the Quotation and Purchase module");		
			sp.openQuotationManagementPage();
			test.info("Deleting the quotation in Quotation Management Module");		
		qmp.deleteQuotation();
		String quotationdeletemsg=qmp.getQuotationDeletedMessage();
		Assert.assertEquals(quotationdeletemsg, "Quotation deleted successfully.");
		test.pass("Quotation deleted successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed"+e.getMessage());
			throw e;
		}
		
		
	}

}
