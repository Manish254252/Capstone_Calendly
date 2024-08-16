package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='primary-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@data-testid='email-input']/input")
    WebElement emailInput;











    public boolean isLoginBtnDisplayed()
    {
        return loginBtn.isDisplayed();
    }
}
