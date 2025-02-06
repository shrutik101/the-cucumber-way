@smoketest @loginfeature
Feature: User Login

  @smoketest
  Scenario: Successful login
    Given I have opened the application
    When I enter username "<username>" and password "<password>"
    Then I should be logged in successfully

  @loginfeature
  Scenario: Login with invalid credentials
    Given I have opened the application
    When I enter invalid username and password
    Then I should see an error message

  @loginfeature
  Scenario: Login with empty credentials
    Given I have opened the application
    When I leave the username and password fields empty
    Then I should see a validation message

  @regression
  Scenario: Logout functionality
    Given I am logged in
    When I click on logout
    Then I should be logged out successfully

  @smoketest @profilefeature
  Scenario: View user profile
    Given I am logged in
    When I navigate to the profile page
    Then I should see my user details

  @profilefeature
  Scenario: Update profile information
    Given I am logged in
    When I update my profile information
    Then I should see a success message


  @profilefeature
  Scenario: Update multiple profile fields
    Given I am logged in
    When I update my profile information with the following details:
      | field     | value       |
      | Name      | John Doe    |
      | Email     | john@test.com |
      | Phone     | 1234567890  |
    Then I should see a success message

  @smoketest @settingsfeature
  Scenario: Change password
    Given I am logged in
    When I navigate to change password
    And I enter current and new password
    Then my password should be updated successfully

  @settingsfeature
  Scenario: Enable Two-Factor Authentication
    Given I am logged in
    When I enable two-factor authentication
    Then I should see a confirmation message

  @smoketest @dashboardfeature
  Scenario: View dashboard
    Given I am logged in
    When I navigate to the dashboard
    Then I should see the latest updates

  @dashboardfeature
  Scenario: Check notifications
    Given I am logged in
    When I open the notifications panel
    Then I should see my recent notifications