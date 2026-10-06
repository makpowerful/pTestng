package practiceTestng.pTestng;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testOpenNewWindow {

	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(op);
		
		driver.get("https://www.linkedin.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Top Content')]")));
		
		WebElement el = driver.findElement(By.xpath("//span[contains(text(),'Top Content')]"));
		//el.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.CONTROL).click(el).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i = s1.iterator();
		String window1 = i.next();
		String window2 = i.next();
		
		driver.switchTo().window(window2);
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.switchTo().window(window1);
		title = driver.getTitle();
		System.out.println(title);
		
		
		
		
		
	

	}

}
