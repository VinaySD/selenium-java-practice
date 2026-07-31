package selenium.browsernavigation;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationCommands {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to OrangeHRM
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Navigate to Google
        driver.navigate().to("https://www.google.com");

        // Back
        driver.navigate().back();

        // Forward
        driver.navigate().forward();

        // Refresh
        driver.navigate().refresh();

        driver.quit();
    }
}