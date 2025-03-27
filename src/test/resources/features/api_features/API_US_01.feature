@api_us_01 @api
  Feature: US_01 API Tour Requests controller

    Background: Authorization
      Given user Goychak is authorised as ADMIN

    @api_us_01_tc_01
    Scenario: TC_01 Get Request Validation
      And admin Goychak sets the url for GET request for US01
      And admin Goychak sets the expected data for the Get request for US01
      When admin Goychak sends the request and gets the Get response for US01
      Then admin Goychak verifies the status code of Get request is 200 for US01
      And admin Goychak verifies the response body of Get request for US01