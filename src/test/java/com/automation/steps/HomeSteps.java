package com.automation.steps;

import com.automation.pages.HomePage;
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
    @And("user choose the event type {string}")
    public void userChooseTheEventType(String eventType) {
        homePage.clickOnTheEventType();
    }

    @When("user clicks on new event type button")
    public void userClicksOnNewEventTypeButton() {
        homePage.clickOnNewEventTypeButton();
    }

}
