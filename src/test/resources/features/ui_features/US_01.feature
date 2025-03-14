Feature: User Registration
  To allow new users to register for an account
  As a visitor
  I want to complete the registration form successfully

  Background:
    Given the user is on the homepage of the website "http://64.227.123.49/"
    And the user clicks on the "Register" button on the top right corner

  Scenario Outline: Registration process with various input conditions
    When the user enters "<First Name>" in the first name input box
    And the user enters "<Last Name>" in the last name input box
    And the user enters "<Phone Number>" in the phone number input box
    And the user enters "<Email>" in the email address input box
    And the user enters "<Password>" in the password input box
    And the user reenters "<Password>" in the confirm password input box
    And the user clicks on the checkbox to agree with Terms of Use
    And the user clicks on the "Register" button
    Then "<Expected Result>" is displayed

    Examples:
      | First Name | Last Name | Phone Number | Email                    | Password     | Expected Result                                    |
      | Johnny     | Doew      | 2233432567   | john.doe234561@gmail.com | Password@123 | Your registration has been completed successfully. Please to activate your account, click on the activation link sent to your e-mail. |
      | Janey      | Doen      | 2345679530   |                          | Password@123 | Email is required.                                 |
