@db_us_09
@db
Feature: US_09_CategoryPropertyKeysNamesAndInfo_DBValidation

  Background: Admin Login and Navigation to the database
    Given Admin connects to the PostgreSql database for US_09

  @db_us_09_tc_01
  Scenario: TC_01_verify the columns name of the category_property_keys table
    When Admin executes the query select * from category_property_keys for US_9
    Then Admin validates the columns name of the category_property_keys table

  @db_us_09_tc_02
  Scenario: TC_02_verify the columns information of the category_property_keys table for id = 5
    When Admin executes the query select * from category_property_keys where id = 5
    Then Admin validates the column information of the category_property_keys table for id = 5