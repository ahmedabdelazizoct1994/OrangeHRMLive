Feature: OrangeHRM User Management

  Scenario Outline: Add and Delete a User
    Given I enter the username "<username>"
    And I enter the password "<password>"
    And I click on the login button
    And I click on the Admin tab on the left side menu
    Then I get the number of records found
    When I click on the add button
    And I fill in the required data with role "<role>", employee name "<employeeName>", status "<status>", username "<newUsername>", password "<newPassword>"
    And I click on the save button
    Then I verify that the number of records increased by 1
    When I search with the username "<newUsername>" for the new user
    And I delete the new user
    Then I verify that the number of records decreased by 1

    Examples:
      | username | password | role | employeeName | status | newUsername | newPassword |
      | username | password | role | employeeName | status | newUsername | newPassword |
