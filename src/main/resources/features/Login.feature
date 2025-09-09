Feature: Login functionality

  Scenario Outline: Login tests with multiple data
    Given the user is on login page
    When the user enters "<userName>" and "<password>"
    And the user clicks on login Button
    Then the user should see "<expectedMessage>" for "<type>"

    Examples:
      | type   | userName | password | expectedMessage                |
      | valid  | moaz123  | moaz123  | Welcome moaz123                |
      | invalid| moaz1234 | moaz1234 | User does not exist.           |
      | invalid  |          | moaz123  | Please fill out Username and Password. |


