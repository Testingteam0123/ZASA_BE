package pageObjects.QP.quotationmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class PurchaseManagementPage extends BasePage {
	
	WaitHelper wait=new WaitHelper(driver);

	public PurchaseManagementPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//button[text()='Add Purchase Order']")
	WebElement btnAddPurchaseOrder;
	
	@FindBy(xpath="//option[text()='Direct Purchase']")
	WebElement selectDirectPurchase;
	
	@FindBy(xpath="//option[text()='Purchase Order']")
	WebElement selectPurchaseOrder;
	
	@FindBy(xpath="//option[text()='CORDOVA']")
	WebElement selectCordova;
	
	@FindBy(xpath="//option[text()='QO0000019']")
	WebElement selectQuotation;
	
	@FindBy(xpath="//button[text()='SAVE']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[text()='Purchase Order added successfully.']")
	WebElement purchaseOrderAddedMessage;
	
	@FindBy(xpath="(//button[contains(@class,'p-1 hover')])[1]")
	WebElement deletePurchaseOrder;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement confirmDelete;
	
	@FindBy(xpath="//div[text()='Purchase Order deleted successfully.']")
	WebElement PurchaseDeletedMessage;
	
	@FindBy(xpath="(//button[@aria-haspopup='menu'])[2]")
	WebElement changeStatus;
	
	@FindBy(xpath="//div[text()='Approve']")
	WebElement selectApproved;
	
	@FindBy(xpath="//textarea[@placeholder='Enter reason here...']")
	WebElement enterReason;
	
	@FindBy(xpath="//button[text()='Approve']")
	WebElement clickSaveReason;
	
	@FindBy(xpath="//div[text()='Purchase status updated successfully.']")
	WebElement PurchaseStatusUpdatedMessage;
	
	
	public void clickAddPurchaseOrder() 
	{
		btnAddPurchaseOrder.click();
	}
	
	public void selectDirectPurchaseOption() 
	{
		selectDirectPurchase.click();
	}
	
	
	public String getPurchaseOrderAddedMessage() 
	{
		wait.visibilityOf(purchaseOrderAddedMessage, 5);
		return purchaseOrderAddedMessage.getText();
	}
	
	public void deletePurchaseOrder() 
	{
		deletePurchaseOrder.click();
		wait.visibilityOf(confirmDelete, 5);
		confirmDelete.click();
	}
	
	public String getPurchaseOrderDeletedMessage() 
	{
		wait.visibilityOf(PurchaseDeletedMessage, 5);
		return PurchaseDeletedMessage.getText();
	}
	
	
	public String getPurchaseStatusUpdatedMessage() 
	{
		wait.visibilityOf(PurchaseStatusUpdatedMessage, 5);
		return PurchaseStatusUpdatedMessage.getText();
	}
	
	public void selectPurchaseOrderOption() 
	{
		selectPurchaseOrder.click();
		selectCordova.click();
		selectQuotation.click();
		wait.elementToBeClickable(btnSave, 3);
		btnSave.click();
	}
	
	public void changeStatusToApproved(String reason) 
	{
		changeStatus.click();
		wait.visibilityOf(selectApproved, 3);
		selectApproved.click();
		wait.visibilityOf(enterReason, 3);
		enterReason.sendKeys(reason);
		clickSaveReason.click();
	}

}
