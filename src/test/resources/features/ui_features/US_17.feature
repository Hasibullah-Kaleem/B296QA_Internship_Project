<<<<<<< HEAD
=======
@us_17
Feature: Manager report generation

  Background: Manager Login and Navigation to the control panel
    Given I open "http://64.227.123.49/" in a web browser
    When I select the Login button on the homepage
    And I provide valid manager credentials with username "boukmanager@gmail.com" and password "12345678Bouk@"
    And I click on the Reports button at the right side of the dashboard

  @TC_01_US17
  Scenario: TC_01 - Verify Manager Can Generate a Report for Adverts
    Given I set the parameters for the report generation based on the start date, end date, category, advert type, and status
    When I click on the Generate Adverts Report button
    Then I should see the report generated successfully

  @TC_02_US17
  Scenario: TC_02 - Verify Manager Can generate a Report for popular adverts
    Given I set the parameters for the report generation based on the amount
    When I click on the Generate popular Adverts Report button
    Then I should see the report generated successfully

  @TC_03_US17
  Scenario: TC_03 - Verify Manager Can generate a Report by user's role
    Given I set the parameters for the report generation based on the user's role
    When I click on the Generate Role Report button
    Then I should see the report generated successfully


  @TC_04_US17
  Scenario: TC_04 - Verify Manager Can generate a Report by tour requests
    Given I set the parameters for the report generation based on on the start date, end date,and status information
    When I click on the Generate Tour request Report button
    Then I should see the report generated successfully
>>>>>>> origin/Boukadida
