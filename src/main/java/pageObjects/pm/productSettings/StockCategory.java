package pageObjects.pm.productSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class StockCategory extends BasePage{
	
	WaitHelper wait=new WaitHelper(driver);

	public StockCategory(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[text()='STOCK CATEGORY']")
	WebElement selectStock;
	
	@FindBy(xpath="//button[text()='Add Stock Category']")
	WebElement btnAddStock;
	
	@FindBy(id="categoryname")
	WebElement txtCategoryName;
	
	@FindBy(xpath="//option[text()='Stationery']")
	WebElement selectcategory;
	
	@FindBy(css="#description")
	WebElement txtdescription;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[text()='Stock Category added successfully.']")
	WebElement stockCategoryAddedMessage;
	
	
	public void addStockCategory(String name,String txt)
	{
		selectStock.click();
		btnAddStock.click();
		txtCategoryName.sendKeys(name);
		selectcategory.click();
		txtdescription.sendKeys(txt);
		saveBtn.click();
	}
	
	public String getStockAddedMessage()
	{
		wait.visibilityOf(stockCategoryAddedMessage, 5);
		return stockCategoryAddedMessage.getText();
		
	}

}
