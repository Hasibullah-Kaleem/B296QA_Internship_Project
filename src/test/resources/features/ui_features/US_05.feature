@us_05


  Feature: Updating user's information
    Background:
      Given admin is on the "http://64.227.123.49/" homepage
      And admin clicks on login button
      And admikn enters valid admin email "nataliya.s@gmail.com" into email field
      And admin enters valid password "Password123!" into password field
      And admin clicks on second login button
      Then admin clicks on Users tab
      And types "Nataliya" into search input box and click search button

      @US05_TC_01

      Scenario: Updating info
      When admin clicks on Customer account Edit button
      And admin clicks on Roles menu and chooses Manager
      And admin clicks on Update button
      Then verify message "User type save successfully" is displayed


    @US05_TC_02

        Scenario: Delete user
    When admin clicks on delete button
    Then verify message "User deleted successfully" is displayed


   @US05_TC_03

   Scenario: Entering invalid data
     When admin clicks on edit button
     And admin clicks on email field and enters invalid email "nsarieva@"
     Then admin attempts to click Update button and verifies Update button is disabled/not clickable


