Feature: Candidate Management

  Scenario Outline: Add a candidate
    Given I navigate to the OrangeHRM website
    When I add a candidate with firstName "<firstName>",  lastName "<lastName>", email "<email>" and jobTitle "<jobTitle>"
    Examples:
      | firstName | lastName | email | jobTitle |  |
      | firstName | lastName | email | jobTitle |  |


  Scenario Outline: Delete a candidate
    Given I navigate to the OrangeHRM website
    When I delete the candidate with ID "<ID>"
    Examples:
      | ID |
      | ID |