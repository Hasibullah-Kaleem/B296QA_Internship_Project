@us_12
Feature: Customer_search_Functionality
  Background: Navigate home page
    Given Customer is on the "http://64.227.123.49/" home page

  @tc_01
  Scenario: TC_01_Customer_general_search
    Then customer clicks on rent button
    And customer clicks on house category
    And customer clicks on search icon
    Then customer verifies the result page contains properties
    And customer closes the application

  @tc_02
  Scenario: TC_02_Customer_advanced_search
    Then customer clicks on rent button
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
  Scenario: TC_03_Customer_able_to_see_information_of_property_and_details
    Then customer clicks on rent button
    And customer clicks on house category
    And customer clicks on search icon
    And customer clicks on property he choose
    Then verify customer is able to see details of the property
    And customer closes the application

  @tc_04
  Scenario: TC_04_Customer_must_not_be_able_to_see_advertiser_information
    Then customer clicks on rent button
    And customer clicks on house category
    And customer clicks on search icon
    And customer clicks on property he choose
    And customer clicks on the eye icon on the right side of contact number
    Then verify customer is not able to see advertiser contact information and warning message appear
    And customer closes the application
  @tc_05
  Scenario: TC_05_Customer_must_not_be_able_to_request_tour_request
    Then customer clicks on rent button
    And customer clicks on house category
    And customer clicks on search icon
    And customer clicks on property he choose
    And customer chooses tour date
    And customer chooses tour hour
    And customer clicks on submit tour request
    And verify customer is not able to submit tour request
    Then customer clicks on create now
    Then verify customer is directed to registration page
    And customer closes the application