@ui @herokuapp
Feature: HerokuApp Login

  @smoketest
  Scenario Outline: Login with multiple credentials
    Given I open the HerokuApp login page
    When I enter "<username>" as username and "<password>" as password
    And I click the login button
    Then I should see "<expected_result>"

    Examples:
      | username   | password              | expected_result       |
      | tomsmith   | SuperSecretPassword!  | Logout button visible |
      | invalidUser| invalidPass           | Invalid credentials   |

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