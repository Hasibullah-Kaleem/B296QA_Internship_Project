@api_us_02
  Feature: US_02 API Category-property-key controller

    Background: Authorization
      Given user Goychak is authorised as ADMIN

    @api_us_02_tc_01
    Scenario: TC_01 Post Request Validation
      And admin Goychak sets the url for POST request
      And admin Goychak sets the expected data for the User
      When admin Goychak sends the request and gets the response
      Then admin Goychak verifies the status code is 200
      And admin Goychak verifies the response body

    @api_us_02_tc_02
    Scenario: TC_02 Get Request Validation
      And admin Goychak sets the url for GET request
      And admin Goychak sets the expected data for the Get request
      When admin Goychak sends the request and gets the Get response
      Then admin Goychak verifies the status code of Get request is 200
      And admin Goychak verifies the response body of Get request

    @api_us_02_tc_03
    Scenario: TC_03 Put Request Validation
      And admin Goychak sets the url for PUT request
      And admin Goychak sets the expected data for the Put request
      When admin Goychak sends the request and gets the Put response
      Then admin Goychak verifies the status code of Put request is 200
      And admin Goychak verifies the response body of Put request
#    $[?(@['id'] == 514)]

    @api_us_02_tc_04
    Scenario: TC_04 Delete Request Validation
      And admin Goychak sets the url for DELETE request
      And admin Goychak sets the expected data for the Delete request
      When admin Goychak sends the request and gets the Delete response
      Then admin Goychak verifies the status code of Delete request is 200
      And admin Goychak verifies the response body of Delete request