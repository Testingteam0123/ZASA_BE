package pageObjects.QP.quotationmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;


public class PurchaseReturnPage extends BasePage {
	
	
	WaitHelper wait=new WaitHelper(driver);
	
	public PurchaseReturnPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[text()='Add Purchase Return']")
	WebElement btnAddPurchaseReturn;
	
	
	@FindBy(xpath="//option[text()='CORDOVA']")
	WebElement selectSupplier;
	
	@FindBy(xpath="//input[@type='date']")
	WebElement datePicker;
	
	@FindBy(xpath="//option[text()='PO0000011']")
	WebElement selectPurchase;
	
	@FindBy(css="[placeholder='Search with Product Name or Barcode']")
	WebElement searchProduct;
	
	@FindBy(xpath="//button[contains(@title,'Add')]//*[name()='svg']")
	WebElement productSelectedIcon;
	
	@FindBy(xpath="//button[text()='SAVE']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[text()='Purchase Return added Successfully.']")
	WebElement purchaseReturnAddedMessage;
	
	
	
	public void clickAddPurchaseReturn() 
	{
		btnAddPurchaseReturn.click();
	}
	
	public void selectSupplier() 
	{
		selectSupplier.click();
	}
	
	public void selectDate(String date) 
	{
		datePicker.sendKeys(date);
	}
	
	public void selectPurchase() 
	{
		wait.visibilityOf(selectPurchase, 5);
		selectPurchase.click();
	}
	
	public void clickProductSelectedIcon() 
	{
		searchProduct.click();
		productSelectedIcon.click();
		btnSave.click();
	}
	
	public String getPurchaseReturnAddedMessage() 
	{
		wait.visibilityOf(purchaseReturnAddedMessage, 5);
		return purchaseReturnAddedMessage.getText();
	}
	

}
