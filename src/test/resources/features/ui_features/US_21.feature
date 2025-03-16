@us_21
Feature: US_21 Admin's Contact Message Management

  As an Admin
  I want to be able to manage contact messages
  So that I have a full control over them

  Background: Navigate home page, send a contact message and login
    Given Admin Natalia is on the "baseUrl" homepage
    When admin Natalia clicks on Contact option
    And admin Natalia enters valid first name into First Name input field
    And admin Natalia enters valid last name into Last Name input field
    And admin Natalia enters valid email into Email Address input field
    And admin Natalia enters valid message into Message input field
    And admin Natalia clicks on SEND button
    And admin Natalia clicks on Login option
    And admin Natalia enters valid email into email input field
    And admin Natalia enters valid password into password input field
    And admin Natalia clicks on LOGIN button
    And admin Natalia clicks on ContactMessages section

  @tc_01_admin_natalia_view_filter_and_manage_contact_messages
  Scenario: Admin_Natalia_must_be_able_to_view_and_manage_contact_messages
    Then admin Natalia should be able to see received contact messages in the list
    And admin Natalia clicks on Filter icon
    And admin Natalia selects Unread option from Search In dropdown
    And admin Natalia selects a date from the Start Date picker
    And admin Natalia selects a date from the End Date picker
    And admin Natalia clicks on Apply Filters button
    Then admin Natalia should be able to see filtered Unread contact messages in the list
    And admin Natalia clicks on the filtered Unread contact message to view its details
    And admin clicks on Mark as Read button
    Then admin Natalia should be able to see the message marked as Read
    And admin Natalia clicks on Filter icon
    And admin Natalia selects Read option from Search In dropdown
    And admin Natalia clicks on Apply Filters button
    Then admin Natalia should be able to see filtered Read contact messages in the list
    And admin Natalia clicks on the filtered Read contact message to view its details
    And admin Natalia clicks on Delete message button
    Then admin Natalia should be able to see the message deleted
    And admin Natalia closes the application

  @tc_02_admin_natalia_search_and_delete_contact_messages
  Scenario: Admin_Natalia_must_be_able_to_search_and_delete_contact_messages
    And admin Natalia enters a keyword from a known message into Search input field
    And admin Natalia clicks on Search icon
    Then admin Natalia should be able to see searched contact messages in the list
    And admin Natalia clicks on the searched contact message to view its details
    And admin Natalia clicks on Delete message button
    Then admin Natalia should be able to see the message deleted
    And admin Natalia closes the application