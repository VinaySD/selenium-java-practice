package selenium.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement button = driver.findElement(
                By.xpath("//span[@class='context-menu-one btn btn-neutral']")
        );

        Actions actions = new Actions(driver);

        // Build the action and store it
        Action rightClick = actions.contextClick(button).build();

        // Execute the action
        rightClick.perform();

        driver.quit();
    }
}