package org.example.BrokenLinks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksTest {
    public static void main(String[] args)
            throws IOException, URISyntaxException {

        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Get all links
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            HttpURLConnection conn =
                    (HttpURLConnection) new URI(url).toURL().openConnection();

            conn.setRequestMethod("HEAD");

            conn.connect();

            int respCode = conn.getResponseCode();

            System.out.println(respCode);

            a.assertTrue(
                    respCode < 400,
                    "The link with Text "
                            + link.getText()
                            + " is broken with code "
                            + respCode
            );
        }

        a.assertAll();

        driver.quit();
    }
}
