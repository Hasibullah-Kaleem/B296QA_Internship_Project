@db
Feature: CreateUser_DBValidation
  Scenario: CreatedUser_DBValidation
  #Given Admin connects to the database
  When Admin executes the query for the create user
  Then validate the created user from ResultSet
 # Then deletes the created user
  And Admin terminates the connection



