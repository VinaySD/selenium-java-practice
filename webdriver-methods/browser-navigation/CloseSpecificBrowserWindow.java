package selenium.browsernavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CloseSpecificBrowserWindow {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Open child window
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        // Close only the OrangeHRM child window
        for (String windowID : driver.getWindowHandles()) {

            driver.switchTo().window(windowID);

            if (driver.getTitle().equals("OrangeHRM")) {
                driver.close();
            }
        }

        // Switch back to remaining window
        for (String windowID : driver.getWindowHandles()) {
            driver.switchTo().window(windowID);
        }

        System.out.println("Current Window : " + driver.getTitle());

        driver.quit();
    }
}