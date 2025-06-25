Feature: workroom Create Employee

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://work-room.io/auth/login"
  @sanity
  Scenario: Login with the valid Email and password
    When the user enters their email "Bisleri@gmail.com" and password "Shree@1234"
    And the user clicks the Login button
    Then user will create new employee by filling the employee form in the employee module