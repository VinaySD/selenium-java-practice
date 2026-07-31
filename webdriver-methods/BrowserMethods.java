package selenium.webdrivermethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        // Open Browser
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize Browser
        driver.manage().window().maximize();

        // Close Current Browser Window
        // driver.close();

        // Close All Browser Windows
        driver.quit();
    }
}