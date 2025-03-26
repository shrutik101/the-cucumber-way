package qa.automation.java.cucumber.stepDefinitions;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Sandbox2 {

    public static void main(String[] args) {
        // WebDriver setup and initialization
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        removeCheckbox(driver);
        enableInputField(driver);
        enterText(driver, "Hello");
        driver.quit();


    }

    public static void removeCheckbox(WebDriver driver) {
        // Implement logic to click "Remove" and wait for checkbox to disappear
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement button = driver.findElement(By.xpath("//button[text()='Remove']"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
    }

    public static void enableInputField(WebDriver driver) {
        // Implement logic to click "Enable" and wait for the input field to be enabled
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']//p")));
    }

    public static void enterText(WebDriver driver, String text) {
        // Implement logic to type the given text into the input field and verify entry
        driver.findElement(By.xpath("//form[@id='input-example']//input")).sendKeys(text);
    }
}