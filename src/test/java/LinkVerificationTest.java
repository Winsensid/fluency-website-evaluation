import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LinkVerificationTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the WebDriver
        driver = new FirefoxDriver();
    }

    @Test
    public void verifyLinks() {
        // Navigate to the Fluency website
        driver.get("https://www.fluency.inc");

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the page: " + links.size());

        // Check if LinkedIn link is present
        boolean foundLinkedIn = false;

        // Loop through each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null && !url.isEmpty()) {
                // Check for LinkedIn link
                if (url.contains("linkedin.com")) {
                    foundLinkedIn = true;
                    // Assertion for LinkedIn
                    int status = checkLinkStatus(url);
                    System.out.println(url + " - Status Code: " + status);
                    Assert.assertEquals(status, 999, "LinkedIn link status is incorrect (expected 999 due to anti-bot measures)");
                } else {
                    // Assertion for other links
                    int status = checkLinkStatus(url);
                    System.out.println(url + " - Status Code: " + status);
                    Assert.assertEquals(status, 200, "Link " + url + " is broken");
                }
            }
        }

        // If LinkedIn link is found, make a note
        if (!foundLinkedIn) {
            System.out.println("LinkedIn link not found on the page.");
        }
    }

    // Method to check the status of the link
    public int checkLinkStatus(String linkUrl) {
        try {
            // Create URL object
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Get the response code
            return connection.getResponseCode();

        } catch (IOException e) {
            return 999;  // Return 999 in case of an error, like anti-automation blocking
        }
    }

    @AfterTest
    public void tearDown() {
        // Closing the driver
        driver.quit();
    }
}
