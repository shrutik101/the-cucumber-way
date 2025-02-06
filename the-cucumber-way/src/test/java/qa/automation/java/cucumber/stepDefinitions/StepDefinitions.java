package qa.automation.java.cucumber.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class StepDefinitions {

    @Given("I have opened the application")
    public void i_have_opened_the_application() {
        System.out.println("Application is opened.");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        System.out.println("Entered Username: " + username);
        System.out.println("Entered Password: " + password);
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        System.out.println("Entered invalid credentials.");
    }

    @When("I leave the username and password fields empty")
    public void i_leave_the_username_and_password_fields_empty() {
        System.out.println("Left login fields empty.");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("Login successful.");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        System.out.println("Error message displayed.");
    }

    @Then("I should see a validation message")
    public void i_should_see_a_validation_message() {
        System.out.println("Validation message displayed.");
    }

    @Given("I am logged in")
    public void i_am_logged_in() {
        System.out.println("User is logged in.");
    }

    @When("I click on logout")
    public void i_click_on_logout() {
        System.out.println("Logout clicked.");
    }

    @Then("I should be logged out successfully")
    public void i_should_be_logged_out_successfully() {
        System.out.println("User logged out.");
    }

    @When("I navigate to the profile page")
    public void i_navigate_to_the_profile_page() {
        System.out.println("Navigated to profile page.");
    }

    @Then("I should see my user details")
    public void i_should_see_my_user_details() {
        System.out.println("User details displayed.");
    }

    @When("I update my profile information")
    public void i_update_my_profile_information() {
        System.out.println("Profile information updated.");
    }

    @When("I update my profile information with the following details:")
    public void i_update_my_profile_information_with_the_following_details(DataTable dataTable) {
        List<Map<String, String>> profileData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : profileData) {
            System.out.println("Updating field: " + row.get("field") + " with value: " + row.get("value"));
        }
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        System.out.println("Success message displayed.");
    }

    @When("I navigate to change password")
    public void i_navigate_to_change_password() {
        System.out.println("Navigated to change password page.");
    }

    @When("I enter current and new password")
    public void i_enter_current_and_new_password() {
        System.out.println("Entered current and new password.");
    }

    @Then("my password should be updated successfully")
    public void my_password_should_be_updated_successfully() {
        System.out.println("Password updated.");
    }

    @When("I enable two-factor authentication")
    public void i_enable_two_factor_authentication() {
        System.out.println("Enabled Two-Factor Authentication.");
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        System.out.println("Confirmation message displayed.");
    }

    @When("I navigate to the dashboard")
    public void i_navigate_to_the_dashboard() {
        System.out.println("Navigated to dashboard.");
    }

    @Then("I should see the latest updates")
    public void i_should_see_the_latest_updates() {
        System.out.println("Latest updates displayed.");
    }

    @When("I open the notifications panel")
    public void i_open_the_notifications_panel() {
        System.out.println("Opened notifications panel.");
    }

    @Then("I should see my recent notifications")
    public void i_should_see_my_recent_notifications() {
        System.out.println("Notifications displayed.");
    }
}
