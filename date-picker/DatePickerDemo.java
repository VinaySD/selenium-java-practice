package selenium.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/datepicker/");

        // Switch to Date Picker Frame
        driver.switchTo().frame(0);

        // Open Calendar
        driver.findElement(By.id("datepicker")).click();

        String expectedYear = "2026";
        String expectedMonth = "December";
        String expectedDate = "25";

        // Navigate until desired month and year
        while (true) {

            String currentMonth = driver.findElement(
                    By.className("ui-datepicker-month")).getText();

            String currentYear = driver.findElement(
                    By.className("ui-datepicker-year")).getText();

            if (currentMonth.equals(expectedMonth) &&
                    currentYear.equals(expectedYear)) {
                break;
            }

            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }

        // Select Date
        List<WebElement> dates = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));

        for (WebElement day : dates) {

            if (day.getText().equals(expectedDate)) {
                day.click();
                break;
            }
        }

        driver.quit();
    }
}