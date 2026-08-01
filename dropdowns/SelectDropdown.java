package selenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropdown {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement country = driver.findElement(By.id("country"));

        Select select = new Select(country);

        // Select by Visible Text
        // select.selectByVisibleText("India");

        // Select by Value
        // select.selectByValue("uk");

        // Select by Index
        select.selectByIndex(1);

        List<WebElement> options = select.getOptions();

        System.out.println("Total Options : " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}