package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxTest {
    public static void main(String[] args){


        //Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
       WebDriver driver = new ChromeDriver();
       driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());


        WebElement checkbox2 = driver.findElement(By.id("checkBoxOption2"));
        checkbox2.click();
        System.out.println(checkbox2.isSelected());
        checkbox2.click();
        System.out.println(checkbox2.isSelected());

        WebElement checkbox3 = driver.findElement(By.id("checkBoxOption3"));
        checkbox3.click();
        System.out.println(checkbox3.isSelected());
        checkbox3.click();
        System.out.println(checkbox3.isSelected());


        //Count of number of check boxes present in the page
        List<WebElement> checkboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkboxes.size());

        driver.quit();
    }


}
