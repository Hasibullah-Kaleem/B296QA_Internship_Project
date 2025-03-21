@db_us_08
@db
Feature: US_08_DistrictNameAndInfo_DBValidation

  Background: Admin Login and Navigation to the database
    Given Admin connects to the PostgreSql database for US_08

  @db_us_08_tc_01
  Scenario: TC_01_verify the columns name of the districts table
    When Admin executes the query select * from districts for US_08
    Then Admin validates the columns name of the districts table

  @db_us_08_tc_02
  Scenario: TC_02_verify the column information of the districts table for id = 48323
    When Admin executes the query select * from districts where id = 48323
    Then Admin validates the column information of the districts table for the given id


