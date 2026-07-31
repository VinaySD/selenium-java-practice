package selenium.webdrivermethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // getTitle()
        System.out.println("Title : " + driver.getTitle());

        // getCurrentUrl()
        System.out.println("Current URL : " + driver.getCurrentUrl());

        // getPageSource()
        System.out.println(driver.getPageSource());

        // getWindowHandle()
        System.out.println("Window Handle : " + driver.getWindowHandle());

        // getWindowHandles()
        System.out.println("Window Handles : " + driver.getWindowHandles());

        driver.quit();
    }
}