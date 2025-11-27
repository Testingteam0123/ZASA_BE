package tests.auth.adminLogin;

import org.testng.annotations.Test;

import pageObjects.auth.adminLoginPage.AdminLoginPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import tests.baseclass.BaseTest;

public class AdminloginTest extends BaseTest {

	@BeforeMethod
	public void navigateToLoginPage() {
		driver.get(p.getProperty("url"));
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		Object[][] data = { { "ajay@storee.com", "123456", "Invalid" }, { "ajay@store.com", "12345", "Invalid" },
				{ "", "123456", "Invalid" }, { "ajay@storee.com", "", "Invalid" },
				{ "ajay@store.com", "123456", "Valid" } };

		return data;
	}

	@Test(dataProvider = "loginData")
	public void logintest(String email, String pass, String expectedResult) throws IOException, InterruptedException {
		AdminLoginPage ad = new AdminLoginPage(driver);
		ad.loginAdmin(email, pass);

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement dashboard = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));

			String actualText = dashboard.getText();

			if (expectedResult.equals("Valid")) {
				Assert.assertEquals(actualText, "Dashboard", "Login successful as expected.");
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			if (expectedResult.equals("Invalid")) {
				Assert.assertTrue(true, "Login failed as expected for invalid credentials.");
			} else {
				Assert.fail();
			}
		}

	}

}
