Feature:  Column_names_and_information_verification

  Background: Connect to database
    Given Admin connects to the database


  Scenario:TC_01 Validate column names in logs table
    When Admin executes the query "SELECT * FROM logs;"
    Then Admin verifies that the table should have the following columns:
      | Column Name |
      | id          |
      | created_at  |
      | advert_id   |
      | user_id     |
      | message     |
    And Admin closes the database connection

  Scenario: TC_02 Validate data integrity for id = 2313 in logs table
    When Admin  executes the query "SELECT * FROM logs WHERE id = 2313;"
    Then Admin  verifies that the record should have the following values:
      | Column Name | Expected Value             |
      | id          | 2313                       |
      | created_at  | 2025-03-13 22:41:24.719541 |
      | advert_id   | 447                        |
      | user_id     | 36                          |
      | message     | Tour request is created.                           |
    And Admin  closes the database connection