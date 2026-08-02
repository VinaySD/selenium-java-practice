package selenium.webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticWebTable {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        int rows = driver.findElements(
                By.xpath("//table[@name='BookTable']//tr")).size();

        int columns = driver.findElements(
                By.xpath("//table[@name='BookTable']//th")).size();

        System.out.println("Rows : " + rows);
        System.out.println("Columns : " + columns);

        // Print all table data
        for (int r = 2; r <= rows; r++) {

            for (int c = 1; c <= columns; c++) {

                String value = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
                        .getText();

                System.out.print(value + "\t");
            }

            System.out.println();
        }

        // Print books written by Mukesh
        System.out.println("\nBooks by Mukesh:");

        for (int r = 2; r <= rows; r++) {

            String author = driver.findElement(
                    By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]"))
                    .getText();

            if (author.equals("Mukesh")) {

                String book = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]"))
                        .getText();

                System.out.println(book);
            }
        }

        // Calculate total price
        int totalPrice = 0;

        for (int r = 2; r <= rows; r++) {

            String price = driver.findElement(
                    By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]"))
                    .getText();

            totalPrice += Integer.parseInt(price);
        }

        System.out.println("\nTotal Price : " + totalPrice);

        driver.quit();
    }
}