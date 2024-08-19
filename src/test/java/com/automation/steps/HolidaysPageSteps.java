package com.automation.steps;

import com.automation.pages.HolidaysPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HolidaysPageSteps {

    HolidaysPage holidaysPage = new HolidaysPage();

    @When("clicks on change link")
    public void clicks_on_change_link() {
        holidaysPage.clickOnChangeLink();
    }

    @Then("verify holiday setting is displayed")
    public void verify_holiday_setting_is_displayed() {
        Assert.assertTrue(holidaysPage.isHolidaysSettingPopUpDisplayed());
    }

    @When("user clicks on countries list button")
    public void user_clicks_on_countries_list_button() {
        holidaysPage.clickOnCountryListButton();
    }

    @When("clicks on country {string}")
    public void clicks_on_country(String country) {
        holidaysPage.clickOnCountry(country);
    }

    @When("clicks on apply button")
    public void clicks_on_apply_button() {
        holidaysPage.clickOnApplyButton();
    }

    @Then("verify holidays of country {string} are displayed")
    public void verify_holidays_of_country_are_displayed(String country) {
        Assert.assertTrue(holidaysPage.isHolidaysOfCountryDisplayed(country));
    }

    @Then("first two holidays are unchecked")
    public void first_two_holidays_are_unchecked() {
        holidaysPage.uncheckFirstTwoHolidays();
    }

}
