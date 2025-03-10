@us_18
Feature: Manager advertisement management

  Background: Manager Login and Navigation to My Adverts
    Given I navigate to "http://64.227.123.49/" with a web browser
    When I click on the Login button on the homepage
    And I enter valid manager credentials using the username "boukmanager@gmail.com" and the password "12345678Bouk@"
    And I click on the Back to Site tab on the left side of the dashboard to go back to the homepage



  @TC_01_US18
  Scenario: TC_01 - Verify Manager Can request to see an ad on the page
    Given I click on the proprerties tab on the homepage to see properties available
    And I choose a property to view
    And I choose a Tour date and time
    And I click on the submit a tour request button
    Then I should see a message that the tour request has been submitted successfully


  @TC_02_US18
  Scenario: TC_02 - Verify Manager Can see, accept and reject tour requests of his own advertisements
    Given I click on the User Profile button at the top-right corner of the website
    And I navigate to the My Adverts tab from the dropdown menu
    And I choose a property to view from my own adverts
    And I choose a Tour date and time
    And I click on the submit a tour request button
    Then I should see a message that the tour request has been submitted successfully
