@us_02 @natalia
  Feature: US_02 Customer's login functionality

    Background: Navigate home page
      Given Customer Natalia is on the "baseUrl" home page
      When customer Natalia clicks on Login option

    @tc_01_customer_natalia_successful_login
    Scenario: Customer_Natalia_must_be_able_to_login_with_valid_credentials
      And customer Natalia enters valid email into email input field
      And customer Natalia enters valid password into password input field
      And customer Natalia clicks of LOGIN button
      Then customer Natalia should be able to login successfully
      And customer Natalia closes the application

    @tc_02_customer_natalia_unsuccessful_login
    Scenario: Customer_Natalia_must_not_be_able_to_login_with_invalid_email_format
      And customer Natalia enters invalid email into email input field
      And customer Natalia enters valid password into password input field
      And customer Natalia clicks of LOGIN button
      Then customer Natalia should not be able to login successfully with invalid email format
      And customer Natalia closes the application

    @tc_03_customer_natalia_unsuccessful_login
    Scenario: Customer_Natalia_must_not_be_able_to_login_without_entering_credentials
      And customer Natalia clicks of LOGIN button
      Then customer Natalia should not be able to login successfully without entering credentials
      And customer Natalia closes the application