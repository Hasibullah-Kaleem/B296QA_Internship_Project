@db_us_03 @natalia_db @natalia
  Feature:  DB_US_03 Verify category_property_values table structure and data integrity

    Background: Connect to database
      Given Admin Natalia connects to the database

    @tc_01_category_property_values_table_column_name_validation
    Scenario: Validate column names in category_property_values table
      When Admin Natalia executes the query "SELECT * FROM category_property_values;"
      Then Admin Natalia verifies that the table should have the following columns:
        | Column Name              |
        | id                       |
        | value                    |
        | advert_id                |
        | category_property_key_id  |
      And Admin Natalia closes the database connection

    @tc_02_category_property_values_table_data_integrity
    Scenario: Validate data integrity for id = 3935 in category_property_values table
      When Admin Natalia executes the query "SELECT * FROM category_property_values WHERE id = 3935;"
      Then Admin Natalia verifies that the record should have the following values:
        | Column Name              | Expected Value |
        | id                       | 3935          |
        | value                    | 180           |
        | advert_id                | 491           |
        | category_property_key_id  | 1             |
      And Admin Natalia closes the database connection