Feature:Sign-Up  form
Background:
  Given the user launches the Chrome browser
  And the user navigates to the SignUp page with the URL "https://dev-app.chataak.in/register/"
  #    And user will click the Create here a free trial

  Scenario:Enter all The Fields in the Sign up form and Submit
    And User Fills the Sign Up form
    And Click on the Submit Your Interest Form
    Then the SignUp Page Status message will be seen

  Scenario: if we pass the same details already existed status message should come
    And User Fills the Sign Up form
    And Click on the Submit Your Interest Form
    Then the SignUp Page Status message will be seen as Organization already exists with email

    Scenario: if the user Doest select The privacy policy Check box
      And User fill the Sign Up form But Doest Click the privacy policy check box
      And Click on the Submit Your Interest Form
      Then the SignUp Page Status message will be seen as Please agree to the privacy policy and terms.

