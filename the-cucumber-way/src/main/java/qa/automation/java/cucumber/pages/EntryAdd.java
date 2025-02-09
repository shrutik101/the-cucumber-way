package qa.automation.java.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdd {
    private final WebDriver driver;
    private final By closeButton = By.xpath("//p[text()='Close']");
    private final By modalWindowClosed = By.xpath("//div[@id='page-footer' and @style='display: block;']");

    public EntryAdd(WebDriver driver){
        this.driver = driver;
    }
    public void closePopup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();
    }
    public boolean isModalWindowIsClosed(){
        return driver.findElement(modalWindowClosed).isDisplayed();
    }
}



