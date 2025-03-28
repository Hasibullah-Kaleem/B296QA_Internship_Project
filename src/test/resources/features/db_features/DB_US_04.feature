@db_us_04 @natalia_db @natalia
Feature:  DB_US_04 Verify contacts table structure and data integrity

  Background: Connect to database
    Given Admin Natalia connects to the database

  @tc_01_contacts_table_column_name_validation
  Scenario: Validate column names in contacts table
    When Admin Natalia executes the query "SELECT * FROM contacts;"
    Then Admin Natalia verifies that the table should have the following columns:
      | Column Name  |
      | id          |
      | created_at  |
      | email       |
      | first_name  |
      | last_name   |
      | message     |
      | status      |
    And Admin Natalia closes the database connection

  @tc_02_contacts_table_data_integrity
  Scenario: Validate data integrity for id = 2413 in contacts table
    When Admin Natalia executes the query "SELECT * FROM contacts WHERE id = 2413;"
    Then Admin Natalia verifies that the record should have the following values:
      | Column Name | Expected Value             |
      | id          | 2413                       |
      | created_at  | 2025-03-21 00:24:59.198115 |
      | email       | nata@gmail.com             |
      | first_name  | Natalia                    |
      | last_name   | Tarakci                    |
      | message     | email me                   |
      | status      | false                      |
    And Admin Natalia closes the database connection