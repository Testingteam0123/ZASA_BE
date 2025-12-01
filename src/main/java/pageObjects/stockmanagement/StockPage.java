package pageObjects.stockmanagement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class StockPage extends BasePage {
	
	WaitHelper wait= new WaitHelper(driver);

	public StockPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//table[contains(@class,'min-w-full')]")
	WebElement stockTable;
	
	
	@FindBy(xpath = "//table//tbody//tr")
	List<WebElement> stockTableRows;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextButton;
	
	@FindBy(xpath="//span[text()='Filter']")
	WebElement filterOption;
	
	@FindBy(xpath="(//input[@class='accent-[#966AC3]'])[3]")
	WebElement bookFilter;
	
	
	public boolean isStockTableDisplayed() {
		return stockTable.isDisplayed();
	}
	
	public int getStockTableRowCount() {
		return stockTableRows.size();
	}
	
	public void clickNextButton() {
		nextButton.click();
	}
	
	public void useFilter()
	{
		filterOption.click();
	}
	
	public void useBookFilter()
	{
		wait.visibilityOf(bookFilter, 5);
		bookFilter.click();
	}

}
