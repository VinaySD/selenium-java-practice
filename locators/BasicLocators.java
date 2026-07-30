package Selenium.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BasicLocators {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        // Name Locator

        // ID Locator
        boolean logoDisplayStatus = driver.findElement(By.id("logo-icon")).isDisplayed();
        System.out.println("Logo Displayed: " + logoDisplayStatus);

        // Submit
        driver.findElement(By.name("search_query")).submit();

        // Link Text Locator (Example)
        // driver.findElement(By.linkText("Shorts")).click();

        // Partial Link Text Locator (Example)
        // driver.findElement(By.partialLinkText("Short")).click();

        // Tag Name Locator
        List<WebElement> headerLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Header Links: " + headerLinks.size());

        // Class Name Locator (Example)
        // WebElement searchBox = driver.findElement(By.className("ytSearchboxComponentInput"));
        // searchBox.clear();

        driver.quit();
    }
}