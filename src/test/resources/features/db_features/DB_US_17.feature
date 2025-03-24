@db_us_17
Feature: DB_US_17 Verify users column names and information

  Background: Connection to the database
    Given the database connection is established

  @tc_01_db_us_17
  Scenario: Verify column names in the users table
    When Admin Goychak executes the query "SELECT * FROM users;"
    Then Admin Goychak verifies the retrieved field names should contain the following columns:
      | Column Name         |
      | id                  |
      | created_at          |
      | updated_at          |
      | built_in            |
      | email               |
      | enabled             |
      | first_name          |
      | last_name           |
      | locked              |
      | password_hash       |
      | phone               |
      | reset_password_code |
      | role                |
      | picture_id          |
    And Admin Goychak closes the database connection

  @tc_02_db_us_17
  Scenario: Verify data integrity for id = 1416 in users table
    When Admin Goychak executes the query to fetch the record where id is 1416 in "users" table
    Then Admin Goychak verifies that the retrieved field data matches the expected values:
      | Column Name | Expected Value      |
      | id          | 1416                |
      | email       | gmtechpro@gmail.com |
      | enabled     | true                |
      | first_name  | Goychak_admin       |
      | last_name   | Musayeva            |
      | role        | ADMIN               |
    And Admin Goychak closes the database connection

  @tc_03_db_us_17
  Scenario: Verify no invalid emails exist in the users table
    When Admin Goychak executes the query "SELECT email FROM users WHERE email !~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$';" to retrieve invalid emails
    Then Admin Goychak verifies that there are no invalid emails
    And Admin Goychak closes the database connection