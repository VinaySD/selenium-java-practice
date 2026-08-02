package selenium.windowstabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class OpenTheLinkInNewTab {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement regLink = driver.findElement(
                By.xpath("//a[normalize-space()='Register']")
        );

        Actions act = new Actions(driver);

        // Ctrl + Click on Register link
        act.keyDown(Keys.CONTROL)
                .click(regLink)
                .keyUp(Keys.CONTROL)
                .perform();

        // Switching to Registration page
        List<String> ids = new ArrayList<>(driver.getWindowHandles());

        // Registration Page
        driver.switchTo().window(ids.get(1));
        driver.findElement(By.xpath("//input[@id='FirstName']"))
                .sendKeys("John KENEDY");

        // Home Page
        driver.switchTo().window(ids.get(0));
        driver.findElement(By.xpath("//input[@id='small-searchterms']"))
                .sendKeys("TShirts");

        driver.quit();
    }
}