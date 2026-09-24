package practiceTestng.pTestng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAttempt implements IRetryAnalyzer {

    // 1. Keep counter at the class level so it doesn't reset to 0
    private int retrycount = 0;
    private final int maxcount = 2; // Maximum number of retry attempts

    @Override
    public boolean retry(ITestResult result) {
        // 2. Check if current count is less than maximum allowed attempts
        if (retrycount < maxcount) {
            retrycount++;
            return true; // Tells TestNG to re-run the failed test
        }
        return false; // Tells TestNG to stop retrying
    }
}