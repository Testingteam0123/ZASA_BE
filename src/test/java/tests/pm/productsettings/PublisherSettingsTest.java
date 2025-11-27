package tests.pm.productsettings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import pageObjects.common.SidePages;
import pageObjects.pm.productSettings.PublisherSettings;
import tests.baseclass.BaseTest;
import utilities.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class PublisherSettingsTest extends BaseTest{
	
	
	@DataProvider(name="datas")
	public Object[][] publishData()
	{
		Object[][] pubData= new Object [1][1];
		Faker f= new Faker();
		for(int i=0;i<1;i++)
		{
			pubData[i][0]=f.name().lastName();
		}
		return pubData;
	}
	
	@Test(dataProvider = "datas")
	public void verifyAddPublisherfunctionality(String name)
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		PublisherSettings ps= new PublisherSettings(driver);
		try {
		test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		test.info("Adding the publisher");
		ps.createPublisher(name);
		
		String expectedMessage=ps.getpublisherAddedMessage();
		Assert.assertEquals(expectedMessage, "Publisher added successfully.");
		
		test.pass("Publisher added successfully");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test(dataProvider = "datas")
	public void verifyEditPublisherfunctionality(String name)
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		PublisherSettings ps= new PublisherSettings(driver);
	    try {
	    	test.info("Opening the Product Settings page");
		sp.openProductSettingspage();
		test.info("Editing the publisher name");
		ps.editPublisher(name);
	    
		
		String expectedMessage=ps.getPublisherUpdatedMessage();
		Assert.assertEquals(expectedMessage, "Publisher updated successfully.");
		test.pass("Publisher updated successfully");
	    }
	    catch(Exception e)
	    {
	    	test.fail("Failed: " + e.getMessage());
	    	throw e;
	    }
		
	}
	
	@Test
	public void verifyDeletePublisherfunctionality()
	{
		ExtentTest test = ExtentTestListener.getTest();
		SidePages sp= new SidePages(driver);
		PublisherSettings ps= new PublisherSettings(driver);
		try {
			test.info("Opening the Product Settings page");
	    sp.openProductSettingspage();
	    test.info("Deleting the publisher name");
		
		ps.deletePublisher();
		String expectedMessage=ps.getPublisherDeletedMessage();
		Assert.assertEquals(expectedMessage, "Publisher deleted successfully.");
		test.pass("Publisher deleted successfully.");
		}
		catch(Exception e)
		{
			test.fail("Failed: " + e.getMessage());
	    	throw e;
		}
	}
	
	

}
