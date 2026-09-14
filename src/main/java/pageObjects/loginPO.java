package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.TestBase;

public class loginPO extends TestBase{
	public WebDriver driver;
	public WebDriverWait wait;
	private By usernameTextBoxLocator = By.id("email");
	private By passwordTextBoxLocator = By.id("password");
	private By signInButtonLocator = By.xpath("//button[@type='submit']");
	
	//Declaring Constructor
	public loginPO(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void logIntoApp() {
		driver.get("https://eventhub.rahulshettyacademy.com/login");
		WebElement usernameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
		usernameTextBox.sendKeys("mak_powerful@yahoo.co.in");
		
		WebElement passwordTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
		passwordTextBox.sendKeys("Arthas1@3");
		
		WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signInButtonLocator));
		signInButton.click();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "EventHub — Discover & Book Events");
	}
	
	

	


	
	

}
