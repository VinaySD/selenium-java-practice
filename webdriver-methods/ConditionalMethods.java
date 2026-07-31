package selenium.webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // isDisplayed()
        boolean logo = driver.findElement(
                By.xpath("//div[@class='orangehrm-login-logo']//img"))
                .isDisplayed();

        System.out.println("Logo Displayed : " + logo);

        // Click OrangeHRM
        driver.findElement(
                By.linkText("OrangeHRM, Inc"))
                .click();

        Thread.sleep(3000);

        // isEnabled()
        boolean email = driver.findElement(
                By.id("Form_submitForm_EmailHomePage"))
                .isEnabled();

        System.out.println("Email Textbox Enabled : " + email);

        driver.quit();
    }
}