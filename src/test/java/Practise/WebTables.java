package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTables {
    public  static void main (String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> rows = driver.findElements(By.xpath("//fieldset[legend[normalize-space()='Web Table Example']]//table[@id='product']/tbody/tr"));
        System.out.println("Rows: " + rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
        System.out.println("Columns: " + columns.size());

        List<WebElement> secondRow = driver.findElements(By.xpath("//fieldset[legend[normalize-space()='Web Table Example']]//table[@id='product']/tbody/tr[3]/td"));

        for (WebElement cell : secondRow) {
            System.out.println(cell.getText());
        }





    }
}
