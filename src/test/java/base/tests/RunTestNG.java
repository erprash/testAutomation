package test.java.base.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.java.base.utility.*;
public class RunTestNG {
	
	
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public void startClass()
	{
		report = new ExtentReports("D:\\Selenium_proj\\jantest\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
				//reporter = new Reporter();
	}
	
	
/*	@BeforeTest
	public void beforeTest() {
		reporter = new Reporter();
		test = reporter.startTest("ExtentDemo");
		
	}*/
	
	@Test(priority=1)
	public void scenario1()
	{
		//Assert.assertEquals(10, 20);
		System.out.println("Test1");
		test.log(LogStatus.PASS, "Test1 giving proper results");
		
		
	}
	
	@Test(priority=3)
	public void scenario2() throws IOException
	{
		WebDriver driver;
		Reporter repo1 = new Reporter();
		System.out.println("Test2");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_proj\\jantest\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.co.in");
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(repo1.capture(driver))+ "Test Failed");
			System.out.println("fail");
		}
		else
		{
				System.out.println("Not Fail");
		}
		
		
	}
	
	@Test(priority=2)
	public void scenario3()
	{
		System.out.println("Test3");
		test.log(LogStatus.PASS, "Test3 done");
		
		
	}
	
/*	@AfterTest
	public void afterTest() {
		reporter.endTest("ExtentDemo");
	}
	*/
	
	@AfterClass
	public void endClass()
	{
		report.endTest(test);
		report.flush();
		
		//method to call jira , attache this report
		
		
	}
	
	
}
