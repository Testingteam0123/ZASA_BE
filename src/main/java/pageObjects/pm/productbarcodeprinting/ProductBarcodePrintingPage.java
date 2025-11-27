package pageObjects.pm.productbarcodeprinting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class ProductBarcodePrintingPage extends BasePage{
	
	WaitHelper wait=new WaitHelper(driver);

	public ProductBarcodePrintingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="(//input[@inputmode='numeric'])[1]")
	WebElement txtNoOfPrints;
	
	@FindBy(xpath="(//button[@role='checkbox'])[2]")
	WebElement chkBox;
	
	@FindBy(xpath="//button[text()='Print Barcodes']")
	WebElement btnPrintBarcodes;
	
	@FindBy(xpath="//div[text()='PDF downloaded successfully.']")
	WebElement pdfDownloadedMessage;
	
	
	
	public void enterNoOfPrints(String noOfPrints) 
	{
		txtNoOfPrints.sendKeys(noOfPrints);
	}
	
	public void selectChkBox() 
	{
		chkBox.click();
	}
	
	public void clickPrintBarcodes() 
	{
		btnPrintBarcodes.click();
	}
	
	public String getPdfDownloadedMessage()
	{
		wait.visibilityOf(pdfDownloadedMessage, 3);
		return pdfDownloadedMessage.getText();
		
	}
}
