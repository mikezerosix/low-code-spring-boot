Feature: User login

  User authentication into the system

  Scenario: Successful login
    Given A user exists with the username "john.doe" and password "password123"
    When The user enters the username "john.doe" and password "password123"
    Then The user is logged in

  Scenario: Unsuccessful login
    Given A user exists with the username "john.doe" and password "password123"
    When The user enters the username "john.doe" and password "incorrectpassword"
    Then The user is not logged in and sees an error message