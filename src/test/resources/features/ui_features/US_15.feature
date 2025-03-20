@us_15
Feature: Admin Advertisement Management

  Background:
    Given I navigate to "http://64.227.123.49/" using a different web browser
    When I click on the login button on the homepage using a different approach
    And I enter valid Admin credentials
    Then I should be redirected to the Dashboard

  @TC_01_US15
  Scenario: TC_01 - Verify category creation
    Given I click on "Categories" from the left menu
    When I click on the "+" (Add) button in the top-right corner
    And I enter category name "Summer House"
    And I click "Create"
    Then I should see the newly added category in the category list

  @TC_02_US15
  Scenario: TC_02 - Verify Advert Type Creation
    Given I click on "Advert Types" from the left menu
    When I click on the "+" (Add) button in the top-right corner
    And I enter the advert type name "Summer house for rent"
    And I click "Create"
    Then I should see the message "Advert Type created successfully"

  @TC_03_US15
  Scenario: TC_03 - Verify User Role Update Failure
    Given I click on "Users" from the left menu
    When I click the edit (pencil) icon next to any user
    And I attempt to change the role and click "Update"
    Then I should see the error message "Error: Unauthorized"

  @TC_04_US15
  Scenario: TC_04 - Verify Category Update & Property Key Verification
    Given I click on "Categories" from the left menu
    And The category "Summer House" exists in the list
    When I click the edit (pencil) icon next to "Summer House"
    And I modify the category name to "Updated Test Category" and change the sequence number
    And I click "Update"
    Then I should see the success message "Category updated successfully"
    When I try to add a property key for the category
    Then If the system does not allow property key creation, mark this step as "Blocked"

  @TC_05_US15
  Scenario: TC_05 - Verify Tour Request Update Validation
    Given I click on "Tour Requests" from the left menu
    When I click the expand icon to open details
    And I click the edit (pencil) icon for Owner/Guest
    And I remove the phone number or enter an invalid phone number (e.g., "123")
    And I try to click "Update"
    Then I should see the error message "Phone number is required"


