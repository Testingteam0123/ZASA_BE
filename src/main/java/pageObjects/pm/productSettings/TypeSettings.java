package pageObjects.pm.productSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class TypeSettings extends BasePage {
	
	WaitHelper wait=new WaitHelper(driver);

	public TypeSettings(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//button[text()='TYPE']")
	WebElement selectType;

	@FindBy(xpath = "//button[text()='Add Type']")
	WebElement btnAddtype;

	@FindBy(id = "type")
	WebElement txtEnterType;

	@FindBy(xpath = "//option[text()='Uniform']")
	WebElement dropdowncategory;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "(//button[contains(@class,'text-[#454661]')])[1]")
	WebElement  editTypeBtn;
	
	@FindBy(id = "type")
	WebElement  editTypeField;
	
	@FindBy(xpath = "//button[text()='Update']")
	WebElement  updateBtn;
	
	@FindBy(xpath = "//div[text()='Type updated successfully.']")
	WebElement typeUpdatedMessage;
	
	@FindBy(xpath = "//div[text()='Type added successfully.']")
	WebElement typeAddedMessage;
	
	@FindBy(xpath = "(//button[contains(@class,'text-[#454661]')])[2]")
	WebElement deleteTypeBtn;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement confirmDelete;
	
	@FindBy(xpath="//div[text()='Type deleted successfully.']")
	WebElement typeDeletedMessage;

	public void verifyAddNewType(String typeName) {
		selectType.click();
		btnAddtype.click();
		txtEnterType.sendKeys(typeName);
		dropdowncategory.click();
		saveBtn.click();
	}
	
	public void verifyEditType(String newTypeName) {
		selectType.click();
		editTypeBtn.click();
		editTypeField.clear();
		editTypeField.sendKeys(newTypeName);
		updateBtn.click();
	}
	
	public void verifyDeleteType() {
		selectType.click();
		deleteTypeBtn.click();
		wait.visibilityOf(confirmDelete, 5);
		confirmDelete.click();
	}
	
	
	public String getTypeDeletedMessage() {
		
		wait.visibilityOf(typeDeletedMessage, 5);
		return typeDeletedMessage.getText();
	}
	
	
	
	public String getTypeUpdatedMessage() {
		
		wait.visibilityOf(typeUpdatedMessage, 5);
		return typeUpdatedMessage.getText();
	}
	
	public String getTypeAddedMessage()
	{
		wait.visibilityOf(typeAddedMessage, 5);
		return typeAddedMessage.getText();
	}
	
	

}
