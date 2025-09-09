Feature: Signup Functionalty
  Scenario Outline: User can signUp with username and password
    Given the user can on Signup page
    When the user enter "<userName>" and "<password>"
    And click on sinup button
    Then the user should see "<expectedMessage>" on signup
    Examples:
       |userName    |password   |expectedMessage|
       | moazmoh123 | moazmoh123|Sign up successful.|
       |            | moazmoh123|Please fill out Username and Password.|
       |moazmoh123  |           |Please fill out Username and Password.|
       |moaz123     |moaz123    |his user already exist.|
       |moaz12354343|mo         |the password is weak.|
