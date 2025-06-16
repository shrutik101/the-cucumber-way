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
import java.util.List;

public class Sandbox {

    Sandbox sandbox = new Sandbox();
    public static void main(String[] args) {
        // WebDriver setup and initialization
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        addElements(driver, 3);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='elements']//button[3]")));
        deleteElementAtIndex(driver,2);
        verifyRemainingElements(driver, 2);
        System.out.println("All Done");
        driver.quit();

    }

    public static void addElements(WebDriver driver, int count) {
        // Implement clicking on "Add Element" button 'count' times
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[@onClick='addElement()']"));
        for(int i=0;i<count;i++){
            addButton.click();
        }
    }

    public static void deleteElementAtIndex(WebDriver driver, int index) {
        // Implement deletion of button at specified index
        WebElement deleteAtIndex = driver.findElement(By.xpath("//div[@id='elements']//button["+index+"]"));
        deleteAtIndex.click();
    }

    public static void verifyRemainingElements(WebDriver driver, int expectedCount) {
        // Implement verification of remaining buttons
        List<WebElement> elements = driver.findElements(By.xpath("//button[@class='added-manually']"));
        Assert.assertEquals(expectedCount, elements.size());
    }
}
