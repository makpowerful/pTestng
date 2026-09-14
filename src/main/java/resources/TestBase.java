package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public WebDriver WebDriverManager() throws IOException, InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(op);
		return driver;
	}
}
