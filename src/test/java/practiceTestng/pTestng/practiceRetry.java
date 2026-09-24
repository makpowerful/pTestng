package practiceTestng.pTestng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class practiceRetry extends retryAttempt{
	
	
@Test(retryAnalyzer = practiceTestng.pTestng.retryAttempt.class)
public void testRetry() {
	ChromeOptions op = new ChromeOptions();
	op.addArguments("--start-maximized");
	
	WebDriver driver = new ChromeDriver(op);
	driver.get("https://www.facebook.com");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("Test1");
	driver.findElement(By.xpath("//input[@name = 'pass']")).sendKeys("Test1");
	driver.findElement(By.xpath("//div[@aria-label='Log in']")).click();
	
	WebElement profileSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kalam Shabaz']")));

	
	Assert.assertTrue(false);
    driver.quit(); 
}
	
	
	

}
