Feature: Manage Advertisements
  As a manager
  I want to view, update, and delete advertisements
  So that I can effectively manage my property listings

  Background:
    Given I am on the main page "http://64.227.123.49/"
    And I click on the Profile icon on the top right corner
    And I click on the My Adverts option from the profile dropdown
    And I am landed on the My Adverts page "http://64.227.123.49/my-adverts"
    And I randomly select the 2nd advertisement's Edit(pen) option
    And I am on the Edit Advert page for the 2nd ad "http://64.227.123.49/ad/edit"

  Scenario: Successfully updating and deleting an advertisement and confirming the visibility of titles
    When I change the price of the advertisement to "50000"
    And I click on the Update button to save changes
    And I confirm the update action in the confirmation popup
    Then I am redirected to the My Adverts page "http://64.227.123.49/my-adverts"
    And I see the Date Published title
    And I see the Status title
    And I see the View-Like-Tour title
    When I click on the Delete button for the 2nd ad
    And I click on Yes to confirm the deletion
    And I confirm the delete action in the confirmation popup
    Then the advertisement should be successfully deleted

  Scenario: Failing to update an advertisement due to empty data
    When I leave the description box empty
    Then I should not be able to click on the Update button
    And I should see a description error message in red under the Description box
