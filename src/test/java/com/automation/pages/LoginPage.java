package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='primary-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@data-testid='email-input']/input")
    WebElement emailInput;

    @FindBy(id = "8ziA9IwKE9GdJWnPNzDsS")
    WebElement passwordInput;

    @FindBy(xpath = "//button/span[text()='Continue']")
    WebElement continueBtn;




    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }


    public boolean isLoginBtnDisplayed() {
        return loginBtn.isDisplayed();
    }


    public void clickOnContinue() {
        continueBtn.click();
    }
}
