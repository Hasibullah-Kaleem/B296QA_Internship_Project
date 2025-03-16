@us_14
  Feature: Manager's Scheduling a Property Tour

    Background: Manager Login and Navigation to Properties Page
      Given User navigates to "http://64.227.123.49/" using a web browser
      When User clicks on the Login button on the homepage
      And User enters valid manager credentials with "gmtechpro3@gmail.com" and "Techpro8@3" in the login form
      And User clicks on the Login button at the top-right corner of the website to authenticate
      And User clicks on the Back to Site tab located on the left side of the dashboard
      And User clicks on the Properties tab at the top of the website
      And User selects the first house displayed on the page and clicks on it

    @TC_01_US14
    Scenario: Manager Schedules a Tour for a Property
      And User schedules a tour by selecting a Tour Date and Tour Time from the options on the right side of the page
      And User confirms the selected date by clicking on the Submit a Tour Request button
      Then User should see the notification Tour request created successfully appear on the page

    @TC_02_US14
    Scenario: User attempts to submit a tour request without selecting a date and time
      And User clicks on the Submit a Tour Request button without selecting a Tour Date or Tour Time
      Then User should see an error message asking them to select both a Tour Date and Tour Time before submitting the request
