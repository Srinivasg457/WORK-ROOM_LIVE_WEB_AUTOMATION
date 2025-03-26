Feature: Catalog Module

#  Background fo the common steps
    Background:
      Given the user launches the Chrome browser
      And the user navigates to the login page with the URL "https://dev-app.chataak.in/login/"

  Scenario: user will create the category First
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And user will perform the actions to add the Category Manager