@ui @herokuapp
Feature: HerokuApp Login

  @smoketest
  Scenario Outline: Login with multiple credentials
    Given I open the HerokuApp login page
    When I enter "<username>" as username and "<password>" as password
    And I click the login button
    Then I should see "<expected_result>"

    Examples:
      | username    | password             | expected_result       |
      | tomsmith    | SuperSecretPassword! | Logout button visible |
      | invalidUser | invalidPass          | Invalid credentials   |

  @checkbox
  Scenario: Checkbox is checked
    Given I open the HerokuApp checkbox page
    When I select checkbox1
    And I uncheck checkbox2
    Then Checkbox1 should be checked
    And Checkbox2 should be unchecked

  @addElement
  Scenario: Add element functionality
    Given I open the HerokuApp Add-Remove element page
    When I add the element
    And I add the element
    Then 2 delete buttons should be displayed

  @dropdown
  Scenario Outline: Dropdown is selected
    Given I open the HerokuApp dropdown page
    When I select "<options>"
    Then "<options>" is selected

    Examples:
      | options |
      | Option1 |
      | Option2 |

  @entryAdd
  Scenario: Popup is closed
    Given I open HerokuApp entry-add page
    When I click on close
    Then The popup is not visible

  @past
  Scenario Outline: Add task
    Given I open Herokuapp todos page
    When I add "<tasks>"
    Then "<tasks>" is added

    Examples:
      | tasks     |
      | TaskOne   |
      | TaskTwo   |
      | TaskThree |

  @todo
  Scenario: Mark task as done
    Given Tasks are present in the todos
    When I checkmark the task 2
    Then Verify Task 2 is marked as done

  @future
  Scenario: Delete task
    Given Task 1 is present
    When I delete the task 1
    Then The task 1 is not present in the todo list