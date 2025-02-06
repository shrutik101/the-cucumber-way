package qa.automation.java.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
    private WebDriver driver;

    // Locators
    private By checkboxes = By.xpath("//input[@type='checkbox']");

    // Constructor
    public Checkbox(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public void selectCheckbox1(){
        if(!driver.findElements(checkboxes).get(0).isSelected()){
            driver.findElements(checkboxes).get(0).click();
        }
    }

    public void deselectCheckbox2(){
        if(driver.findElements(checkboxes).get(1).isSelected()){
            driver.findElements(checkboxes).get(1).click();
        }
    }

    public boolean isCheckbox1Selected(){
        return driver.findElements(checkboxes).get(0).isSelected();
    }

    public boolean isCheckbox2Deselected(){
        return !driver.findElements(checkboxes).get(1).isSelected();
    }
}
