package pageObjects.pm.productSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class BrandSettings extends BasePage{
 
	WaitHelper wait= new WaitHelper(driver);
	
	public BrandSettings(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//button[text()='BRAND']")
	WebElement selectBrand;
	
	@FindBy(xpath="//button[text()='Add Brand']")
	WebElement btnAddBrand;
	
	@FindBy(css ="#name")
	WebElement txtBrandName;
	
	@FindBy(css="#email")
	WebElement txtEmailAdd;
	
	@FindBy(css="#code")
	WebElement txtCode;
	
	@FindBy(css="#contactinfo")
	WebElement txtContInfo;
	
	@FindBy(css="[type='number']")
	WebElement txtNumber;
	
	@FindBy(xpath = "//option[text()='Uniform']")
	WebElement dropdownCategory;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[text()='Brand added successfully.']")
	WebElement brandAddedMessage;
	
	public void enterBrand(String name,String email,String code,String contInfo, String contno)
	{
		selectBrand.click();
		btnAddBrand.click();
		txtBrandName.sendKeys(name);
		txtEmailAdd.sendKeys(email);
		txtCode.sendKeys(code);
		txtContInfo.sendKeys(contInfo);
		txtNumber.sendKeys(contno);
		dropdownCategory.click();
		btnSave.click();
		
	}
	
	public String getBrandAddedMessage()
	{
		wait.visibilityOf(brandAddedMessage, 3);
		return brandAddedMessage.getText();
	}

}
