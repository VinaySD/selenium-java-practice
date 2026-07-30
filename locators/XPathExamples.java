package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathExamples {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        // XPath with Single Attribute
        // driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("T-Shirts");

        // XPath with Multiple Attributes
        // driver.findElement(By.xpath("//input[@id='small-searchterms'][@placeholder='Search store']")).sendKeys("Shoes");

        // XPath using AND Operator
        // driver.findElement(By.xpath("//input[@id='small-searchterms' and @placeholder='Search store']")).sendKeys("Laptop");

        // XPath using OR Operator
        // driver.findElement(By.xpath("//input[@id='small-searchterms' or @placeholder='Search store']")).sendKeys("Mobile");

        // XPath using text()
        driver.findElement(By.xpath("//*[text()='Books']")).click();

        driver.quit();
    }
}