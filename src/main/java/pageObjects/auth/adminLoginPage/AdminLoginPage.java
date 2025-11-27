package pageObjects.auth.adminLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.base.BasePage;

public class AdminLoginPage extends BasePage {

	public AdminLoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passField;

	@FindBy(id = "remember")
	WebElement rememberBox;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginbutton;

	public void loginAdmin(String email,String pass)
	{
		emailField.sendKeys(email);
		passField.sendKeys(pass);
		rememberBox.click();
		loginbutton.click();
	}

}
