@api_us_11 @natalia_api @natalia @api
  Feature: API_US_11 API Validation for the daily-report-controller

    @tc_01_daily-report_response_structure_validation
    Scenario: Validate the response structure of the /daily-report API
      # Using predefined spec from Hook class
      Given the API endpoint "/daily-report" is available
      When Admin Natalia sends a GET request to the daily-report endpoint
      Then Admin Natalia verifies that the response status code is 200
      And Admin Natalia verifies that the response body of the "/daily-report" API matches the expected structure
