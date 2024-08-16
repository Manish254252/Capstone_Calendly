package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();
    @And("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isCreateBtnDisplayed());
    }


    @When("user clicks on new event type button")
    public void userClicksOnNewEventTypeButton() {
        homePage.clickOnNewEventTypeButton();
    }

    @Then("verify event is listed on home page")
    public void verifyEventIsListedOnHomePage() {

    }

    @Then("verify event {string} and {string} is listed on home page")
    public void verifyEventAndIsListedOnHomePage(String eventName, String eventDuration) {
        Assert.assertTrue(homePage.isEventListedOnHomePage(eventName, eventDuration));
    }

    @When("user deletes the event of name {string}")
    public void userDeletesTheEventOfNameAndDuration(String eventName, String eventDuration) {
        homePage.deleteEventsOfName(ConfigReader.getConfigValue(eventName));
    }
}
