package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	public WebDriver WebDriverManager() throws IOException, InterruptedException {
        // Reads browser value from Jenkins/Maven command flag (-Dbrowser)
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            browserName = "Chrome"; // Fallback default for running locally in Eclipse
        }

        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions op = new ChromeOptions();
            op.addArguments("--start-maximized");
            driver = new ChromeDriver(op);
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions op = new FirefoxOptions();
            op.addArguments("--start-maximized");
            driver = new FirefoxDriver(op);
        } else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions op = new EdgeOptions();
            op.addArguments("--start-maximized");
            driver = new EdgeDriver(op);
        }

		return driver;
	}
}
