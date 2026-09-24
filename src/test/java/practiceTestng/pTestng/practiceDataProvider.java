package practiceTestng.pTestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class practiceDataProvider {

	
	@Test(dataProvider = "data")
	public void testDPAttempt(String val) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://amazon.com");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(val)));
		
		el.click();
		
		driver.close();
		
	}
	
	@DataProvider()
	public Object[][] data(){
		return new Object[][] {{"Prime Video"},{"Customer Service"},{"Today's Deals"}};
	}
}
