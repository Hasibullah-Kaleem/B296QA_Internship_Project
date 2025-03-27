@ApiManager @api
Feature: Log_controller_APIValidation
  @api_us_08
  Scenario: Log_controller_APIValidation

    #Given the user is authorized as "Manager"
    And the users sets the url for Get user's log by id for API_US_8
    And the user sets the expected data for the logs
    When the user sends a GET request to the logs api and gets the response
    Then the response status code is 200 for API_US_8
    And the user verifies the response data for the logs for API_US_8