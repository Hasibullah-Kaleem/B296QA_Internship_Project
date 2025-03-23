@db_us_18
Feature: DB_US_18 Verify favorites column names and information

  Background: Connection to the database
    Given the database connection is established

  @tc_01_db_us_18
  Scenario: Verify column names in the favorites table
    When Admin Goychak executes the query "SELECT * FROM favorites;"
    Then Admin Goychak verifies the retrieved field names should contain the following columns:
      | Column Name |
      | id          |
      | created_at  |
      | updated_at  |
      | advert_id   |
      | user_id     |
    And Admin Goychak closes the database connection

  @tc_02_db_us_18
  Scenario: Verify data integrity for id = 122 in favorites table
    When Admin Goychak executes the query to fetch the record where id is 122 in "favorites" table
    Then Admin Goychak verifies that the retrieved field data matches the expected values:
      | Column Name | Expected Value |
      | id          | 122            |
      | advert_id   | 31             |
      | user_id     | 581            |
    And Admin Goychak closes the database connection