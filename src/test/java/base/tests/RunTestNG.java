package test.java.base.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.base.utility.*;

public class RunTestNG {

	public TestBaseSetup testBaseSetup;

	public int i = 0;

	@BeforeSuite
	public void startsuit() {
		testBaseSetup = new TestBaseSetup();
	}

	@BeforeMethod
	public void beforeTest() {
		i++;
		testBaseSetup.reporter.startTest("ExtentDemo" + i);
	}

	@Test(priority = 1)
	public void scenario1() {
		// Assert.assertEquals(10, 20);
		System.out.println("Test1 Pass");
		testBaseSetup.reporter.log("ExtentDemo" + i, "Pass", "Test1 giving proper results");
	}

	@Test(priority = 3)
	public void scenario2() throws IOException {
		WebDriver driver;
		// Reporter repo1 = new Reporter();
		System.out.println("Test2");
		TestBaseSetup baseObject = new TestBaseSetup();
		driver = baseObject.setdriver(0);
		driver.get("http://google.co.in");
		if (driver.getTitle().equals("Google")) {
			String path = testBaseSetup.reporter.capture(driver);
			testBaseSetup.reporter.log("ExtentDemo" + i, "Fail", path + "Test Failed");
			System.out.println("fail");
		} else {
			System.out.println("Not Fail");
			testBaseSetup.reporter.log("ExtentDemo" + i, "Pass", "Test2 giving proper results");
		}
	}

	@Test(priority = 2)
	public void scenario3() {
		System.out.println("Test3 Pass");
		testBaseSetup.reporter.log("ExtentDemo" + i, "Pass", "Test3 Done");
	}

	@AfterMethod
	public void afterTest() {
		testBaseSetup.reporter.endTest("ExtentDemo" + i);
	}

	@AfterSuite
	public void endClass() throws Exception {
		testBaseSetup.reporter.endReport();
		testBaseSetup.driver.close();
		// CmdTest.run("taskkill /f /im chromedr*");

	}

}
