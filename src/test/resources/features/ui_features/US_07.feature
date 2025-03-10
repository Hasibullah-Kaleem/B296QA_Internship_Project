Feature: Post Sale Advertisements
  As a manager
  I want to post sale advertisements on the page
  So that I can make properties available for SALE

  Background:
    Given I am on the dashboard page of the website "http://64.227.123.49/dashboard"
    And I click on the Back To Site button
    And I click on the Create Property button
    And I upload a photo of the property

  Scenario Outline: Posting a property with different input variations-One Test Case for each variation
    When I enter a title as "<Title>"
    And I enter a description as "<Description>"
    And I enter a price as "<Price>"
    And I select "<Advert Type>" from the Advert Type dropdown as Sale
    And I select "<Category>" from the Category dropdown
    And I select "<Country>" from the Country dropdown
    And I select "<City>" from the City dropdown
    And I select "<District>" from the District dropdown
    And I enter the address as "<Address>"
    And I enter the room count as "<Room Count>"
    And I select "<Pool Availability>" for the pool availability option
    And I enter the size as a"<Size>"
    And I click on the Create button
    Then the system should behave appropriately as "<Expected Outcome>"

    #test data with one positive and one negative test case
    Examples:
      | Title                               | Description                     | Price    | Advert Type | Category        | Country | City  | District | Address   | Room Count | Pool Availability | Size  | Expected Outcome              |
      | Loft For Sale with Luxury Furniture | Fully furnished beautiful space | 20000000 | Rent        | Luxury Property | Turkiye | Izmir | Foca     | Eski Foca | 4          | Yes               | Small     | Advert Created Successfully   |
      | Loft With Big Balcony + Terrace     | Newly renovated space           |          | Rent        | Luxury Property | Turkiye | Izmir | Foca     | Eski Foca | 2          | No                | Small | Error: Price must be positive |
