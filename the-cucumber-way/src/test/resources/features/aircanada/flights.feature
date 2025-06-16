Feature: Verify Air Canada FLight Search page

  Scenario: Verify that the Air Canada Flight Search page loads correctly
    Given I open the Air Canada flights search page
    Then The page title should contain "Air Canada"

  Scenario: Search for available flights
    Given I open the Air Canada flights search page
    When I enter the departure city "Toronto" and destination city "Vancouver"
    And I select the departure date as "17/02/2025" and return date as "19/02/2025"
    And I click the "Search" button
    Then I should see a list of available flights from "Toronto" to "Vancouver" for the selected dates

  Scenario: Store and Display Flight Details using HashMap
    Given I am on the Air Canada homepage
    When I enter the departure city "Toronto" and destination city "Vancouver"
    And I select the departure date as "2025-03-01" and return date as "2025-03-07"
    And I click the "Search" button
    Then I should be able to capture flight details in a HashMap with flight ID, departure time, and price
    And the HashMap should contain keys "flightID", "departureTime", and "price"

  Scenario: Store multiple flight options using ArrayList
    Given I am on the Air Canada homepage
    When I enter the departure city "Toronto" and destination city "Vancouver"
    And I select the departure date as "2025-03-01" and return date as "2025-03-07"
    And I click the "Search" button
    Then I should see multiple flight options available
    And I should be able to store these flight options in an ArrayList
    And the ArrayList should have at least 3 elements representing different flights

  Scenario: Book a flight and confirm booking details
    Given I am on the Air Canada homepage
    When I enter the departure city "Toronto" and destination city "Vancouver"
    And I select the departure date as "2025-03-01" and return date as "2025-03-07"
    And I click the "Search" button
    And I choose the first flight from the search results
    And I enter passenger details "John Doe" with contact "johndoe@example.com"
    And I click "Book Now"
    Then I should see a booking confirmation page with flight details

  Scenario: Validate flight details against user input using HashMap and ArrayList
    Given I am on the Air Canada homepage
    When I enter the departure city "Toronto" and destination city "Vancouver"
    And I select the departure date as "2025-03-01" and return date as "2025-03-07"
    And I click the "Search" button
    Then I should capture flight details in a HashMap with "flightID", "departureTime", and "price"
    And I should store multiple flight options in an ArrayList
    And I will validate the first flight in the ArrayList with the HashMap values to ensure the details match