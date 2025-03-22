
Feature: Column_names_and_information_verification

  Background: Connect to database
    Given Admin connects to the database

  Scenario: TC_01 Validate column names in confirmation_token table
    When Admin  executes the query "SELECT * FROM confirmation_token;"
    Then Admin  verifies that the table should have the following columns:
      | Column Name        |
      | id                 |
      | confirmation_token |
      | created_time       |
      | user_id            |
    And Admin closes the database connection

