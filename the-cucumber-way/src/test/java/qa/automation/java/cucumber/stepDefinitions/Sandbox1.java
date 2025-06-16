package qa.automation.java.cucumber.stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import qa.automation.java.cucumber.pages.Checkbox;

import java.util.List;

public class Sandbox1 {

    public static void main(String[] args) {
        // WebDriver setup and initialization
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        checkCheckbox(driver, 1);
        uncheckCheckbox(driver, 1);
        verifyCheckboxStatus(driver, 1);
        driver.quit();
    }

    public static void checkCheckbox(WebDriver driver, int index) {
        // Implement logic to check the checkbox at the specified index
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(index).click();
    }

    public static void uncheckCheckbox(WebDriver driver, int index) {
        // Implement logic to uncheck the checkbox if already checked
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        if(checkboxes.get(index).isSelected()){
            checkboxes.get(index).click();
        }
    }

    public static void verifyCheckboxStatus(WebDriver driver, int index) {
        // Implement logic to verify and print if a checkbox is selected
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkboxes.get(index).isSelected());
    }

}
