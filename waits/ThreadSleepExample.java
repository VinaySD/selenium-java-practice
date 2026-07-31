package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleepExample {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("Admin");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("admin123");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.quit();
    }
}