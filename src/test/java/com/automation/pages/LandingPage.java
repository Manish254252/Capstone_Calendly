package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//a[@data-testid='login-header']")
    WebElement loginLink;

    public void openWebsite() {
        driver.get("https://calendly.com/");
    }

    public void clickOnLoginLink()
    {
        loginLink.click();
    }
}
