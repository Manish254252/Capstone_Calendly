package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactsSection;

    @FindBy(xpath = "//div[@data-component='home-content']//button/span")
    WebElement addToContactIcon;

    @FindBy(xpath = "(//form//input)[2]")
    WebElement firstName;

    @FindBy(xpath = "(//form//input)[3]")
    WebElement email;

    @FindBy(xpath = "//button[@aria-controls='timezone-picker']")
    WebElement timeZone;

    @FindBy(xpath = "//div[@role='combobox']//input")
    WebElement searchBarForTimeZone;
    String timezone_XPATH = "//div[text()='%s']";
    @FindBy(xpath = "//div[text()='India Standard Time']")
    WebElement indianStandardTime;


    @FindBy(xpath = "(//form//input)[4]")
    WebElement phoneNumber;

    @FindBy(xpath = "//span[text()='Save contact']")
    WebElement saveContactBtn;

    @FindBy(xpath = "((//tr)[2]/td//div[text()])[1]")
    WebElement contactNameAfterSave;

    @FindBy(id = "contact_profile_close_button")
    WebElement contact_profile_close_button;


    public void clickOnContactSection() {
        contactsSection.click();
    }

    public void clickOnAddToContactIcon() {
        addToContactIcon.click();
    }

    public void clickOnTimeZone() {
        timeZone.click();
    }

    public void clickOnIndianTimeZone() {
//        indianStandardTime.click();
    }

    public void clickOnSaveContactBtn() {
        saveContactBtn.click();
    }

    public void clickOnContact_profile_close_button() {
        contact_profile_close_button.click();
    }

    public void enterFirstName(String data) {
        firstName.sendKeys(data);
    }

    public void enterEmail(String data) {
        email.sendKeys(data);
    }

    public void enterTimeZone(String data) {
       WebElement timeZone =  driver.findElement(By.xpath(String.format(timezone_XPATH,data)));
        searchBarForTimeZone.sendKeys(data);
        timeZone.click();

    }

    public void enterPhoneNumber(String data) {
        phoneNumber.click();
        phoneNumber.sendKeys(data);
    }

    public boolean isFirstNameDisplayed() {
        return firstName.isDisplayed();
    }

    public boolean isContactSaved(String contactName) {
        clickOnContact_profile_close_button();
        return contactNameAfterSave.getText().contains(contactName);
    }
}
