package selenium.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");

        // Frame 1
        WebElement frame1 = driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.name("mytext1")).sendKeys("Welcome");
        driver.switchTo().defaultContent();

        // Frame 2
        WebElement frame2 = driver.findElement(By.cssSelector("frame[src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.name("mytext2")).sendKeys("Selenium");
        driver.switchTo().defaultContent();

        // Frame 3
        WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.name("mytext3")).sendKeys("Automation");

        driver.quit();
    }
}