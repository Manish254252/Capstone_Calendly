package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @When("user clicks on new event type")
    public void userClicksOnNewEventType() {
        homePage.clickOnNewEventTypeButton();
    }

    @And("user choose the event type {string}")
    public void userChooseTheEventType(String eventType) {
        homePage.clickOnTheEventType();
    }
}
