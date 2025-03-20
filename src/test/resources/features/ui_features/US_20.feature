@us_20 @natalia
  Feature: US_20 Manager's Contact Message Management

    As a Manager
    I want to be able to manage contact messages
    So that I have a full control over them

    Background: Navigate home page, send a contact message and login
      Given Manager Natalia is on the "baseUrl" homepage
      When manager Natalia clicks on Contact option
      And manager Natalia enters valid first name into First Name input field
      And manager Natalia enters valid last name into Last Name input field
      And manager Natalia enters valid email into Email Address input field
      And manager Natalia enters valid message into Message input field
      And manager Natalia clicks on SEND button
      And manager Natalia clicks on Login option
      And manager Natalia enters valid email into email input field
      And manager Natalia enters valid password into password input field
      And manager Natalia clicks on LOGIN button
      And manager Natalia clicks on ContactMessages section

    @tc_01_manager_natalia_view_filter_and_manage_contact_messages
    Scenario: Manager_Natalia_must_be_able_to_view_and_manage_contact_messages
      Then manager Natalia should be able to see received contact messages in the list
      And manager Natalia clicks on Filter icon
      And manager Natalia selects Unread option from Search In dropdown
      And manager Natalia selects a date from the Start Date picker
      And manager Natalia selects a date from the End Date picker
      And manager Natalia clicks on Apply Filters button
      Then manager Natalia should be able to see filtered Unread contact messages in the list
      And manager Natalia clicks on the filtered Unread contact message to view its details
      And manager clicks on Mark as Read button
      Then manager Natalia should be able to see the message marked as Read
      And manager Natalia clicks on Filter icon
      And manager Natalia selects Read option from Search In dropdown
      And manager Natalia clicks on Apply Filters button
      Then manager Natalia should be able to see filtered Read contact messages in the list
      And manager Natalia clicks on the filtered Read contact message to view its details
      And manager Natalia clicks on Delete message button
      Then manager Natalia should be able to see the message deleted
      And manager Natalia closes the application

      @tc_02_manager_natalia_search_and_delete_contact_messages
      Scenario: Manager_Natalia_must_be_able_to_search_and_delete_contact_messages
        And manager Natalia enters a keyword from a known message into Search input field
        And manager Natalia clicks on Search icon
        Then manager Natalia should be able to see searched contact messages in the list
        And manager Natalia clicks on the searched contact message to view its details
        And manager Natalia clicks on Delete message button
        Then manager Natalia should be able to see the message deleted
        And manager Natalia closes the application