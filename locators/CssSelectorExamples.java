package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorExamples {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        // CSS Selector - Tag and ID
        // driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirts");

        // CSS Selector - Tag and Class
        // driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Pants");

        // CSS Selector - Tag and Attribute
        // driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Shoes");

        // CSS Selector - Tag, Class and Attribute
        driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Gloves");

        // Submit Search
        driver.findElement(By.cssSelector("button.search-box-button")).click();

        driver.quit();
    }
}
