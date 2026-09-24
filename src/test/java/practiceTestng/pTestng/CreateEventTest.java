package practiceTestng.pTestng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.eventPO;
import pageObjects.homePO;
import pageObjects.loginPO;
import resources.TestBase;
import utils.testContextSetup;

public class CreateEventTest extends TestBase {
	public WebDriver driver;
	loginPO loginPage;
	homePO homePage;
	eventPO eventPage;
	testContextSetup testContextSetup;

	@BeforeMethod(alwaysRun = true)
	public void initialize() throws IOException, InterruptedException {
        
        // 2. Setup your context wrapper using the active driver
        testContextSetup = new testContextSetup();
        
        // 3. Get your login page object from the manager
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
        homePage = testContextSetup.pageObjectManager.getHomePage();
        eventPage = testContextSetup.pageObjectManager.getEventPage();

	}
	
	//public testCreateEvent(testContextSetup testContextSetup) {
	//	this.testContextSetup=testContextSetup;
    //	this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
	//}

	@Test(groups = { "sanity", "UAT" }, enabled = true)
	public void testCreateEventProcess() throws InterruptedException {
		loginPage.logIntoApp();
		homePage.selectManageEvent();
		eventPage.creatingAEvent();
		
		
	}
	
	@Test(dataProvider = "data")
	public void testDP(String val){
		System.out.println(val);
	}
	
	@DataProvider
	public Object[][] data(){
		return new Object[][] {{"Test1"},{"Test2"}};
		
	}
	
	  @AfterMethod(alwaysRun = true) public void teardown() throws
	  InterruptedException {
	  
		   if (testContextSetup != null && testContextSetup.driver != null) {
		        testContextSetup.driver.quit();
		    }
	  }

}
