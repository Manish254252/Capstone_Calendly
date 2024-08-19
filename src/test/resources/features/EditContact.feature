Feature: Testing of EditContact feature

  Scenario: Editing a contact
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    Given user navigates to the Add to Contacts section
    When user edits  "contact.firstname" to "edit.firstname" and "contact.phoneNo" to "edit.phoneNo" with email "contact.email"
    And user clicks on the Save Contact button
    Then verify the contact "edit.firstname" is successfully edited