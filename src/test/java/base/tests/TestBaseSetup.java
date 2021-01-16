package base.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.utility.Reporter;

public class TestBaseSetup {
	
	WebDriver driver;
	Reporter reporter;	
	
	public TestBaseSetup() {
		setdriver(2);
		reporter = new Reporter();
	}
	
	public void setdriver(int id) {
		if(id==1) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_proj\\jantest\\src\\test\\resources\\drivers\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_proj\\jantest\\src\\test\\resources\\drivers\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("marionette", true);
			driver = new ChromeDriver();
		}
	}

	
}
