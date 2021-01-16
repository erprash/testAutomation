package base.tests;

public class CommonSteps {
	TestBaseSetup testBaseSetup ;
	
	public void testCaseStart() {
		testBaseSetup = new TestBaseSetup();
	}
	
	public void launchurl(String url) throws Throwable {
		testBaseSetup.driver.get(url);
		// Print a Log In message to the screen
		  System.out.println("Successfully opened the website " + url);
		 //Wait for 5 Sec
		 Thread.sleep(5000);
	}
	
	public void closeBrower() {
       // Close the driver
		testBaseSetup.driver.close();
	}
	
	public static void main () {
		System.out.println("Hi");
	}
	
}
