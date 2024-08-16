Feature: Event creation functionality
  Scenario: verify user can create an event
    Given user opens website
    When user login with email "ra12@gmail.com"
    Then verify user is on home page
    When user clicks on create event
