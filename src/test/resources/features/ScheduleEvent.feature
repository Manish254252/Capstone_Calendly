Feature: Schedule an event/meeting functionality

  Background:
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage

  Scenario: verify an event is scheduled
    When user clicks on event of name "newEvent.name" and duration "newEvent.duration"
    And switch the tab
    Then verify user is on event schedule page
    When user selects date "eventSchedule.date"
    And user selects time
    And user enters event name "eventSchedule.name" email "eventSchedule.email" and "eventSchedule.Msg"
    And clicks on schedule button
    Then verify event is scheduled

    Scenario: cancel event
    When user clicks on meetings link
    Then verify meetings page is displayed
    And verify meeting is present of name "eventSchedule.name" and event name "newEvent.name"
    When user clicks on meeting of name "eventSchedule.name" and event name "newEvent.name"
    And clicks on cancel button
    Then verify cancel event pop up is displayed
    When user clicks on confirmation button
    Then verify event is cancelled of meeting name "eventSchedule.name" and event name "newEvent.name"