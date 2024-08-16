Feature: Event creation functionality
  Scenario: verify user can create an event
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on new event type button
    And user choose the event type "event.type"










