import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PageLoadTest {
    @Test
    public void pageLoadTimeTest() {
        // Set up the ChromeDriver (make sure the path is correct)

        WebDriver driver = new FirefoxDriver();
        long startTime = System.nanoTime(); // Record start time

        try {
            driver.get("https://www.passes.com");

            // Wait until the page loads completely (simple way, better to use explicit waits in real cases)
            while (true) {
                if (driver.getTitle() != null && !driver.getTitle().isEmpty()) {
                    break; // Page has loaded
                }
            }

            long endTime = System.nanoTime(); // Record end time
            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            System.out.println("Page load time: " + duration + " ms");

        } catch (Exception e) {
            System.out.println("Error while loading the page: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
