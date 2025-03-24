@db_us_06

  Feature: Verify cities column names and information

    Background: Connect to DB
      Given admin connects to the database for US_06

      @db_us_06_tc_01
      Scenario: Verify column names in cities table
        When admin executes the following SQL query to retrieve the data from cities table: "SELECT * FROM cities;"
        Then admin verifies the column names returned by the query match the  expected column names:
         # | Column Name |
          | id          |
          | lat         |
          | lng         |
          | name        |
          | country_id  |

        And admin closes the DB connection

        @db_us_06_tc_02

        Scenario: Verify integrity for id: 4128 in cities table
          When admin executes the SQL query: "SELECT * FROM cities WHERE id = 4148;"
          Then admin verifies the retrieved data returned by the query matches the  expected values
            | Column Name                  | Expected Value     |
            | id                           | 4148               |
            | lat                          | 41.6763707         |
            | lng                          | 26.556682586669922 |
            | name                         | Edirne             |
            | country_id                   | 223                |

          And admin closes the DB connection



