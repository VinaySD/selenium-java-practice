package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> Links = driver.findElements(By.tagName("a"));
        int noofbrokenlinks = 0;
        for (WebElement linkelement : Links) {
            String herflink = linkelement.getAttribute("href");

            if(herflink==null || herflink.isEmpty()){
                System.out.println("href attribute value is null or empty. so not possible to check");
                continue;
            }
            try {
                URL linkURL = new URL(herflink);
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();

                conn.connect();

                if (conn.getResponseCode() >= 400) {
                    System.out.println(herflink + "====> Broken Link ");
                    noofbrokenlinks++;

                } else {
                    System.out.println(herflink + "====> Not Broken Link ");

                }

            } catch (Exception e){

            }


        }

        System.out.println("Total Number of links :"+Links.size());
        System.out.println("Total Number of Broken links :"+noofbrokenlinks);


    }
}
