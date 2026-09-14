package practiceTestng.pTestng;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class testRough {
	public static By tag = By.tagName("html");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(op);
		
		wd.get("https://eventhub.rahulshettyacademy.com/login");
		
		WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(10));
		
		By usernameTextBoxLocator = By.id("email");
		WebElement usernameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
		usernameTextBox.sendKeys("mak_powerful@yahoo.co.in");
		
		By passwordTextBoxLocator = By.id("password");
		WebElement passwordTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
		passwordTextBox.sendKeys("Arthas1@3");
		
		By signInButtonLocator = By.xpath("//button[@type='submit']");
		WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signInButtonLocator));
		signInButton.click();
		
		String pageTitle = wd.getTitle();
		System.out.println(pageTitle);
		
		Assert.assertEquals(pageTitle, "EventHub — Discover & Book Events");
		
		By homepageHeaderLinksLocator = By.xpath("//div[contains(@class,'flex items-center')]//*[text()='Admin']");
		WebElement headerLinks = wait.until(ExpectedConditions.visibilityOfElementLocated(homepageHeaderLinksLocator));
		headerLinks.click();
			
		
		By adminManageLinkLocator = By.xpath("//div[contains(@class,'absolute')]//a[text()='Manage Events']");
		WebElement adminManageLink = wait.until(ExpectedConditions.visibilityOfElementLocated(adminManageLinkLocator));
		adminManageLink.click();
		
		By newEventHeaderLocator = By.xpath("//h2[contains(text(),'New Event')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(newEventHeaderLocator));
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		String title = "Test Event "+currentDateTime;
		By titleEventTextBoxLocator = By.id("event-title-input");
		WebElement titleEventTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(titleEventTextBoxLocator));
		titleEventTextBox.sendKeys(title);
		
		
		By descriptionTextAreaLocator = By.xpath("//textarea[@placeholder='Describe the event…']");
		WebElement descriptionTextArea = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionTextAreaLocator));
		descriptionTextArea.sendKeys("Test Description "+currentDateTime);
		
		
		By categoryDropdownLocator = By.cssSelector("#category");
		WebElement categoryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdownLocator));
		Select s = new Select(categoryDropdown);
		s.selectByValue("Concert");
		
		By cityEventTextBoxLocator = By.id("city");
		WebElement cityEventTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(cityEventTextBoxLocator));
		cityEventTextBox.sendKeys("Bengaluru");
		
		By venueTextBoxLocator = By.id("venue");
		WebElement venueTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(venueTextBoxLocator));
		venueTextBox.sendKeys("Test Address");
		
		By eventDatePickerLocator = By.id("event-date-&-time");
		WebElement eventDatePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(eventDatePickerLocator));
		eventDatePicker.sendKeys("20-09-2026",Keys.TAB,"1111");
		
		//Actions ac = new Actions(wd);
		//ac.click(eventDatePicker).sendKeys("01","12","2026");
		
		By priceTextBoxLocator = By.id("price-($)");
		WebElement priceTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(priceTextBoxLocator));
		priceTextBox.sendKeys("100.10");
		
		By totalSeatTextBoxLocator = By.id("total-seats");
		WebElement totalSeatTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(totalSeatTextBoxLocator));
		totalSeatTextBox.sendKeys("5");
		
		wd.findElement(By.xpath("//label[text()='Image URL (optional)']")).click();
		wd.findElement(tag).sendKeys(Keys.PAGE_DOWN);
		
		By addEventButtonLocator = By.xpath("//button[@type='submit']");
		WebElement addEventButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addEventButtonLocator));
		addEventButton.click();
		
		//tr[@id='event-table-row']//span[text()='Test Event Sep 13 22 42']
		By eventCreationRowLocator = By.xpath("//tr[@id='event-table-row']//span[text()='"+title+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventCreationRowLocator));
		
		wd.quit();
		
	}

}
