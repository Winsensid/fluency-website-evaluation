import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SEOTests {
    @Test
    public void seoTest() {


        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://www.passes.com");

            // Get title
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);

            // Get meta description
            String metaDescription = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
            System.out.println("Meta Description: " + metaDescription);

            // Get Open Graph image (og:image)
            String ogImage = "";
            try {
                ogImage = driver.findElement(By.xpath("//meta[@property='og:image']")).getAttribute("content");
                System.out.println("Open Graph Image (og:image): " + ogImage);
            } catch (Exception e) {
                System.out.println("Open Graph Image (og:image) not found.");
            }

            // Try to get meta keywords (with null check)
            String metaKeywords = "";
            try {
                metaKeywords = driver.findElement(By.xpath("//meta[@name='keywords']")).getAttribute("content");
                System.out.println("Meta Keywords: " + metaKeywords);
            } catch (Exception e) {
                System.out.println("Meta Keywords not found.");
            }

        } catch (Exception e) {
            System.out.println("Error while checking SEO: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
