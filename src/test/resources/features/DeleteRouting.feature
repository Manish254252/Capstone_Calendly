Feature: Delete Routing Functionality

  Scenario: Verify user can delete a routing form
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on routing link
    Then verify routing page is displayed
    When user clicks on options of routing name "routing.name"
    And clicks on delete option
    Then verify delete confirmation popup is displayed
    When user clicks on confirm delete button
    Then verify routing form "routing.name" is deleted
