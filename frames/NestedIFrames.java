package selenium.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NestedIFrames {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");

        // Switch to parent frame
        WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));
        driver.switchTo().frame(frame3);

        driver.findElement(By.name("mytext3")).sendKeys("Automation");

        // Switch to nested iframe
        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("div[id='i9'] div[class='AB7Lab Id5V1']")).click();

        driver.quit();
    }
}