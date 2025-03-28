@api_us04 @api
Feature: Advert Type API
  As a tester,
  I want to verify the functionality of the Advert Type API,
  So that it behaves as expected for various operations.
  Scenario: TC01 as a tester I should be able to successfully create an advert type in the database
    Given the base URL "http://64.227.123.49:8092" and path parameter "/advert-types" is used
    And a payload is created with title "For sale by Hasibullah"
    When a post request is sent and a response is received
    Then the status code should be 200
    And the response content type should be "application/json"
    And the response name should be "For sale by Hasibullah"
    @api_02
  Scenario: TC01 as a tester I should be able to successfully create an advert type in the database
    Given the base URL "http://64.227.123.49:8092" and path parameters "/advert-types/297" is used
    When a get request is sent and a response is received
    Then the status code should be 200
    And the response content type should be "application/json"
    And the response name should be "For sale by Hasibullah"


