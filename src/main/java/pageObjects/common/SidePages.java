package pageObjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;

public class SidePages extends BasePage {

	public SidePages(WebDriver driver) {
		super(driver);
	}

	// ======================
	// LOCATORS
	// ======================

	@FindBy(xpath = "//span[text()='Product Management']")
	WebElement btnProductManagement;

	@FindBy(xpath = "//button[text()='Product Settings']")
	WebElement brnProductSettings;

	@FindBy(xpath = "(//button[text()='Weight Management'])[1]")
	WebElement btnWeightManagement;

	@FindBy(xpath = "//button[text()='Product']")
	WebElement btnProduct;

	@FindBy(xpath = "(//button[text()='Product Barcode Printing'])[1]")
	WebElement btnProductBarcodePrinting;

	@FindBy(xpath = "//span[text()='Quotation & Purchase']")
	WebElement btnQuotationAndPurchase;
	
	@FindBy(xpath="//*[text()='Quotation Management']")
	WebElement btnQuotationManagement;
	
	@FindBy(xpath="//*[text()='Purchase Management']")
	WebElement btnPurchaseManagement;
	
	@FindBy(xpath="//*[text()='Purchase Return']")
	WebElement btnPurchaseReturn;
	
	@FindBy(xpath = "//span[text()='Stock Management']")
	WebElement btnStockManagement;
	
	@FindBy(xpath = "(//*[text()='Stocks'])[1]")
	WebElement btnStocks;
	
	public void openProductSettingspage() {
		btnProductManagement.click();
		brnProductSettings.click();
	}

	public void openWeightManagementpage() {
		btnProductManagement.click();
		btnWeightManagement.click();
	}

	public void openProductPage() {
		btnProductManagement.click();
		btnProduct.click();
	}

	public void openProductBarcodePrintingPage() {
		btnProductManagement.click();
		btnProductBarcodePrinting.click();
	}
	public void openQuotationManagementPage() {
		btnQuotationAndPurchase.click();
		btnQuotationManagement.click();
	}
	
	
	public void openPurchaseManagementPage() {
		btnQuotationAndPurchase.click();
		btnPurchaseManagement.click();
	}
	
	public void openPurchaseReturnPage() {
		btnQuotationAndPurchase.click();
		btnPurchaseReturn.click();
	}
	
	public void openStocksPage() {
		btnStockManagement.click();
		btnStocks.click();
	}
}
