package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class FillForm {
    public static void main(String[] args) {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://rahulshettyacademy.com/angularpractice/");



    driver.findElement(By.name("name")).sendKeys("Dhanush");
    driver.findElement(By.name("email")).sendKeys("mallemchaitanya12@gmail.com");
    driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");

    driver.findElement((By.id("exampleCheck1"))).click();

    WebElement dropdown =  driver.findElement((By.xpath("//select[@id='exampleFormControlSelect1']")));
    Select select = new Select(dropdown);
    select.selectByVisibleText("Female");


    driver.findElement((By.id("inlineRadio2"))).click();
    driver.findElement(By.name("bday")).sendKeys("16041999");

    driver.findElement((By.xpath("//input[@value='Submit']"))).click();

    String ActualText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
    ActualText = ActualText.split("!", 2)[1].trim();
    System.out.println(ActualText);

    String ExpectedText ="The Form has been submitted successfully!.";

   Assert.assertEquals(ActualText,ExpectedText);


}
}
