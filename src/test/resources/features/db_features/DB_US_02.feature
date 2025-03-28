@db_us_02
Feature: DB_US_02 Validate categories column names and information

  Background: Connection to the database
    Given the database connection is established

  @tc_01_db_us_02
  Scenario: Verify column names in the categories table
    When Admin Goychak executes the query "SELECT * FROM categories;"
    Then Admin Goychak verifies the retrieved field names should contain the following columns:
      | Column Name |
      | id          |
      | created_at  |
      | updated_at  |
      | is_active   |
      | built_in    |
      | icon        |
      | seq         |
      | slug        |
      | title       |
    And Admin Goychak closes the database connection

  @tc_02_db_us_02
  Scenario: Verify data integrity for id = 184 in categories table
    When Admin Goychak executes the query to fetch the record where id is 184 in "categories" table
    Then Admin Goychak verifies that the retrieved field data matches the expected values:
      | Column Name | Expected Value |
      | id          | 184            |
      | is_active   | true           |
      | built_in    | false          |
      | icon        | tree           |
      | title       | bungalow       |
    And Admin Goychak closes the database connection
