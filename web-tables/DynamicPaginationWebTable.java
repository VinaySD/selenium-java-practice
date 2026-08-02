package selenium.webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicPaginationWebTable {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo.opencart.com/admin/");

        // Login
        WebElement username = driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Navigate to Customers
        driver.findElement(By.xpath("//a[contains(text(),'Customers')]")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

        // Get total pages
        String text = driver.findElement(
                By.xpath("//div[contains(text(),'Pages')]")).getText();

        int totalPages = Integer.parseInt(
                text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

        System.out.println("Total Pages : " + totalPages);

        // Read data from all pages
        for (int p = 1; p <= totalPages; p++) {

            if (p > 1) {
                WebElement page = driver.findElement(
                        By.xpath("//ul[@class='pagination']//*[text()='" + p + "']"));

                page.click();
                Thread.sleep(2000);
            }

            int rows = driver.findElements(
                    By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"))
                    .size();

            for (int r = 1; r <= rows; r++) {

                String customerName = driver.findElement(
                        By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + r + "]/td[2]"))
                        .getText();

                String email = driver.findElement(
                        By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + r + "]/td[3]"))
                        .getText();

                System.out.println(customerName + "\t" + email);
            }
        }

        driver.quit();
    }
}