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
        Assert.assertEquals(myTourRequestsPage.approvedStatus.getText(), "APPROVED");
    }

    @And("I click on the Reject button for a pending tour request associated with an ad")
    public void iClickOnTheRejectButtonForAPendingTourRequestAssociatedWithAnAd() {
        myTourRequestsPage.actionNoTick.click();
        WaitUtils.waitFor(3);
    }

    @And("I confirm the action by clicking Yes in the dialogue box")
    public void iConfirmTheActionByClickingYesInTheDialogueBox() {
        myTourRequestsPage.sureNoTick.click();
        WaitUtils.waitFor(3);
    }

    @Then("I should see the status of the tour request updated to Declined")
    public void iShouldSeeTheStatusOfTheTourRequestUpdatedToDeclined() {
        Assert.assertEquals(myTourRequestsPage.declinedStatus.getText(), "DECLINED");
        WaitUtils.waitFor(3);
    }
}
