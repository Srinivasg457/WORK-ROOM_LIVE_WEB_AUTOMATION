Feature: Catalog Module

#  Background fo the common steps
    Background:
      Given the user launches the Chrome browser
      And the user navigates to the login page with the URL "https://dev-app.chataak.in/login/"

#  Scenario: user will create the category First
#    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#    And the user clicks the Login button
#    And user will perform the actions to add the Category Manager
#
#    Scenario: user will create the category with all fields
#      When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#      And the user clicks the Login button
#      And user will fill all the fields of the category form

#  Scenario: user will create the category label
#    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#    And the user clicks the Login button
#    And user will try to create the lable

#  Scenario: user will Print The list of category data
#    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#    And the user clicks the Login button
#    And user will see the list of datas

#    Scenario: user will Delete the list of category
#    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#    And the user clicks the Login button
#    And user will try to delete the category

      Scenario: user will perform the enable or Disable
    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
    And the user clicks the Login button
    And user will perform the enable or Disable Action

#        Scenario: user will Edit The Category
#    When the user enters their email "ripewe1814@framitag.com" and password "8fdlIsib"
#    And the user clicks the Login button
#    And user will perform the edit operation