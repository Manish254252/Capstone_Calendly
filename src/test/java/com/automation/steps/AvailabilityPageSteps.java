package com.automation.steps;

import com.automation.pages.AvailabilityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AvailabilityPageSteps {

    AvailabilityPage availabilityPage = new AvailabilityPage();

    @Then("verify user is on Availability page")
    public void verify_user_is_on_availability_page() {
        Assert.assertTrue(availabilityPage.isAvailabilityPageDisplayed());
    }

    @When("user click on holidays tab")
    public void user_click_on_holidays_tab() {
        availabilityPage.clickOnHolidaysTab();
    }

}
