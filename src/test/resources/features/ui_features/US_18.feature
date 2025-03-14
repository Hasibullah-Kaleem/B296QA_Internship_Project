<<<<<<< HEAD
=======
@us_18
Feature: Manager advertisement management

  Background: Manager Login and Navigation to My Adverts
    Given I open "http://64.227.123.49/" with a web browser
    When I select the Login button on the homepage to login
    And I give valid manager credentials with username "boukmanager@gmail.com" and password "12345678Bouk@"
    And I navigate back to the homepage by clicking the Back to Site tab on the left side of the dashboard



  @TC_01_US18
  Scenario: TC_01 - Verify Manager Can request to see an ad on the page
    Given I click on the properties tab on the homepage to see properties available
    And I choose a property to view
    And I choose a Tour date and time
    And I click on the submit a tour request button
    Then I should see a message that the tour request has been submitted successfully


  @TC_02_US18
  Scenario: TC_02 - Verify Manager Can see, accept and reject tour requests of his own advertisements
    Given I click on the User Profile button at the top-right corner of the website
<<<<<<< HEAD
    And I navigate to the My tour requests page
    And I click on MY RESPONSES tab to see the tour requests from other users
    And I choose to accept or reject a tour request
    Then I should see a message that the tour request has been accepted or rejected successfully

=======
    And I navigate to the My Adverts tab from the dropdown menu
    And I choose a property to view from my own adverts
    And I choose a Tour date and time
    And I click on the submit a tour request button
    Then I should see a message that the tour request has been submitted successfully
>>>>>>> origin/Boukadida
>>>>>>> 9d414e69f372712a246e73526d18b45e6ee35fb2
