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
        // Detects if the current execution is running inside a Jenkins environment
        boolean isJenkins = System.getenv("JENKINS_URL") != null;

        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions op = new ChromeOptions();
            if (isJenkins) {
                op.addArguments("--headless=new"); // Modern headless mode for Chrome
                op.addArguments("--window-size=1920,1080"); // Ensures stable element rendering headless
            } else {
                op.addArguments("--start-maximized");
            }
            driver = new ChromeDriver(op);
            
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions op = new FirefoxOptions();
            if (isJenkins) {
                op.addArguments("--headless");
            } else {
                op.addArguments("--start-maximized");
            }
            driver = new FirefoxDriver(op);
            
        } else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions op = new EdgeOptions();
            if (isJenkins) {
                op.addArguments("--headless");
                op.addArguments("--window-size=1920,1080");
            } else {
                op.addArguments("--start-maximized");
            }
            driver = new EdgeDriver(op);
        }


		return driver;
	}
}
