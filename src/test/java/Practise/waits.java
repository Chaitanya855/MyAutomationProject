package Practise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class waits {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");


        WebElement user = driver.findElement(By.xpath("//label[.//span[normalize-space()='User']]"));
        user.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
        okButton.click();

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control']")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Consultant");


        driver.findElement(By.id("terms")).click();

        driver.findElement(By.id("signInBtn")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> products = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for (WebElement product : products)
        {
            product.click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }
}
