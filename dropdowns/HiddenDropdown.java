package selenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HiddenDropdown {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.linkText("PIM")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text')])[1]")).click();

        List<WebElement> options =
                driver.findElements(By.xpath("//div[@role='listbox']//span"));

        System.out.println("Total Options : " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}