@us_16

Feature: Admin Report Management

  Background: Admin logs in and accesses the Reports section
    Given Admin opens "http://64.227.123.49/" in a browser
    When Admin clicks the login button on the homepage
    And Admin enters valid credentials with username "engineerhulya@hotmail.com" and password "Hulyatas2025?"
    And Admin navigates to the Reports section from the dashboard

  @TC_01_US16
  Scenario: Verify Admin can generate an advertisement report
    Given Admin configures the report filters with start date, end date, category, advert type, and status
    When Admin clicks on the Generate Advertisement Report button
    Then The report should be successfully generated

  @TC_02_US16
  Scenario: Verify Admin can generate a report for most popular adverts
    Given Admin sets the report parameters based on the amount filter
    When Admin triggers the report generation for popular adverts
    Then The report should be successfully generated

  @TC_03_US16
  Scenario: Verify Admin can generate a report by user role
    Given Admin sets the report parameters for user roles
    When Admin clicks on the Generate Role-Based Report button
    Then The report should be successfully generated

  @TC_04_US16
  Scenario: Verify Admin can generate a tour request report
    Given Admin configures the report filters using start date, end date, and status
    When Admin clicks on the Generate Tour Request Report button
    Then The report should be successfully generated
    Then The report should be exported successfully