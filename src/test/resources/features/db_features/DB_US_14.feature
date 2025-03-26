@db_us_14
Feature: Validate column names and data in tour_requests table

  Background:
    Given Hulya connects to the database

  @db_us14_tc01
  Scenario: Validate column names in tour_requests table
    When Hulya runs the query "SELECT * FROM tour_requests"
    Then Hulya should see the following column headers in the result:
      | id            |
      | created_at    |
      | updated_at    |
      | status        |
      | tour_date     |
      | tour_time     |
      | advert_id     |
      | owner_user_id |
      | guest_user_id |
    And Hulya closes the database connection

  @db_us14_tc01
  Scenario: Validate data rows exist in tour_requests table
    When Hulya runs the query "SELECT * FROM tour_requests"
    Then Hulya verifies that the result contains at least one row
    And Hulya closes the database connection