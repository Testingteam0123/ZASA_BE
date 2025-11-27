package pageObjects.QP.quotationmanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;


public class QuotationManagementPage extends BasePage {
	
	WaitHelper wait = new WaitHelper(driver);

	public QuotationManagementPage(WebDriver driver) {
		super(driver);
		
	}
	
	// ======================
	// LOCATORS
	// ======================
	
	@FindBy(xpath="//button[text()='Add Quotation']")
	WebElement btnAddQuotation;
	
	@FindBy(xpath="//option[text()='Cordova']")
	WebElement selectSupplier;
	
	@FindBy(xpath="//option[text()='Uniform']")
	WebElement selectCategory;
	
	@FindBy(xpath="//input[@placeholder='Search with Product Name or Barcode']")
	WebElement clickProduct;
	
	@FindBy(xpath="//button[@title='Add']")
	List<WebElement> selectProductAddBtn;
	
	@FindBy(xpath="//button[text()='SAVE']")
	WebElement clickSave;
	
	@FindBy(xpath="//div[text()='Quotation added successfully.']")
	WebElement QuotationAddedMessage;
	
	@FindBy(xpath="(//button[@aria-haspopup='menu'])[2]")
	WebElement changeStatus;
	
	@FindBy(xpath="//div[text()='Approve']")
	WebElement selectApproved;
	
	@FindBy(xpath="//textarea[@placeholder='Enter reason here...']")
	WebElement enterReason;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement clickSaveReason;
	
	@FindBy(xpath="(//button[contains(@class,'p-1 hover')])[1]")
	WebElement deleteQuotation;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement confirmDelete;
	
	@FindBy(xpath="//div[text()='Quotation deleted successfully.']")
	WebElement QuotationDeletedMessage;
	
	@FindBy(xpath="//div[text()='Quotation status updated successfully.']")
	WebElement QuotationStatusUpdatedMessage;
	
	
	// ======================
	// METHODS
	// ======================
	
	public void clickAddQuotation() 
	{
		btnAddQuotation.click();
	}

	public void selectSupplierCordova() 
	{
		selectSupplier.click();
	}
	public void selectCategoryUniform() 
	{
		selectCategory.click();
	}
	
	public void selectProduct() 
	{
		clickProduct.click();
	}
	
	public void clickAddBtnOfProduct(int index) 
	{
		selectProductAddBtn.get(index).click();
	}
	
	public void clickSaveBtn() 
	{
		clickSave.click();
	}
	
	public String getQuotationAddedMessage() 
	{
	    wait.visibilityOf(QuotationAddedMessage, 3);
		return QuotationAddedMessage.getText();
	}
	
	public void approveStatus(String reason)
	{
		changeStatus.click();
		wait.visibilityOf(selectApproved, 3);
		selectApproved.click();
		wait.visibilityOf(enterReason, 3);
		enterReason.sendKeys(reason);
		clickSaveReason.click();
	}
	
	public void deleteQuotation()
	{
		deleteQuotation.click();
		wait.visibilityOf(confirmDelete, 3);
		confirmDelete.click();
	}
	
	public String getQuotationDeletedMessage() 
	{
	    wait.visibilityOf(QuotationDeletedMessage, 3);
		return QuotationDeletedMessage.getText();
	}
	
	public String getQuotationStatusUpdatedMesssage()
	{ 
		 wait.visibilityOf(QuotationStatusUpdatedMessage, 3);
		return QuotationStatusUpdatedMessage.getText();
	}

}
