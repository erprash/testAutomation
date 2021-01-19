package test.java.base.utility;

import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import base.tests.TakesScreenshot;

public class Reporter {

	public ExtentReports report;
	public ExtentTest test;
	/*
	public Reporter(String testName) {
		report = new ExtentReports("D:\\Selenium_proj\\jantest\\ExtentReportResults.html");
	}
	*/
	
	public ExtentTest startTest(String testName) {
			return test = report.startTest(testName);
	}


	public void endTest(String testName) {
		report.endTest(test);
	}
	
	public String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:\\Selenium_proj\\jantest" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
		
	
		
}
