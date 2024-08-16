Feature: Delete event functionality

  Scenario: verify the event is deleted
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user deletes the event of name "delete.eventName"
    Then verify events are deleted