Feature: Cancel meeting functionality

  Scenario: verify meeting is canceled

    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on meetings link
    Then verify meetings page is displayed
    When user clicks on meeting of name "eventSchedule.name" and event name "newEvent.name"
    And clicks on cancel button
    Then verify cancel event pop up is displayed
    When user clicks on confirmation button
    Then verify event is cancelled of meeting name "eventSchedule.name" and event name "newEvent.name"