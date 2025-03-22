Feature:  Column_names_and_information_verification

  Background: Connect to database
    Given Admin connects to the database


  Scenario: TC_01 Validate column names in images table
    When Admin executes the query "SELECT * FROM images;"
    Then Admin verifies that the table should have the following columns:
      | Column Name |
      | id          |
      | data        |
      | featured    |
      | name        |
    And Admin closes the database connection

  Scenario: TC_02_Validate data integrity for id = 582434 in images table
    When Admin executes the query "SELECT * FROM images WHERE data = 582434;"
    Then Admin verifies that the record should have the following values:
      | Column Name | Expected Value                |
      | id          | 1                             |
      | data        | 582434                        |
      | featured    | 491                           |
      | name        | Comfortable house in Kusadasi |
      | type        | image/jpg                     |
      | advert_id   | 1                             |
    And Admin closes the database connection