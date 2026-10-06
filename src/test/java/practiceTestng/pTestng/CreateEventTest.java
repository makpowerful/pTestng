package practiceTestng.pTestng;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import resources.TestBase;

// REMOVED: "extends TestBase" to follow proper dependency encapsulation
public class CreateEventTest {

    @BeforeMethod(alwaysRun = true)
    public void initialize() throws IOException, InterruptedException {
        // 1. Always load configuration environment state before initializing driver threads
        TestBase.setupEnvironment();
        
        // 2. Initialize the safe Singleton driver assigned uniquely to the executing thread
        TestBase.initializeDriver();
    }

    @Test(groups = { "sanity", "UAT" }, enabled = true)
    public void testCreateEventProcess() throws InterruptedException {
        // 3. Fetch the isolated driver instance for THIS execution thread
        WebDriver driver = TestBase.getDriver();
        
        // 4. Wrap it within a local instance of the PageObjectManager
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        
        // 5. Run workflow linearly using local, thread-safe references
        pageObjectManager.getLoginPage().logIntoApp();
        pageObjectManager.getHomePage().selectManageEvent();
        pageObjectManager.getEventPage().creatingAEvent();
    }
	
    @Test(dataProvider = "data")
    public void testDP(String val){
        System.out.println(val);
    }
	
    @DataProvider(parallel = true) // Set to true to run DataProvider variants concurrently!
    public Object[][] data(){
        return new Object[][] {{"Test1"},{"Test2"}};
    }
	
    @AfterMethod(alwaysRun = true) 
    public void teardown() {
        // 6. Centralized Singleton teardown prevents memory leaks and cleans the thread stream
        TestBase.quitDriver();
    }
}
