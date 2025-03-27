@ApiManager @api
Feature: Report_controller_APIValidation
  @api_us_07
  Scenario: Report_controller_APIValidation

    #Given the user is authorized as "Manager"
    And the users sets the url for Get the general report of total adverts, users, advert types, tour requests and categorie for API_US_7
    And the user sets the expected data for the the general report
    When the user sends a GET request to the report api and gets the response
    Then the response status code is 200 for API_US_7
    And the user verifies the response data for the logs for API_US_7
