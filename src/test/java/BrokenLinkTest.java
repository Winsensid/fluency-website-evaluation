import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLinks() {
        // Go to the Passes website
        driver.get("https://www.passes.com");

        // Collect all links, scripts, and images
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        List<WebElement> allScripts = driver.findElements(By.tagName("script"));
        List<WebElement> allImages = driver.findElements(By.tagName("img"));

        List<String> allUrls = new ArrayList<>();

        // Collect links (href attributes)
        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                allUrls.add(url);
            }
        }

        // Collect scripts (src attributes)
        for (WebElement script : allScripts) {
            String url = script.getAttribute("src");
            if (url != null && !url.isEmpty()) {
                allUrls.add(url);
            }
        }

        // Collect images (src attributes)
        for (WebElement img : allImages) {
            String url = img.getAttribute("src");
            if (url != null && !url.isEmpty()) {
                allUrls.add(url);
            }
        }

        // Print totals
        System.out.println("Total Links Found: " + allLinks.size());
        System.out.println("Total Scripts Found: " + allScripts.size());
        System.out.println("Total Images Found: " + allImages.size());

        // Check each link
        int brokenLinksCount = 0;
        for (String url : allUrls) {
            if (!isLinkValid(url)) {
                System.out.println("Broken link: " + url);
                brokenLinksCount++;
            }
        }

        System.out.println("Total Broken Links: " + brokenLinksCount);

        // Assert that no broken links are found (optional)
        Assert.assertEquals(brokenLinksCount, 0, "There are broken links on the page.");
    }

    // Method to check if a link is valid
    private boolean isLinkValid(String url) {
        // Ignore mailto links
        if (url != null && url.startsWith("mailto:")) {
            return true;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            connection.disconnect();

            return responseCode == 200;
        } catch (Exception e) {
            return false;
        }
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
