Feature: Event creation functionality
  Scenario: verify user can create an event
    Given user opens website
    When user login with email "userEmail"
    Then verify user is on home page
    When user clicks on new event type
    And user choose the event type "event.type"






