@db_us_05 @natalia_db @natalia
Feature:  DB_US_05 Verify daily_reports table structure and data integrity

  Background: Connect to database
    Given Admin Natalia connects to the database

  @tc_01_daily_reports_table_column_name_validation
  Scenario: Validate column names in daily_reports table
    When Admin Natalia executes the query "SELECT * FROM daily_reports;"
    Then Admin Natalia verifies that the table should have the following columns:
      | Column Name                  |
      | id                            |
      | date                          |
      | number_of_contact_message     |
      | number_of_favorites           |
      | number_of_rent_adverts        |
      | number_of_sale_adverts        |
      | number_of_tour_requests       |
      | number_of_users               |
    And Admin Natalia closes the database connection

  @tc_02_daily_reports_table_data_integrity
  Scenario: Validate data integrity for id = 132 in daily_reports table
    When Admin Natalia executes the query "SELECT * FROM daily_reports WHERE id = 132;"
    Then Admin Natalia verifies that the record should have the following values:
      | Column Name                  | Expected Value |
      | id                            | 132           |
      | date                          | 2024-11-10    |
      | number_of_contact_message     | 101           |
      | number_of_favorites           | 56            |
      | number_of_rent_adverts        | 35            |
      | number_of_sale_adverts        | 57            |
      | number_of_tour_requests       | 60            |
      | number_of_users               | 268           |
    And Admin Natalia closes the database connection