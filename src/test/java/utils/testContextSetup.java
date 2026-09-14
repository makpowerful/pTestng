package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObjects.pageObjectManager;
import resources.GenericUtils;
import resources.TestBase;

public class testContextSetup {
	public WebDriver driver;
	public pageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public testContextSetup() throws IOException, InterruptedException
	{
		testBase = new TestBase();
        // 1. Initialize the driver variable once
        driver = testBase.WebDriverManager(); 
     // Save the driver instance into TestNG's internal context memory
        org.testng.Reporter.getCurrentTestResult().getTestContext().setAttribute("WebDriver", driver);

        // 2. Pass the SAME driver instance to the managers
        pageObjectManager = new pageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
		
		
		

	}
}
