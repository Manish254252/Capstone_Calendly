package com.automation.steps;

import com.automation.pages.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProfilePageSteps {

    ProfilePage profilePage = new ProfilePage();

    @Then("verify profile page is displayed")
    public void verifyProfilePageIsDisplayed() {
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
    }

    @When("user clicks on upload profile")
    public void userClicksOnUploadProfile() {
        profilePage.clickOnUploadBtn();
    }

    @Then("verify profile is changed")
    public void verifyProfileIsChanged() {
        Assert.assertTrue(profilePage.isProfileChanged());
    }

    @When("user clicks on save changes button")
    public void userClicksOnSaveChangesButton() {
        profilePage.clickOnSaveChangesButton();
    }

    @Then("verify changes have been saved")
    public void verifyChangesHaveBeenSaved() {
        Assert.assertTrue(profilePage.isChangesSaved());
    }
}
