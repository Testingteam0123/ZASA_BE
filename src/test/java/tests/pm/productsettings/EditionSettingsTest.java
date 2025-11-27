package tests.pm.productsettings;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.EditionSettings;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;


@Listeners(ExtentTestListener.class)
public class EditionSettingsTest extends BaseTest{
	
	
	@DataProvider(name="editiondata")
	public Object[][] editionData()
	{
		Object [][] editionData= new Object[1][1];
		Faker f= new Faker();
		for(int i=0;i<1;i++)
		{
		  int editionYear=f.number().numberBetween(1990, 2025);
		  editionData[i][0]=String.valueOf(editionYear);
		
		}
		return editionData;
	}
	
	
	@Test(dataProvider = "editiondata")
	public void verifyAddEditionfunctionality(String editionName)
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		EditionSettings es= new EditionSettings(driver);
	     
		try {
			test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		test.info("Adding the Edition year");	
		es.createEdition(editionName);
		
		String expectedMessage=es.getEditionAddedMessage();
		Assert.assertEquals(expectedMessage, "Edition added successfully.");
		test.pass("Edition year added successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	    	throw e;
		}
	}
	
	@Test(priority = 2)
	public void verifyEditEditionfunctionality()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		EditionSettings es= new EditionSettings(driver);
		
		try {
			
			test.info("Opening the Product Settings page");
	       sp.openProductSettingspage();
	       
	       test.info("Editing the Edition year");
			
		es.editEdition("2002");
		String expectedMessage=es.getEditionUpdatedMessage();
		Assert.assertEquals(expectedMessage, "Edition updated successfully.");
		test.pass("Edition year updated successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	    	throw e;
		}
	}
	
	@Test(priority = 3)
	public void verifyDeleteEditionfunctionality()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		EditionSettings es= new EditionSettings(driver);
		
		try
		{
			test.info("Opening the Product Settings page");
	     sp.openProductSettingspage();
	     test.info("Deleting the Edition year");
		es.deleteEdition();
		
		String expectedMessage=es.getEditionDeletedMessage();
		Assert.assertEquals(expectedMessage, "Edition deleted successfully.");
		test.pass("Edition year deleted successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	    	throw e;
		}
		
	}

}
