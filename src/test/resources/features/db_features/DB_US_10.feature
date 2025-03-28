@hk @db_10
Feature: Column_names_and_information_verification

  Background: Connect to database
    Given Admin Hasibullah connects to the database

  Scenario: TC_01 Validate column names in confirmation_token table
    When Admin Hasibullah  executes the query "SELECT * FROM confirmation_token;"
    Then Admin Hasibullah verifies that the table should have the following columns:
      | id                 |
      | confirmation_token |
      | created_time       |
      | user_id            |
    And Admin Hasibullah closes the database connection

