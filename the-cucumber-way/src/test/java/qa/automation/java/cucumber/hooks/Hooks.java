package qa.automation.java.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        System.out.println("Browser launched successfully.");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Status status = scenario.getStatus();
//        if(Status.FAILED.compareTo(status) == 0){
//
//        }
//        // Save the screenshot to a specific location
//        File destination = new File(scenario.getName()+".png");
//        FileUtils.copyFile(screenshot, destination);
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
