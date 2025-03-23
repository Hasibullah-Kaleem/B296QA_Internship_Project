@db_12
Feature:  Column_names_and_information_verification

  Background: Connect to database
    Given Admin Hasibullah connects to the database


  Scenario: TC_01 Validate column names in images table
    When Admin Hasibullah executes images table query "SELECT * FROM images;"
    Then Admin Hasibullah verifies that the images table should have the following columns:
      | id        |
      | data      |
      | featured  |
      | name      |
      | type      |
      | advert_id |
    And Admin Hasibullah closes the database connection

  Scenario: TC_02_Validate data integrity for id = 582434 in images table
    When Admin Hasibullah executes the images query "SELECT * FROM images WHERE data = 582434;"
    Then Admin Hasibullah verifies that the images record should have the following values:
      | id       | 1                             |
      | data     | 582434                        |
      | featured | true                          |
      | name     | Comfortable house in Kusadasi |
    And Admin Hasibullah closes the database connection