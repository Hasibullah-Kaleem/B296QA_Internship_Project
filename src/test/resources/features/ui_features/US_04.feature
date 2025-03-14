@us_04

 Feature: Language selection

  Background: User navigates to homepage

   Given user is on the "http://64.227.123.49/" homepage
   And user clicks on login button
   And user enters valid customer email "nat.sar@gmail.com" into email field
   And user enters valid password "Password123!" into password field
   And user clicks on second login button
   Then user clicks on back to site button

  @US04_TC_01


  Scenario: Customer changes language and verifies content

   Given user clicks on Flags button
   Then customer selects Turkish and verifies page content
   And customer selects French and verifies page content
   And customer selects German and verifies page content
   And customer selects Spanish and verifies page content




   @US04_TC_02

   Scenario: Customer verifies language is not supported
    And customer clicks on Flags button
    Then customer verifies Italian language is not supported
