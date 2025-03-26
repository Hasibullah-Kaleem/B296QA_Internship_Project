@api_us_03 @natalia_api @natalia @api
Feature: API_US_03 API Validation for the advert-controller

  @tc_01_adverts_response_body_validation_for_get_request
  Scenario: Validate the response body of the /adverts/cities/:limit API
          # Using predefined spec from Hook class
    Given the API endpoint "/adverts/cities/:limit" is available
    When Admin Natalia sends a GET request to the adverts endpoint
    Then Admin Natalia verifies that the response status code is 200
    And Admin Natalia verifies that the response body matches the expected data