package pageObjects.pm.product;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.base.BasePage;
import utilities.WaitHelper;

public class ProductPage extends BasePage {

	WaitHelper wait = new WaitHelper(driver);

	public ProductPage(WebDriver driver) {
		super(driver);

	}

	// Add stationary


	@FindBy(xpath = "//button[text()='Add Product']")
	WebElement btnAddProduct;

	@FindBy(css = "#productname")
	WebElement txtProductname;

	@FindBy(xpath = "(//select[@aria-hidden='true'])[1]")
	WebElement selectStationery;

	@FindBy(css = ".ql-editor")
	WebElement txtDescription;

	@FindBy(xpath = "//input[@id='product-images']")
	WebElement addProductImage;

	@FindBy(xpath = "(//button[@role='combobox' and @data-slot='select-trigger'])[2]")
	WebElement clickItemCategory;

	@FindBy(xpath = "//div[@data-state='open']//span[text()='stationery']")
	WebElement selectStationaryType;

	@FindBy(id = "price")
	WebElement txtPurchaseprice;

	@FindBy(id = "sellingprice")
	WebElement txtSellingPrice;

	@FindBy(css = "[aria-haspopup='dialog']")
	WebElement clickStationaryInstitution;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement btnSave;

	@FindBy(xpath = "(//button[contains(@class,'focus:outline-none')])[2]")
	WebElement actionButton;

	@FindBy(xpath = "(//div[contains(@role,'menuitem')])[3]")
	WebElement deleteButton;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement confirmDeleteButton;

	@FindBy(xpath = "//div[normalize-space()='Edit']")
	WebElement editButton;

	@FindBy(id = "productname")
	WebElement editProductName;

	@FindBy(id = "sellingprice")
	WebElement editSellingPrice;

	@FindBy(id = "price")
	WebElement editPurchasePrice;

	@FindBy(xpath = "//li[contains(@class,'group toast')]//div//div[text()='Product added successfully.']")
	WebElement productAddedSuccessMessage;

	@FindBy(xpath = "//li[contains(@class,'group toast')]//div//div[text()='Product deleted successfully.']")
	WebElement deleteMessage;

	@FindBy(xpath = "//li[contains(@class,'group toast')]//div//div[text()='Successfully logged In']")
	WebElement loginSuccessMessage;

	@FindBy(xpath = "//li[contains(@class,'group toast')]//div//div[text()='Product updated successfully.']")
	WebElement productUpdatedSuccessMessage;

//add uniform

	@FindBy(xpath = "//option[text()='Uniform']")
	WebElement selectUniform;

	@FindBy(xpath = "//input[@id='size-chart-images']")
	WebElement addSizeChart;

	@FindBy(id = "product_video_url")
	WebElement addVideoUrl;

	@FindBy(xpath = "//option[text()='Bombay Dyeing']")
	WebElement selectBrand;

	@FindBy(xpath = "//option[text()='Boys Uniform']")
	WebElement selectItemType;

	@FindBy(css = "[aria-haspopup='dialog']:nth-of-type(1)")
	WebElement clickSizeDropdown;

	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]//span[text()='28']")
	WebElement selectSize;

	@FindBy(xpath = "//option[text()='Male']")
	WebElement selectGender;

	@FindBy(xpath = "//option[text()='Core Uniform']")
	WebElement selectStockCategory;

	@FindBy(xpath = "//option[text()='Middle']")
	WebElement selectGrade;;

	@FindBy(xpath = "(//button[@aria-haspopup='dialog'])[2]")
	WebElement clickInstitutionDropdown;

	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]//span[text()='New Indian Model School, Dubai']")
	WebElement selectInstitution;

// add book

	@FindBy(xpath = "(//button[@role='combobox'])[1]")
	WebElement clickCategoryDropdown;

	@FindBy(xpath = "(//select[@aria-hidden='true'])[1]//option[text()='Book']")
	WebElement selectBook;

	@FindBy(xpath = "//option[text()='Text Book']")
	WebElement selectBookType;

	@FindBy(xpath = "//option[text()='AL MASAR']")
	WebElement selectPublisher;

	@FindBy(xpath = "//option[text()='2025']")
	WebElement editionYear;

	@FindBy(xpath = "//option[text()='Note Book']")
	WebElement selectBookCategory;

	// add stationary
	public void addStationaryProduct(String name, String price) {
		//wait.visibilityOf(loginSuccessMessage, 5);
		driver.navigate().refresh();
		btnAddProduct.click();
		txtProductname.sendKeys(name);
		Select select = new Select(selectStationery);
		select.selectByVisibleText("Stationery");
		txtDescription.click();
		txtDescription.sendKeys(name);

		String src = "/home/docme/Downloads/download.jpeg";
		addProductImage.sendKeys(src);

		clickItemCategory.click();
		selectStationaryType.click();

		txtPurchaseprice.sendKeys(price);
		txtSellingPrice.sendKeys(price);
		clickStationaryInstitution.click();
		btnSave.click();
	}

	public void deleteProduct() {
		//wait.visibilityOf(productAddedSuccessMessage, 5);
		driver.navigate().refresh();
		actionButton.click();
		deleteButton.click();
		confirmDeleteButton.click();

	}

	public String getDeleteMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement msg = wait.until(ExpectedConditions.visibilityOf(deleteMessage));
		return msg.getText();
	}

	public String ProductAddedMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement msg = wait.until(ExpectedConditions.visibilityOf(productAddedSuccessMessage));
		return msg.getText();
	}

	public String loginSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement msg = wait.until(ExpectedConditions.visibilityOf(loginSuccessMessage));
		return msg.getText();
	}

	public String productUpdatedSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement msg = wait.until(ExpectedConditions.visibilityOf(productUpdatedSuccessMessage));
		return msg.getText();
	}

	public void addUniformProduct(String name, String price) {
		wait.visibilityOf(loginSuccessMessage, 5);
		btnAddProduct.click();
		txtProductname.sendKeys(name);
		Select select = new Select(selectStationery);
		select.selectByVisibleText("Uniform");
		txtDescription.click();
		txtDescription.sendKeys(name);

		String src = "/home/docme/Downloads/download (1).jpeg";
		addProductImage.sendKeys(src);

		String src1 = "/home/docme/Downloads/download (2).jpeg";
		addSizeChart.sendKeys(src1);

		addVideoUrl.sendKeys("https://youtube.com/shorts/X5xLb-qrB5w?si=z_fhxBM7U6krFns2");

		selectBrand.click();
		selectItemType.click();
		clickSizeDropdown.click();
		selectSize.click();
		selectGender.click();
		selectStockCategory.click();
		selectGrade.click();

		txtPurchaseprice.sendKeys(price);
		txtSellingPrice.sendKeys(price);
		clickInstitutionDropdown.click();
		selectInstitution.click();
		selectInstitution.click();
		btnSave.click();

	}

	public void editProduct(String name) throws InterruptedException {

		//waitForLoginOrProductAdded();
		driver.navigate().refresh();
		actionButton.click();
		editButton.click();

		wait.elementToBeClickable(editProductName, 5);
		editProductName.click();
		editProductName.sendKeys(Keys.CONTROL + "a");
		editProductName.sendKeys(Keys.DELETE);
		editProductName.sendKeys(name);

		btnSave.click();

	}

	public void waitForLoginOrProductAdded() {

		if (wait.isVisible(loginSuccessMessage, 3)) {
			System.out.println(loginSuccessMessage.getText());
		} else if (wait.isVisible(productAddedSuccessMessage, 3)) {
			System.out.println(productAddedSuccessMessage.getText());
		} else {

		}

	}

}
