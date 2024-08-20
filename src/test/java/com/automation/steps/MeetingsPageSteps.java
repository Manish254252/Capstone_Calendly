package com.automation.steps;

import com.automation.pages.MeetingsPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
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

    @When("user clicks on meeting of name {string} and event name {string}")
    public void userClicksOnMeetingOfNameAndEventName(String eventScheduleName, String eventName) {
        meetingsPage.clickOnMeetingOfNameAndEvent(ConfigReader.getConfigValue(eventScheduleName), ConfigReader.getConfigValue(eventName));
    }

    @And("clicks on cancel button")
    public void clicksOnCancelButton() {
        meetingsPage.clickOnCancelButton();
    }

    @Then("verify cancel event pop up is displayed")
    public void verifyCancelEventPopUpIsDisplayed() {
        Assert.assertTrue(meetingsPage.isCancelEventPopUpDisplayed());
    }

    @When("user clicks on confirmation button")
    public void userClicksOnConfirmationButton() {
        meetingsPage.clickOnConfirmButton();
    }

    @Then("verify event is cancelled of meeting name {string} and event name {string}")
    public void verifyEventIsCancelledOfMeetingNameAndEventName(String eventScheduleName, String eventName) {
        Assert.assertTrue(meetingsPage.isMeetingCanceled(ConfigReader.getConfigValue(eventScheduleName), ConfigReader.getConfigValue(eventName)));
    }


    @And("verify meeting is present of name {string} and event name {string}")
    public void verifyMeetingIsPresentOfNameAndEventName(String eventScheduleName, String eventName) {
        Assert.assertTrue(meetingsPage.isMeetingPresent(ConfigReader.getConfigValue(eventScheduleName), ConfigReader.getConfigValue(eventName)));
    }

}
