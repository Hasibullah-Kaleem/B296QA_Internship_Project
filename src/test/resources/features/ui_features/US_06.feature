Feature: Post Rental Advertisements
  As a manager
  I want to post rental advertisements on the page
  So that I can make properties available for RENT

  Background:
    Given I am on the dashboard page of website "http://64.227.123.49/dashboard"
    And I click on the Back To Site button on left corner
    And I click on Create Property button
    And I upload photo of the property

  Scenario Outline: Posting a property with different input variations-One Test Case for each variation
    When I enter a rental title as "<Title>"
    And I enter a new description as "<Description>"
    And I enter a new price as "<Price>"
    And I select "<Advert Type>" from the Advert Type dropdown as Rent
    And I select "<Category>" as Luxury from the Category dropdown
    And I select "<Country>" Turkiye from the Country dropdown
    And I select "<City>" Izmir from the City dropdown
    And I select "<District>" Foca from the District dropdown
    And I enter the address as this "<Address>"
    And I enter the room count as a"<Room Count>"
    And I select "<Pool Availability>" for the pools availability option
    And I enter the size as a"<Size>"
    And I click on Create button
    Then the system should behave appropriately as expected "<Expected Outcome>"

    #test data with one positive and one negative test case
    Examples:
      | Title                 | Description             | Price   | Advert Type | Category        | Country | City  | District | Address            | Room Count | Pool Availability | Size | Expected Outcome                        |
      | Loft With Terrace     | Lovely and spacious     | 1000000 | Rent        | Luxury Property | Turkiye | Izmir | Foca     | Yeni Foca,Gencelli | 5          | Yes               | Big  | Advert Created Successfully             |
      | Loft With Big Balcony | Quiet and rustic escape | 500000  |             | Luxury Property | Turkiye | Izmir | Foca     | Yeni Foca          | 3          | No                | Big  | Error: Advert type not found by id: -1. |
