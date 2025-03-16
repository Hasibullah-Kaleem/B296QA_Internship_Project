@us_19
  Feature: US_19 Customer's Contact Us Form

    Background: Navigate home page
      Given Customer Natalia is on the "baseUrl" homepage
      When customer Natalia clicks on Contact option

    @tc_01_customer_natalia_successful_contact_form_submission
    Scenario: Customer_Natalia_must_be_able_to_send_a_message_with_valid_data
      And customer Natalia enters valid first name into First Name input field
      And customer Natalia enters valid last name into Last Name input field
      And customer Natalia enters valid email into Email Address input field
      And customer Natalia enters valid message into Message input field
      And customer Natalia clicks on SEND button
      Then customer Natalia should be able to send a message successfully with valid data
      And customer Natalia closes the Application

    @tc_02_customer_natalia_unsuccessful_contact_form_submission
    Scenario: Customer_Natalia_must_not_be_able_to_send_a_message_with_invalid_first_name
      And customer Natalia enters invalid first name into First Name input field
      And customer Natalia enters valid last name into Last Name input field
      And customer Natalia enters valid email into Email Address input field
      And customer Natalia enters valid message into Message input field
      And customer Natalia clicks on SEND button
      Then customer Natalia should not be able to send a message with invalid first name
      And customer Natalia closes the Application

    @tc_03_customer_natalia_unsuccessful_contact_form_submission
    Scenario: Customer_Natalia_must_not_be_able_to_send_a_message_with_invalid_last_name
      And customer Natalia enters valid first name into First Name input field
      And customer Natalia enters invalid last name into Last Name input field
      And customer Natalia enters valid email into Email Address input field
      And customer Natalia enters valid message into Message input field
      And customer Natalia clicks on SEND button
      Then customer Natalia should not be able to send a message with invalid last name
      And customer Natalia closes the Application

    @tc_04_customer_natalia_unsuccessful_contact_form_submission
    Scenario: Customer_Natalia_must_not_be_able_to_send_a_message_with_invalid_email_format
      And customer Natalia enters valid first name into First Name input field
      And customer Natalia enters valid last name into Last Name input field
      And customer Natalia enters invalid email into Email Address input field
      And customer Natalia enters valid message into Message input field
      And customer Natalia clicks on SEND button
      Then customer Natalia should not be able to send a message with invalid email format
      And customer Natalia closes the Application