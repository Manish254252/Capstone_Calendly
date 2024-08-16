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
    Then verify new event type page is displayed
    When user choose the event type "event.type"
    And user clicks on next button
    And user enters event name "newEvent.name" and duration "newEvent.duration"
    And clicks on continue Button
    Then verify new Event is ready message is displayed
    When user clicks on done button
    Then verify event "newEvent.name" and "newEvent.duration" is listed on home page














