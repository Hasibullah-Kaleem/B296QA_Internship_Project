@db_us_01
Feature: DB_US_01 Validate table names
  Background: Connection to the database
    Given the database connection is established

@tc_01_db_us_01
  Scenario: Validate presence of required tables
  When Admin Goychak executes the query to retrieve the table names
  Then Admin Goychak verifies that the database should contain the following columns:
    | Column Name              |
    | category_property_keys   |
    | confirmation_token       |
    | daily_reports            |
    | logs                     |
    | favorites                |
    | images                   |
    | profile_photos           |
    | category_property_values |
    | advert_types             |
    | cities                   |
    | cmd_exec                 |
    | adverts                  |
    | countries                |
    | districts                |
    | users                    |
    | tour_requests            |
    | categories               |
    | contacts                 |
  And Admin Goychak closes the database connection

@tc_02_db_us_01
  Scenario: Validate the number of tables in the database
  When Admin Goychak executes the query to retrieve the number of tables in the database
  Then Admin Goychak verifies that the retrieved number matches '18'
  And Admin Goychak closes the database connection


