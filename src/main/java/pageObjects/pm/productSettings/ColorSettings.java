package pageObjects.pm.productSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class ColorSettings extends BasePage {
	
	WaitHelper wait= new WaitHelper(driver);

	public ColorSettings(WebDriver driver) {
		super(driver);

	}

	
	//Add color
	@FindBy(xpath = "//button[text()='Add Color']")
	WebElement btnAddColor;

	@FindBy(id = "colorname")
	WebElement txtColorName;

	@FindBy(id = "colorcode")
	WebElement txtColorCode;

	@FindBy(xpath = "//option[text()='Uniform']")
	WebElement dropdownCategory;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[text()='Color added successfully.']")
	WebElement colorAddedMessage;
	
	
	//Edit
	@FindBy(xpath="(//button[@aria-label='Edit'])[1]")
	WebElement btnEdit;
	
	@FindBy(id = "colorname")
	WebElement txtColorRename;
	
	@FindBy(id = "colorcode")
	WebElement txtColorRecode;
	
	@FindBy(xpath="//button[text()='Update']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//div[text()='Color updated successfully.']")
	WebElement colorUpdatedMessage;
	
	//Delete
	@FindBy(xpath="(//button[@aria-label='Delete'])[1]")
	WebElement btnDelete;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okBtn;
	
	//status
	@FindBy(xpath="(//button[@role='switch'])[1]")
	WebElement btnStatus;
	
	@FindBy(xpath="//div[text()='Colour deleted successfully.']")
	WebElement colorDeletedMessage;
	
	

	public void enterColorName(String color, String code) {
		btnAddColor.click();
		txtColorName.sendKeys(color);
		txtColorCode.sendKeys(code);
		dropdownCategory.click();
		btnSave.click();
	}
	
	public void editColoring(String color, String code)
	{
		btnEdit.click();
		txtColorRename.clear();
		txtColorRename.sendKeys(color);
		txtColorRecode.clear();
		txtColorRecode.sendKeys(code);
		btnUpdate.click();
	}
	
	public void deleteColoring()
	{
		btnDelete.click();
		okBtn.click();
	}
	
	
	public String getColorAddedMessage()
	{
		wait.visibilityOf(colorAddedMessage, 3);
		return colorAddedMessage.getText();
		
	}
	
	
	public String getColorUpdatedMessage()
	{
		wait.visibilityOf(colorUpdatedMessage, 3);
		return colorUpdatedMessage.getText();
		
	}
	
	public String getColorDeletedMessage()
	{
		wait.visibilityOf(colorDeletedMessage, 3);
		return colorDeletedMessage.getText();
		
	}
	
	public void statusChange()
	{
		btnStatus.click();
	}

}
