package com.automation.steps;

import com.automation.pages.MeetingsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MeetingsPageSteps {

    MeetingsPage meetingsPage = new MeetingsPage();

    @Then("verify meetings page is displayed")
    public void verifyMeetingsPageIsDisplayed() {
        Assert.assertTrue(meetingsPage.isMeetingsPageDisplayed());
    }

    @When("user clicks on export button")
    public void userClicksOnExportButton() {
        meetingsPage.clickOnExportBtn();
    }


    @Then("verify file is downloaded")
    public void verifyFileIsDownloaded() {
        Assert.assertTrue(meetingsPage.isFileDownloaded());
    }

}
