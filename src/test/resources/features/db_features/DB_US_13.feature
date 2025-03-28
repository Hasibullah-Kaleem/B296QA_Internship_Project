@db_us_13

Feature: US_13 - Validate profile_photos table structure and data integrity

  Background:
    Given Establish database connection

  @db_us13_tc01
  Scenario: Check that profile_photos table has correct columns
    When Run the query "SELECT column_name FROM information_schema.columns WHERE table_name = 'profile_photos';"
    Then Check if the table has the following columns:
      | id   |
      | data |
      | name |
      | type |
    And Terminate the database connection

  @db_us13_tc02
  Scenario: Check that profile_photos table contains data
    When Run the query "SELECT COUNT(*) FROM profile_photos;"
    Then Confirm that the query result is greater than 0
    And Terminate the database connection

