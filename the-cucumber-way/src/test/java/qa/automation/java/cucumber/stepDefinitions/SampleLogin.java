package qa.automation.java.cucumber.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleLogin {
    public static void main(String[] args) {
        // Set the path to chromedriver.exe (update as needed)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the demo login page
            driver.get("https://www.saucedemo.com/");

            // Maximize the window
            driver.manage().window().maximize();

            // Locate and enter username
            WebElement username = driver.findElement(By.id("user-name"));
            username.sendKeys("standard_user");

            // Locate and enter password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");

            // Click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Verify successful login
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
