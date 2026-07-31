package selenium.alerts;

import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopup {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // username:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        driver.quit();
    }
}