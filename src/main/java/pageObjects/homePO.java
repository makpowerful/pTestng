package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePO {
	public WebDriver driver;
	public WebDriverWait wait;
	private By homepageHeaderLinksLocator = By.xpath("//div[contains(@class,'flex items-center')]//*[text()='Admin']");
	private By adminManageLinkLocator = By.xpath("//div[contains(@class,'absolute')]//a[text()='Manage Events']");

	
	//Declaring Constructor
	public homePO(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void selectManageEvent() {
		WebElement headerLinks = wait.until(ExpectedConditions.visibilityOfElementLocated(homepageHeaderLinksLocator));
		headerLinks.click();
		WebElement adminManageLink = wait.until(ExpectedConditions.visibilityOfElementLocated(adminManageLinkLocator));
		adminManageLink.click();
	}
	
}
