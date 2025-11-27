package tests.pm.productsettings;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.TypeSettings;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;


@Listeners(ExtentTestListener.class)
public class TypeSettingsTest extends BaseTest{
 

	
	@DataProvider(name = "typedata")
	public Object[][] typeData() {
		Faker f = new Faker();
		Object[][] data = new Object[1][1];
		for (int i = 0; i < 1; i++) {
			data[i][0] = f.commerce().department();
		}
		return data;
	}

	@Test(dataProvider = "typedata")
	public void verifyAddTypefunctionality(String typedata) {
		 
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		TypeSettings ts = new TypeSettings(driver);
		
		try
		{
			
		test.info("Opening the Product Settings page");
	       sp.openProductSettingspage();
	     
	       test.info("Adding the new type");
		ts.verifyAddNewType(typedata);	
		String expectedMessage=ts.getTypeAddedMessage();
		Assert.assertEquals(expectedMessage, "Type added successfully.");
		
		
		test.pass("Type added successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	        throw e; 
		}
	}
	
	@Test(dataProvider = "typedata",priority = 2)
	public void verifyEditTypefunctionality(String typedata) {
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		TypeSettings ts = new TypeSettings(driver);
		
		try
		{
			test.info("Opening the Product Settings page");
        sp.openProductSettingspage();
			
        test.info("Editing the type");
		ts.verifyEditType(typedata);
		
		String expectedMessage=ts.getTypeUpdatedMessage();
		Assert.assertEquals(expectedMessage, "Type updated successfully.");
		
		test.pass("Type edited successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	        throw e; 
		}
		
	}
	
	@Test(priority = 3)
	public void verifyDeleteTypefunctionality() {
		
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		TypeSettings ts = new TypeSettings(driver);
		
		try
		{
			test.info("Opening the Product Settings page");
	    sp.openProductSettingspage();
			
	    test.info("Deleting the type");
		ts.verifyDeleteType();
		String expectedMessage=ts.getTypeDeletedMessage();
		Assert.assertEquals(expectedMessage, "Type deleted successfully.");
		test.pass("Type deleted successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	        throw e; 
		}
	}
}
