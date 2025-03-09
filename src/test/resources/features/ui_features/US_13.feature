@us_13
  Feature: Manager's Tour Requests management

    Background: Manager Login and Navigation to My Responses
      Given I navigate to "http://64.227.123.49/" using a web browser
      When I click on the Login button on the homepage
      And I enter valid manager credentials with username "gmtechpro3@gmail.com" and password "Techpro8@3"
      And I click on the Login button at the top-right corner of the website
      And I click on the Back to Site tab on the left side of the dashboard
      And I click on the User Profile button at the top-right corner of the website
      And I navigate to the My Tour Requests tab from the dropdown menu
      And I go to the My Responses section

@TC_01_US13
    Scenario: TC_01 - Verify Manager Can Accept an Appointment Request
      And I click on the Accept button for a pending tour request associated with an ad
      And I confirm the action by pressing Yes in the dialogue box
      Then I should see the status of the tour request updated to Approved

@TC_02_US13
    Scenario: TC_02 - Verify Manager Can Reject an Appointment Request
      And I click on the Reject button for a pending tour request associated with an ad
      And I confirm the action by clicking Yes in the dialogue box
      Then I should see the status of the tour request updated to Declined