@us_09

  Feature: Updating advert status
    Background:
      Given admin navigates to "http://64.227.123.49/" homepage
      And click on Login button
      And enter admin email "nataliya.s@gmail.com"
      And enter admin password "Password123!"
      And click on Login option

      @US09_TC_01

      Scenario: Activating adverts status
        When admin clicks on Adverts menu
        And type "house" into search box
        And type "300000" into min price box
        And type "1200000" into max price box
        Then click on Advert type dropdown and select Sale
        And click on Status dropdown menu and select Pending
        And click on Category dropdown menu and select "House"
        Then click on Search button
        And click on chosen advert's Edit button
        And click on Status dropdown menu and activate the advert
        Then Verify success message is displayed:" Success Advert updated successfully"

        @US09_TC_02

        Scenario: Entering invalid data
          When admin clicks on back to site button
          And admin clicks on Account button
          And admin clicks on My Adverts button
          And admin cicks on Edit button
          And enter invalid/negative data "-10000" into Price input box
          Then verify Update button is disabled/ not clickable