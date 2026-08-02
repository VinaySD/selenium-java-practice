package selenium.autosuggestdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdown {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("selenium");

        Thread.sleep(1000);

        List<WebElement> suggestions = driver.findElements(
                By.xpath("//ul[@role='listbox']//li//div[@role='option']"));

        System.out.println("Total Suggestions : " + suggestions.size());

        for (WebElement suggestion : suggestions) {

            System.out.println(suggestion.getText());

            if (suggestion.getText().equalsIgnoreCase("selenium")) {
                suggestion.click();
                break;
            }
        }

        driver.quit();
    }
}