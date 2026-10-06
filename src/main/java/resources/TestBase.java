package resources;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.cdimascio.dotenv.Dotenv;

public class TestBase {
    public static Dotenv dotenv;
    
    // 1. ThreadLocal container guarantees exactly ONE driver instance per execution thread
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // 2. Private constructor prevents other classes from creating "new TestBase()" instances
    private TestBase() {}

    public static void setupEnvironment() {
        dotenv = Dotenv.configure()
                       .ignoreIfMissing()
                       .load();
    }
	
    // 3. Global Access Point to get the single running driver instance for the thread
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // 4. Initializer method checks if a driver already exists before creating a new one
    public static WebDriver initializeDriver() throws IOException, InterruptedException {
        
        // ONLY initialize if this specific thread doesn't already have an active driver window
        if (tlDriver.get() == null) {
            
            String browserName = System.getProperty("browser");
            if (browserName == null) {
                browserName = "Chrome"; 
            }

            WebDriver localDriver = null;
            String headlessProp = System.getProperty("headless");
            boolean isHeadless = (headlessProp != null) && headlessProp.equalsIgnoreCase("true");

            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions op = new ChromeOptions();
                if (isHeadless) {
                    op.addArguments("--headless=new");
                    op.addArguments("--window-size=1920,1080");
                } else {
                    op.addArguments("--start-maximized");
                }
                localDriver = new ChromeDriver(op);
                
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                FirefoxOptions op = new FirefoxOptions();
                if (isHeadless) {
                    op.addArguments("--headless");
                } else {
                    op.addArguments("--start-maximized");
                }
                localDriver = new FirefoxDriver(op);
                
            } else if (browserName.equalsIgnoreCase("Edge")) {
                EdgeOptions op = new EdgeOptions();
                if (isHeadless) {
                    op.addArguments("--headless");
                    op.addArguments("--window-size=1920,1080");
                } else {
                    op.addArguments("--start-maximized");
                }
                localDriver = new EdgeDriver(op);
            }

            localDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
            
            // Store the newly created driver securely inside the ThreadLocal container
            tlDriver.set(localDriver);
        }
        
        // Return the thread's singleton driver instance
        return tlDriver.get();
    }

    // 5. Unified cleanup method to quit the browser and clear out memory leaks
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove(); // Removes reference from the thread container
        }
    }
}
