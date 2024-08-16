package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Then("verify user on login page")
    public void verify_user_on_login_page() {
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
    }

    @When("user enters email as {string}")
    public void userEntersEmailAs(String email) {
    loginPage.enterEmail(ConfigReader.getConfigValue(email));
    }

    @And("user clicks on loginBtn")
    public void userClicksOnLoginBtn() {
        loginPage.clickOnLoginBtn();
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        loginPage.enterPassword(ConfigReader.getConfigValue(password));
    }

    @Then("user clicks on continue button")
    public void userClicksOnContinueButton() {
    }
}
