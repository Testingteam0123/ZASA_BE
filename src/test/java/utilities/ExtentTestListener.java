package utilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import tests.baseclass.BaseTest;

public class ExtentTestListener  implements ITestListener{

	ExtentTest test;
	ExtentReports extent;
	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	 public static ExtentTest getTest() {
	        return extentTest.get();
	    }
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		 Object testClass = result.getInstance();
	     WebDriver driver = ((BaseTest) testClass).driver;
        String path = BaseTest.takeScreenShot(driver, result.getMethod().getMethodName());
        try {
        	extentTest.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		String suiteName = context.getSuite().getName();
		String reportName;
		if (suiteName.equalsIgnoreCase("Default Suite")) {
		 reportName=context.getAllTestMethods()[0].getRealClass().getSimpleName()+"_Report.html";;
		}
		else {
			reportName=suiteName + "_Report.html";
		}
		extent= ExtentManager.extentReport(reportName);
		
		
	}	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
