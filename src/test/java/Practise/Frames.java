package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
    public  static void main (String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.linkText("Nested Frames")).click();

        WebElement TopFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(TopFrame);


        WebElement MiddleFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(MiddleFrame);

        String text = driver.findElement(By.id("content")).getText();
        System.out.println(text);


    }
}
