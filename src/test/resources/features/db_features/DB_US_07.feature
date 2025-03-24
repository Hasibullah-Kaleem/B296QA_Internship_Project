@db_us_07

Feature: Verify cities column names and information

  Background: Connect to DB
    Given admin connects to the database for US_07

    @db_us_07_tc_01
    Scenario: Verify column names in countries table

      When admin executes the following query "SELECT * FROM countries";
      Then admin verifies the data returned by the query matches the expected column names:
      #  | Column Name |
        | id          |
        | lat         |
        | lng         |
        | name        |

      And admin closes the Dbase connection


  @db_us_07_tc_02

  Scenario: Verify integrity for id: 230 in countries table
    When admin executes the  query "SELECT * FROM countries WHERE id = 230;"
    Then admin verifies the data returned by the query matches the expected values:
      | Column Name                  | Expected Value     |
      | id                           | 230                |
      | lat                          | 54.702354431152344 |
      | lng                          | -3.2765753269195557|
      | name                         |  United Kingdom    |



