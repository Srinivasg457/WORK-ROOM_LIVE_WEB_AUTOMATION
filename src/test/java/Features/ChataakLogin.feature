Feature: Chataak login

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://dev-app.chataak.in/login/"
@sanity
  Scenario: Login with the valid Email and password
    When the user enters their email "cakap69643@pixdd.com" and password "Shree@1234"
    And the user clicks the Login button
    Then the user should see the status message
@regression
  Scenario Outline: Login Field DataDriven Testing
    When the user enters their email "<email>" and password "<password>"
    And the user clicks the Login button
    Then the user should see the status message

    Examples:
      | email                | password    |
      | cakap69643@pixdd.com | Shree@1234  |
      | hello@1234           | 8fdlIsib    |
      | cakap69643@pixdd.com | Shree@12345 |
