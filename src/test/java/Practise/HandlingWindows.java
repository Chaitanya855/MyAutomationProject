package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {
    public  static void main (String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        String parentwindow =  driver.getWindowHandle();
        for (String childwindow : driver.getWindowHandles()){
            if(!childwindow.equals(parentwindow))
            {
                driver.switchTo().window(childwindow);
                System.out.println(driver.findElement(By.tagName("h3")).getText());
                driver.close();

            }
        }
        driver.switchTo().window(parentwindow);
        System.out.println(driver.findElement(By.tagName("h3")).getText());



    }
}
