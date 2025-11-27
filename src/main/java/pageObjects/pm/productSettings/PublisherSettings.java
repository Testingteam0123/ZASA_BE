package pageObjects.pm.productSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class PublisherSettings extends BasePage{
	
	WaitHelper wait=new WaitHelper(driver);

	public PublisherSettings(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[text()='PUBLISHER']")
	WebElement selectpublisher;
	
	@FindBy(xpath="//button[text()='Add Publisher']")
	WebElement btnAddPublisher;
	
	@FindBy(id="publishername")
	WebElement publishName;
	
	@FindBy(xpath="//option[text()='Stationery']")
	WebElement selectcategory;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "(//button[contains(@class,'text-[#454661]')])[1]")
	WebElement  editPublisherBtn;
	
	@FindBy(id = "publishername")
	WebElement  editPublisherField;
	
	@FindBy(xpath = "//button[text()='Update']")
	WebElement  updateBtn;
	
	@FindBy(xpath = "//div[text()='Publisher updated successfully.']")
	WebElement publisherUpdatedMessage;
	
	@FindBy(xpath = "(//button[contains(@class,'text-[#454661]')])[2]")
	WebElement deletePublisherBtn;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement confirmDelete;
	
	@FindBy(xpath="//div[text()='Publisher deleted successfully.']")
	WebElement publisherDeletedMessage;
	
	@FindBy(xpath="//div[text()='Publisher added successfully.']")
	WebElement publisherAddedMessage;
	
	
	public void createPublisher(String name)
	{
		selectpublisher.click();
		btnAddPublisher.click();
		publishName.sendKeys(name);
		selectcategory.click();
		saveBtn.click();
		
	}
	
	public void editPublisher(String newName)
	{
		selectpublisher.click();
		editPublisherBtn.click();
		editPublisherField.clear();
		editPublisherField.sendKeys(newName);
		updateBtn.click();
	}
	
	public void deletePublisher()
	{
		selectpublisher.click();
		deletePublisherBtn.click();
		wait.visibilityOf(confirmDelete, 5);
		confirmDelete.click();
	}
	
	public String getPublisherUpdatedMessage() 
	{
		wait.visibilityOf(publisherUpdatedMessage, 5);
		return publisherUpdatedMessage.getText();
	}
	
	
	public String getPublisherDeletedMessage() 
	{
		wait.visibilityOf(publisherDeletedMessage, 5);
		return publisherDeletedMessage.getText();
	}
	
	public String getpublisherAddedMessage()
	{
		wait.visibilityOf(publisherAddedMessage, 5);
		return publisherAddedMessage.getText();
	}
}
