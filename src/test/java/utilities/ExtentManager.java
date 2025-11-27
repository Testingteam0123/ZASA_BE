package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
private static ExtentReports extent;
	
	public static ExtentReports extentReport(String reportName)
	{
		String path=System.getProperty("user.dir")+"/test-output/ExtentReport/"+reportName;
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setReportName(reportName);
		reporter.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aromal J C");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Enviroment", "QA");
	
		return extent;
	}

}
