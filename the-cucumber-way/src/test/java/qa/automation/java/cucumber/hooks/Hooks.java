package qa.automation.java.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser launched successfully.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

//    @Before
//    public void setUp() {
//        System.out.println("Setting up preconditions before scenario execution.");
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("Cleaning up after scenario execution.");
//    }
}
