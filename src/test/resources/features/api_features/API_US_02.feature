@api_us_02
  Feature: US_02 API Category-property-key controller

    @api_us_02_tc_01
    Scenario: TC_01 Post Request Validation
      Given user Goychak is authorised as ADMIN
      And admin Goychak sets the url for POST request
      And admin Goychak sets the expected data for the User
      When admin Goychak sends the request and gets the response
      Then admin Goychak verifies the status code is 200
      And verifies Goychak the response body








    Scenario: TC_02 Get Request Validation






    Scenario: TC_03 Put Request Validation






    Scenario: TC_04 Delete Request Validation