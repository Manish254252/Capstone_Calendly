Feature: Download schedules Functionality

  Scenario: Verify user can download the meetings scheduled
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
    When user clicks on export button
    Then verify file is downloaded

