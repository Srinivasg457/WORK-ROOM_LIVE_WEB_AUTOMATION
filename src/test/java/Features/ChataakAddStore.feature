Feature: Add new Store

  Scenario: Adding new Store in the Manufacturer account
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://dev-app.chataak.in/login/"
    When the user enters their email "cakap69643@pixdd.com" and password "Shree@1234"
    And the user clicks the Login button
    Then the user should see the status message
    And user will perform the actions to add the store