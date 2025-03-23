@db_11
Feature:  Column_names_and_information_verification

  Background: Connect to database
    Given Admin Hasibullah connects to the database


  Scenario:TC_01 Validate column names in logs table
    When Admin Hasibullah executes logs table query "SELECT * FROM logs;"
    Then Admin Hasibullah verifies that the log table should have the following columns:
      | id         |
      | created_at |
      | advert_id  |
      | user_id    |
      | message    |
    And Admin Hasibullah closes the database connection

  Scenario: TC_02 Validate data integrity for id = 2313 in logs table
    When Admin Hasibullah executes the log query "SELECT * FROM logs WHERE id = 2313;"
    Then Admin Hasibullah verifies that the log table record should have the following values:
      | id         | 2313                       |
      | created_at | 2024-11-16 19:16:00.816503 |
      | advert_id  | 397                        |
      | user_id    | 1091                         |
      | message    | Tour request is created.   |
    And Admin Hasibullah closes the database connection