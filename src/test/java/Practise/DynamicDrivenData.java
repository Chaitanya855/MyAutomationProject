package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicDrivenData {
    public  static void main (String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkBoxOption2")));
        checkbox.click();
        
        String optiontext = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
        System.out.println(optiontext);

        WebElement drpdownlist = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select drpdownoptions=new Select(drpdownlist);
        drpdownoptions.selectByValue(optiontext);

        driver.findElement(By.id("name")).sendKeys(optiontext);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());



    }
}
