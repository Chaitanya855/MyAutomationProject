package org.example.HandlingTable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class HandlingTableTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the page down by 500 pixels
        js.executeScript("window.scrollBy(0,500);");

        Thread.sleep(3000);

        // Scroll the table internally
        js.executeScript(
                "document.querySelector('.tableFixHead').scrollTop=5000"
        );

        // Find all values in the 4th column
        List<WebElement> values =
                driver.findElements(
                        By.cssSelector(".tableFixHead td:nth-child(4)")
                );

        int sum = 0;

        // Add all values
        for (int i = 0; i < values.size(); i++) {

            sum = sum + Integer.parseInt(values.get(i).getText());

        }

        System.out.println("Calculated sum: " + sum);

        // Get total displayed by the website
        String totalText =
                driver.findElement(
                        By.cssSelector(".totalAmount")
                ).getText();

        System.out.println("Website total: " + totalText);

        // Extract number from "Total Amount Collected: 296"
        int total =
                Integer.parseInt(
                        totalText.split(":")[1].trim()
                );

        System.out.println("Expected total: " + total);

        // Compare calculated sum with website total
        Assert.assertEquals(sum, total);

        driver.quit();
    }
}
