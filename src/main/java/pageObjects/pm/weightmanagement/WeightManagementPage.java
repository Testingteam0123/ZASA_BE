package pageObjects.pm.weightmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class WeightManagementPage extends BasePage {
	
	WaitHelper wait=new WaitHelper(driver);

	public WeightManagementPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="(//input[@placeholder='Enter New Weight'])[1]")
	WebElement txtNewWeight;
	
	@FindBy(xpath="//button[text()='SAVE']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[text()='Weights updated successfully!']")
	WebElement weightUpdatedMessage;
	
	
	
	public void addNewWeight(String weight) 
	{
		txtNewWeight.sendKeys(weight);
		btnSave.click();
	}
	
	public String getWeightUpdatedMessage()
	{
	wait.visibilityOf(weightUpdatedMessage, 3);	
	return weightUpdatedMessage.getText();
	}

}
