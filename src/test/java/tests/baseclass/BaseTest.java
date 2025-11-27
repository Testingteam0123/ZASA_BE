package tests.baseclass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import pageObjects.auth.adminLoginPage.AdminLoginPage;


public class BaseTest {
	
	public  WebDriver driver;
	protected Properties p;
	
	@BeforeClass
	public void setup() throws IOException {
		p = new Properties();
		FileReader file = new FileReader(
				System.getProperty("user.dir") + "/src/main/resources/resources/config.properties");
		p.load(file);

		String browser = p.getProperty("browser");
		String url = p.getProperty("url");

		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		AdminLoginPage login = new AdminLoginPage(driver);
	    login.loginAdmin(p.getProperty("adminEmail"), p.getProperty("adminPassword"));
	}
	
	public static String takeScreenShot(WebDriver driver, String testName)
	{
		String timestamp= new SimpleDateFormat("ddMMyyyy_HH-mm-ss").format(new Date());
		
		String folderPath = System.getProperty("user.dir") + "/test-output/Screenshots/";
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
		
	    String filePath = folderPath + testName + "_" + timestamp + ".png";
		
		 try {
		        FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(filePath));
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return filePath;
	}
	
	
	
	//@AfterClass
	public void dropdown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
