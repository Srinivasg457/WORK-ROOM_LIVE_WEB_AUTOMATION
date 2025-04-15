Feature: Add new Store

  #  Background fo the common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://dev-app.chataak.in/login/"

#  Scenario: Adding new Store in the Manufacturer account
#    When the user enters their email "cakap69643@pixdd.com" and password "Shree@1234"
#    And the user clicks the Login button
#    Then the user should see the status message
#    And user will perform the actions to add the store

#    Scenario: the user will get the count of Total , Active  and Inactive stores count
#      When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#      And the user clicks the Login button
#      Then the user should see the status message
#      And the user will get the count of Total , Active  and Inactive stores count


  Scenario: Getting the list of stores
    When the user enters their email "hitet98406@excederm.com" and password "iPsQxfXd"
    And the user clicks the Login button
    Then the user should see the status message
    And the user will see the list of Stores





