package test.java.base.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.java.base.utility.Reporter;

public class TestBaseSetup {
	
	WebDriver driver;
	Reporter reporter;	
	
	
	public TestBaseSetup() {
		reporter = new Reporter();
	}
	
	
	public WebDriver setdriver(int id) {
		if(id==1) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
			return driver;
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("marionette", true);
			driver = new ChromeDriver();
			return driver;
		}
	}

	
}
