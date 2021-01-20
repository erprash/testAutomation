package test.java.base.utility;

import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Reporter {

	public ExtentReports report  = new ExtentReports("D:\\Selenium_result\\ExtentReportResults.html", true); ;
	public HashMap<String, ExtentTest> tests = new HashMap <String, ExtentTest>();
	
	public void startTest(String testName) {
		System.out.println("starting test :" + testName);
		tests.put(testName, report.startTest(testName));

	}
	
	public void endTest(String testName) {
		System.out.println("Closing test :" + testName);
		report.endTest(tests.get(testName));
		report.flush();
	}
	
	public void endReport () {
		
		try {
			System.out.println("closing report");
			
			report.close();
			System.out.println("closed report");
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:\\Selenium_result\\" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	public void log(String testName, String status, String message) {
		LogStatus lgStatus = null;
		
		switch (status) {
			case "Pass" :
				lgStatus = LogStatus.PASS; break;
			case "Fail" : 
				lgStatus = LogStatus.FAIL; break;
			case "Info" :
				lgStatus = LogStatus.INFO; break;
			case "Skip" : 
				lgStatus = LogStatus.SKIP; break;
		}
		tests.get(testName).log(lgStatus, testName, message);
	}


	
		
}
