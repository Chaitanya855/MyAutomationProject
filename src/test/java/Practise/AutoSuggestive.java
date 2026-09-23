package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestive {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys(("uni"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("United Kingdom (UK)")) {
                option.click();
                break;
            }
        }
    }
}
