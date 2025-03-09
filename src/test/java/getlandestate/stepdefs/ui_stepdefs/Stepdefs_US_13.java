package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.MyTourRequestsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Stepdefs_US_13 {
    MyTourRequestsPage myTourRequestsPage;
    @And("I click on the Accept button for a pending tour request associated with an ad")
    public void iClickOnTheAcceptButtonForAPendingTourRequestAssociatedWithAnAd() {
        myTourRequestsPage.actionYesTick.click();
    }

    @And("I confirm the action by pressing Yes in the dialogue box")
    public void iConfirmTheActionByPressingYesInTheDialogueBox() {
    }

    @Then("I should see the status of the tour request updated to Approved")
    public void iShouldSeeTheStatusOfTheTourRequestUpdatedToApproved() {
    }

    @And("I click on the Reject button for a pending tour request associated with an ad")
    public void iClickOnTheRejectButtonForAPendingTourRequestAssociatedWithAnAd() {
    }

    @And("I confirm the action by clicking Yes in the dialogue box")
    public void iConfirmTheActionByClickingYesInTheDialogueBox() {
    }

    @Then("I should see the status of the tour request updated to Declined")
    public void iShouldSeeTheStatusOfTheTourRequestUpdatedToDeclined() {
    }
}
