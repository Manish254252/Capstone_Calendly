package com.automation.steps;

import com.automation.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingSteps {

    LandingPage landingPage = new LandingPage();
    @Given("user opens website")
    public void user_opens_website() {
       landingPage.openWebsite();
    }

    @When("user clicks on loginLink")
    public void userClicksOnLoginLink() {
        landingPage.clickOnLoginLink();
    }
}
