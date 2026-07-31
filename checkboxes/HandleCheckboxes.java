package selenium.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleCheckboxes {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        // Select All Checkboxes
        /*
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        */

        // Select Last 3 Checkboxes
        /*
        for (int i = checkboxes.size() - 3; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        */

        // Unselect Checked Checkboxes
        /*
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        */

        driver.quit();
    }
}