@us_11
Feature: Customer_search_Functionality
  Background: Navigate home page
    Given Customer is on the "http://64.227.123.49/" home page
    When customer clicks on login option
    And customer enters valid email
    And customer enters valid password
    And customer clicks of login button
  @tc_01
  Scenario: TC_01_Customer_general_search
    Then customer clicks on sale button
    And customer clicks on house category
    And customer clicks on search icon
    Then customer verifies the result page contains properties
    And customer closes the application

  @tc_02
  Scenario: TC_02_Customer_advanced_search
    Then customer clicks on sale button
    And customer clicks on house category
    And customer clicks on search icon
    And customer enters min price
    And customer enters max price
    And customer selects advert type
    And customer selects category
    And customer selects country
    And customer selects city
    And customer selects district
    And customer clicks on search
    Then customer verifies the result page contains properties
    And customer closes the application

  @tc_03
  Scenario: TC_03_Customer_able_to_see_contact_information
    Then customer clicks on sale button
    And customer clicks on house category
    And customer clicks on search icon
    And customer clicks on sale property he choose
    Then customer verifies image, description, details and location information is available
    And customer closes the application
  @tc_04
  Scenario: TC_04_Customer_must_see_advertiser_information
    Then customer clicks on sale button
    And customer clicks on house category
    And customer clicks on search icon
    And customer clicks on sale property he choose
    And customer clicks on the eye icon on the right side of contact number
    Then customer verifies advertiser contact information is visible
    And customer closes the application
  @tc_05
  Scenario: TC_05_Customer_must_be_able_to_request_tour_request
    Then customer clicks on sale button
    And customer clicks on house category
    And customer clicks on search icon
    And customer clicks on sale property he choose
    And customer chooses tour date
    And customer chooses tour hour
    And customer clicks on submit tour request
    Then verify customer is able to submit tour request
    And customer closes the application
  @tc_06
  Scenario: Customer_must_be_able_to_see_tour_requests
    And customer clicks on profile
    And customer clicks on my tour requests
    Then verify customer is able to see tour requests
    And customer closes the application
  @tc_07
  Scenario: Customer_must_be_able_to_see_tour_requests
    And customer clicks on profile
    And customer clicks on my tour requests
    Then verify customer is able to see the status of tour request
    And customer closes the application