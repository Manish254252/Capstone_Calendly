Feature: Remove Holidays from the calender

  Scenario Outline: Verify the first 2 holidays are removed

    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on availability
    Then verify user is on Availability page
    When user click on holidays tab
    And clicks on change link
    Then verify holiday setting is displayed
    When user clicks on countries list button
    And clicks on country "<country>"
    And clicks on apply button
    Then verify holidays of country "<country>" are displayed
    And first two holidays are unchecked

    Examples:
      | country |
      | Germany |
      | Spain   |