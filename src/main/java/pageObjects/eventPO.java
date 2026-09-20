package pageObjects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eventPO {
	public WebDriver driver;
	public WebDriverWait wait;
	public static By tag = By.tagName("html");
	private By newEventHeaderLocator = By.xpath("//h2[contains(text(),'New Event')]");
	private By titleEventTextBoxLocator = By.id("event-title-input");
	private String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));;
	private String title = "Test Event " + timestamp;
	private By descriptionTextAreaLocator = By.xpath("//textarea[@placeholder='Describe the event…']");
	private By categoryDropdownLocator = By.cssSelector("#category");
	private By cityEventTextBoxLocator = By.id("city");
	private By venueTextBoxLocator = By.id("venue");
	private By eventDatePickerLocator = By.id("event-date-&-time");
	private By priceTextBoxLocator = By.id("price-($)");
	private By totalSeatTextBoxLocator = By.id("total-seats");
	private By addEventButtonLocator = By.xpath("//button[@type='submit']");

	// Declaring Constructor
	public eventPO(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void creatingAEvent() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newEventHeaderLocator));

		WebElement titleEventTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(titleEventTextBoxLocator));
		titleEventTextBox.sendKeys(title);

		WebElement descriptionTextArea = wait
				.until(ExpectedConditions.visibilityOfElementLocated(descriptionTextAreaLocator));
		descriptionTextArea.sendKeys("Test Description " + timestamp);

		WebElement categoryDropdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdownLocator));
		Select s = new Select(categoryDropdown);
		s.selectByValue("Concert");

		WebElement cityEventTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(cityEventTextBoxLocator));
		cityEventTextBox.sendKeys("Bengaluru");

		WebElement venueTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(venueTextBoxLocator));
		venueTextBox.sendKeys("Test Address");

		WebElement eventDatePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(eventDatePickerLocator));
		eventDatePicker.sendKeys("20-09-2026", Keys.TAB, "1111");

		// Actions ac = new Actions(wd);
		// ac.click(eventDatePicker).sendKeys("01","12","2026");

		WebElement priceTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(priceTextBoxLocator));
		priceTextBox.sendKeys("100.10");

		WebElement totalSeatTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(totalSeatTextBoxLocator));
		totalSeatTextBox.sendKeys("5");

		//driver.findElement(By.xpath("//label[text()='Image URL (optional)']")).click();
		driver.findElement(tag).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1200);
		driver.findElement(tag).sendKeys(Keys.PAGE_DOWN);

		WebElement addEventButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addEventButtonLocator));
		addEventButton.click();

		// tr[@id='event-table-row']//span[text()='Test Event Sep 13 22 42']
		By eventCreationRowLocator = By.xpath("//tr[@id='event-table-row']//span[text()='" + title + "']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eventCreationRowLocator));

	}

}
