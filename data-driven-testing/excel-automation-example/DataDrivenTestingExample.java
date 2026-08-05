package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class DataDrivenTestingExample {
    public static void main (String[] args) throws IOException, InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//div[@class='No thanks']")).click();
        String filepath = "C:\\Users\\Nitro\\IdeaProjects\\SeleniumPractice\\src\\test\\java\\practice\\salesdata.xlsx";

        int rows = ExcelUtils.getRowCount(filepath, "Sheet1");

        for(int r=1; r<=rows; r++){
            //read data
            String princ = ExcelUtils.getCellData(filepath, "Sheet1", r,0);
            String rot = ExcelUtils.getCellData(filepath,"Sheet1", r,1);
            String per1 = ExcelUtils.getCellData(filepath, "Sheet1", r,2);
            String per2 = ExcelUtils.getCellData(filepath, "Sheet1", r, 3);
            String freq = ExcelUtils.getCellData(filepath, "Sheet1", r,4);
            String exp_value = ExcelUtils.getCellData(filepath, "Sheet1", r,5);

            //pass above data
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rot);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
            Select drpper2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            drpper2.selectByVisibleText(per2);

            Select drpfreq = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            drpfreq.selectByVisibleText(freq); 

            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

            String price = driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();

            if(Double.parseDouble(exp_value) == Double.parseDouble(price)){
                System.out.println("Test Passed");
                ExcelUtils.setCellData(filepath,"Sheet1",r, 7, "passed" );
                ExcelUtils.fillGreenColor(filepath,"Sheet1", r, 7 );
            }
            else {
                System.out.println("Test Failed");
                ExcelUtils.setCellData(filepath,"Sheet1",r, 7, "failed" );
                ExcelUtils.fillRedColor(filepath,"Sheet1", r, 7);
            }

            Thread.sleep(2000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click();

        }
            driver.quit();
    }
}
