package com.automation.steps;

import com.automation.pages.LandingPage;
import io.cucumber.java.en.Given;

public class LandingSteps {

    LandingPage landingPage = new LandingPage();
    @Given("User opens website")
    public void user_opens_website() {
       landingPage.openWebsite();
    }

}
