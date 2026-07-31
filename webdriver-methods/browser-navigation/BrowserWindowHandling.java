package selenium.browsernavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowHandling {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Open new window
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        Set<String> windowIDs = driver.getWindowHandles();

        List<String> windowList = new ArrayList<>(windowIDs);

        String parentID = windowList.get(0);
        String childID = windowList.get(1);

        // Parent Window
        driver.switchTo().window(parentID);
        System.out.println("Parent Title : " + driver.getTitle());

        // Child Window
        driver.switchTo().window(childID);
        System.out.println("Child Title : " + driver.getTitle());

        driver.quit();
    }
}