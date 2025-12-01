package pageObjects.stockmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class MarkDeadStockPage extends BasePage{

	WaitHelper wait= new WaitHelper(driver);
	
	public MarkDeadStockPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//table")
	WebElement markDeadTable;
	
	@FindBy(xpath="(//input[@inputmode='numeric'])[1]")
	WebElement markDeadCount;
	
	@FindBy(xpath="//button[text()='Mark Dead']")
	WebElement btnMarkDead;
	
	@FindBy(xpath="(//button[@title='View History'])[1]")
	WebElement stockHistory;
	
	@FindBy(xpath="//div[text()='Dead stock marked successfully!']")
	WebElement stockMarkedMessage;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement btnClose;

	
	public boolean isMarkDeadTableDisplayed() {
		return markDeadTable.isDisplayed();
	}
	
	public void addMarkDead(String markdead)
	{
		markDeadCount.click();
		markDeadCount.sendKeys(markdead);
		wait.elementToBeClickable(btnMarkDead, 3);
		btnMarkDead.click();
	}
	
	public String getStockMarkedMessage()
	{
		wait.visibilityOf(stockMarkedMessage, 5);
		return stockMarkedMessage.getText();
		
	}
	
	public void viewStockHistory()
	{
		stockHistory.click();
		wait.elementToBeClickable(btnClose, 3);
		btnClose.click();
	}
	
	

}
