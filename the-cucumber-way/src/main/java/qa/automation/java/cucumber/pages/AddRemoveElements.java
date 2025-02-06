package qa.automation.java.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElements {
    private WebDriver driver;

    // Locators
    private By addElement = By.xpath("//button[text()='Add Element']");
    private By deleteElement = By.xpath("//button[text()='Delete']");

    // Constructor
    public AddRemoveElements(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public void addElement(){
        driver.findElement(addElement).click();
    }

    public int deleteButtonCount(){
        return driver.findElements(deleteElement).size();
    }

}
