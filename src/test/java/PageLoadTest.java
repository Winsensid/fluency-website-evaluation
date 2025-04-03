
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageLoadTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the WebDriver
        driver = new FirefoxDriver();
    }

    @Test
    public void measurePageLoadTime() {
        // Start page load time tracking
        long startTime = System.currentTimeMillis();

        // Navigate to the Fluency website
        driver.get("https://www.fluency.inc");

        // Calculate page load time
        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
        System.out.println("Page load time: " + loadTime + " milliseconds");

        // Assert that the page load time is within a reasonable limit (e.g., 5 seconds)
        Assert.assertTrue(loadTime < 5000, "Page load time exceeds 5 seconds!");
    }

    @AfterTest
    public void tearDown() {
        // Closing the driver
        driver.quit();
    }
}
