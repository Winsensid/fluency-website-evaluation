import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebsiteInfo {
    public static void main(String[] args) {
        // Set up the WebDriver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the Fluency website
        driver.get("https://www.fluency.inc");

        // Get the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links on the page: " + links.size());

        // List out all the link URLs
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                System.out.println("Link: " + url);
            }
        }

        // Closing the driver
        driver.quit();
    }
}
