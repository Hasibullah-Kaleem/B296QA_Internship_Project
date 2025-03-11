package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.MyTourRequestsPage;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Stepdefs_US_13 {
    MyTourRequestsPage myTourRequestsPage;
    @And("I click on the Accept button for a pending tour request associated with an ad")
    public void iClickOnTheAcceptButtonForAPendingTourRequestAssociatedWithAnAd() {
        myTourRequestsPage = new MyTourRequestsPage();
        myTourRequestsPage.actionYesTick.click();
    }

    @And("I confirm the action by pressing Yes in the dialogue box")
    public void iConfirmTheActionByPressingYesInTheDialogueBox() {
        myTourRequestsPage.sureYesTick.click();
        WaitUtils.waitFor(3);
    }

    @Then("I should see the status of the tour request updated to Approved")
    public void iShouldSeeTheStatusOfTheTourRequestUpdatedToApproved() {
        Assert.assertEquals("APPROVED", myTourRequestsPage.approvedStatus.getText());
    }

    @And("I click on the Reject button for a pending tour request associated with an ad")
    public void iClickOnTheRejectButtonForAPendingTourRequestAssociatedWithAnAd() {
        myTourRequestsPage = new MyTourRequestsPage();
        myTourRequestsPage.actionNoTick.click();
        WaitUtils.waitFor(2);
    }

    @And("I confirm the action by clicking Yes in the dialogue box")
    public void iConfirmTheActionByClickingYesInTheDialogueBox() {
        myTourRequestsPage.sureYesTick.click();
        WaitUtils.waitFor(3);
    }

    @Then("I should see the status of the tour request updated to Declined")
    public void iShouldSeeTheStatusOfTheTourRequestUpdatedToDeclined() {
        Assert.assertEquals("DECLINED", myTourRequestsPage.declinedStatus.getText());
        WaitUtils.waitFor(3);
    }
}
