package utils;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;
import resources.GenericUtils;
import resources.TestBase;

public class testContextSetup {
    
    // Made variables final to ensure they cannot be mutated mid-thread execution
    public final WebDriver driver;
    public final PageObjectManager pageObjectManager;
    public final GenericUtils genericUtils;
	
    public testContextSetup() throws IOException, InterruptedException {
        // 1. Setup global configurations safely
        TestBase.setupEnvironment();
        
        // 2. Thread-Safe Singleton Access: Fetch or create the dedicated driver for THIS thread
        this.driver = TestBase.initializeDriver(); 
        
        // 3. Save the unique driver instance into TestNG's context engine (for listeners/screenshots)
        if (org.testng.Reporter.getCurrentTestResult() != null) {
            org.testng.Reporter.getCurrentTestResult().getTestContext().setAttribute("WebDriver", this.driver);
        }

        // 4. Instantiate contextual managers with the thread's isolated driver reference
        this.pageObjectManager = new PageObjectManager(this.driver);
        this.genericUtils = new GenericUtils(this.driver);
    }
}
