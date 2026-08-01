package selenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BootstrapDropdown {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Replace with your Bootstrap dropdown demo website
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        // Open dropdown
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

        // Select option
        driver.findElement(By.xpath("//label[contains(.,'Java')]")).click();

        // Print all options
        List<WebElement> options =
                driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//label"));

        System.out.println("Total Options : " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}