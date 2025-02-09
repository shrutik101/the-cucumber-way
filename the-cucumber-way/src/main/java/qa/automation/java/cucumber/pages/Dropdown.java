package qa.automation.java.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
    private final WebDriver driver;
    private final By option1 = By.xpath("//option[text() = 'Option 1']");
    private final By option2 = By.xpath("//option[text() = 'Option 2']");

    public Dropdown(WebDriver driver){
        this.driver = driver;
    }

    public void selectOption1(){
        driver.findElement(option1).click();
    }

    public void selectOption2(){
        driver.findElement(option2).click();
    }

    public boolean isOption1Selected(){
        return driver.findElement(option1).isSelected();
    }

    public boolean isOption2Selected(){
        return driver.findElement(option2).isSelected();
    }
}
