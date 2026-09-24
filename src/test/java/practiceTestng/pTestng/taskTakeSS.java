package practiceTestng.pTestng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class taskTakeSS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\kalam\\OneDrive\\Desktop\\PracticeWorkSpace\\"+Math.random()+".png");
		FileHandler.copy(source, destination);
		
		
		//*************Link count****************************
		By linkLocator = By.xpath("//a");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(linkLocator));
		//WebElement el = driver.findElements(linkLocator);
		List<WebElement> al = driver.findElements(linkLocator);
		System.out.println(al.size());
		
		//*************linktext****************************
		driver.get("https://www.amazon.com/");
		
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prime Video")));
		el.click();
		//int count = driver.findElement(By.)
		
		
		driver.quit();
		

	}

}
