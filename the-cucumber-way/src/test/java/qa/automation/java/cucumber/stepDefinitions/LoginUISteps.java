package qa.automation.java.cucumber.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import qa.automation.java.cucumber.hooks.Hooks;
import qa.automation.java.cucumber.pages.AddRemoveElements;
import qa.automation.java.cucumber.pages.Checkbox;
import qa.automation.java.cucumber.pages.LoginPage;

public class LoginUISteps {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    Checkbox checkboxPage = new Checkbox(driver);
    AddRemoveElements addRemoveElements = new AddRemoveElements(driver);

    @Given("I open the HerokuApp login page")
    public void i_open_the_herokuapp_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
        System.out.println("Navigated to HerokuApp login page.");
    }

    @When("I enter {string} as username and {string} as password")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        System.out.println("Entered username and password.");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
        System.out.println("Clicked the login button.");
    }

    @Then("I should see {string}")
    public void i_should_see_expected_result(String expectedResult) {
        if (expectedResult.equals("Logout button visible")) {
            Assert.assertTrue("Logout button should be displayed", loginPage.isLogoutButtonDisplayed());
            System.out.println("Login successful.");
        } else if (expectedResult.equals("Invalid credentials")) {
            Assert.assertTrue("Error message is displayed.", loginPage.isErrorMessageDisplayed());
            System.out.println("Login failed as expected.");
        }
    }

    @Given("I open the HerokuApp checkbox page")
    public void i_open_the_herokuapp_checkbox_page() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        System.out.println("Navigated to HerokuApp checkbox page.");
    }

    @When("I select checkbox1")
    public void i_select_checkbox1() {
        checkboxPage.selectCheckbox1();
        System.out.println("checkbox1 is selected");
    }

    @When("I uncheck checkbox2")
    public void i_uncheck_checkbox2() {
        checkboxPage.deselectCheckbox2();
        System.out.println("checkbox2 is deselected");
    }

    @Then("Checkbox1 should be checked")
    public void checkbox1_should_be_checked() {
        Assert.assertTrue("Checkbox1 is selected.", checkboxPage.isCheckbox1Selected());
        System.out.println("Checkbox1 verified as checked.");
    }

    @Then("Checkbox2 should be unchecked")
    public void checkbox2_should_be_unchecked() {
        Assert.assertTrue("Checkbox2 is deselected.", checkboxPage.isCheckbox2Deselected());
        System.out.println("Checkbox2 verified as deselected.");
    }

    @Given("I open the HerokuApp Add-Remove element page")
    public void i_open_the_herokuapp_add_remove_element_page() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @When("I add the element")
    public void i_add_the_element(){
        addRemoveElements.addElement();
    }

    @Then("2 delete buttons should be displayed")
    public void two_delete_buttons_should_be_displayed(){
        Assert.assertEquals(2,addRemoveElements.deleteButtonCount());
    }
}