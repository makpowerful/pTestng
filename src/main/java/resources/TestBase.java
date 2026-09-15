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
        // Reads the headless property from the Maven flag (-Dheadless)
        String headlessProp = System.getProperty("headless");
        
        // Convert to boolean. Default to false if running locally in Eclipse (so it is always headed locally)
        boolean isHeadless = (headlessProp != null) && headlessProp.equalsIgnoreCase("true");

        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions op = new ChromeOptions();
            if (isHeadless) {
                op.addArguments("--headless=new");
                op.addArguments("--window-size=1920,1080");
            } else {
                op.addArguments("--start-maximized");
            }
            driver = new ChromeDriver(op);
            
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions op = new FirefoxOptions();
            if (isHeadless) {
                op.addArguments("--headless");
            } else {
                op.addArguments("--start-maximized");
            }
            driver = new FirefoxDriver(op);
            
        } else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions op = new EdgeOptions();
            if (isHeadless) {
                op.addArguments("--headless");
                op.addArguments("--window-size=1920,1080");
            } else {
                op.addArguments("--start-maximized");
            }
            driver = new EdgeDriver(op);
        }


     // Add this line right before "return driver;" at the bottom of WebDriverManager()
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));

		return driver;
	}
}
