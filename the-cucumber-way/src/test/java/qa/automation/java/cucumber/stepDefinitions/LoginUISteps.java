package qa.automation.java.cucumber.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import qa.automation.java.cucumber.hooks.Hooks;
import qa.automation.java.cucumber.pages.*;
import utils.PropertyReader;

import java.util.List;
import java.util.Map;

public class LoginUISteps {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    Checkbox checkboxPage = new Checkbox(driver);
    AddRemoveElements addRemoveElements = new AddRemoveElements(driver);
    Dropdown dropdown = new Dropdown(driver);

    EntryAdd entryAdd = new EntryAdd(driver);

//    private PropertyReader propertyReader = new PropertyReader("src/test/resources/locators.properties");

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
            Map map;
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

    @Given("I open the HerokuApp dropdown page")
    public void i_open_the_herokuApp_dropdown_page(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @When("I select {string}")
    public void i_select_option(String option){
        if(option.equalsIgnoreCase("Option1")){
            dropdown.selectOption1();
        } else{
            dropdown.selectOption2();
        }
    }
    @Then ("{string} is selected")
    public void option_should_be_selected(String option){
        if (option.equalsIgnoreCase("Option1")){
            Assert.assertTrue(dropdown.isOption1Selected());
        }else{
            Assert.assertTrue(dropdown.isOption2Selected());
        }
    }

    @Given ("I open HerokuApp entry-add page")
    public void i_open_herokuApp_entryAdd_page(){
        driver.get("https://the-internet.herokuapp.com/entry_ad");
    }
    @When ("I click on close")
    public void i_click_on_close(){
        entryAdd.closePopup();
    }

    @Then ("The popup is not visible")
    public void the_popup_is_not_visible(){
        Assert.assertTrue(entryAdd.isModalWindowIsClosed());
    }

    @Given ("I open Herokuapp todos page")
    public void i_open_herokuapp_todos_page(){
        // Open the webpage
        driver.get("https://todomvc4tasj.herokuapp.com/");
    }

    @When ("I add {string}")
    public void i_add_task(String task) throws InterruptedException {
        // add the task
        WebElement textBox = driver.findElement(By.id("new-todo"));
        textBox.sendKeys(task);
        Thread.sleep(2000);
        textBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then ("{string} is added")
    public void task_is_added(String task) {
        //verify task is added
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='"+task+"']")).isDisplayed());
    }

    @Given ("Tasks are present in the todos")
    public void tasks_are_present_in_the_todos() throws InterruptedException {
        i_open_herokuapp_todos_page();
        i_add_task("TaskOne");
        i_add_task("TaskTwo");
        i_add_task("TaskThree");
    }

    @When("I checkmark the task {int}")
    public void i_checkmark_the_task(int number){
        // mark the task as done
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @class='toggle']"));
        checkboxes.get(number).click();
    }

    @Then("Verify Task {int} is marked as done")
    public void verify_task_is_marked_as_done(int number) throws InterruptedException {
        // verify task is marked as done
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @class='toggle']"));
        Thread.sleep(2000);
        Assert.assertTrue(checkboxes.get(number).isSelected());

    }

    @Given("{int} tasks are present")
    public void task_is_present(int task) throws InterruptedException {
        // verify task is present
        tasks_are_present_in_the_todos();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @class='toggle']"));
        Thread.sleep(2000);
        Assert.assertEquals(checkboxes.size(),task);
    }

    @When("I delete the task {int}")
    public void i_delete_the_task(int task) throws InterruptedException {
        // delete the task
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//label[text()='TaskOne']"))).perform();
        WebElement delete = driver.findElement(By.xpath("//button[@class='destroy']"));
        delete.click();
    }

    @Then("{int} tasks are present in the todo list")
    public void the_task_is_not_present_in_the_list(int task) throws InterruptedException {
        // verify the task is not present
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @class='toggle']"));
        Thread.sleep(2000);
        Assert.assertEquals(checkboxes.size(),task);
    }
}