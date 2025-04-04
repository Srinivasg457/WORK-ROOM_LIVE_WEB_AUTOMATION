Feature: Catalog Module

#  Background fo the common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://dev-app.chataak.in/login/"

  Scenario: user will create the product if the Catagory not exists
    When the user enters their email "hitet98406@excederm.com" and password "iPsQxfXd"
    And the user clicks the Login button
    And user will see the Pop up message saying to create the category First


  Scenario: User will Print the List of Products
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And user will go to the Products and try to print the list of products


    Scenario: User will Enter the Details To Add The Products
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And User will fill the Product Data  for Adding the New Product

  Scenario: user will add the New Product if Category exist
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And User will Add The New Product

    Scenario: user will try to see the Product card Count  Details
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And user will print the product Active , All and Inactive products in the Console

  Scenario: user will Perform The Edit Operation
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And user will Perform The Edit Operation
