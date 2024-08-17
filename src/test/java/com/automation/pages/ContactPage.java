package com.automation.pages;

import io.cucumber.java.fi.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    String nameAndEmail_XPATH = "(//tr[@class='r15404cu'])[%s]/td[%s]//div[text()]";
    String actions_XPATH = "(//tr[@class='r15404cu'])[%s]/td[6]//button[@aria-label='Contact Actions Button']";

    @FindBy(xpath = "//tr[@class='r15404cu']")
    List<WebElement> rows;

    @FindBy(xpath = "//div[text()='Remove']")
    WebElement removeBtn;

    @FindBy(xpath = "//button//span[text()='Remove']")
    WebElement removeConfirmationBtn;

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
        WebElement timeZone = driver.findElement(By.xpath(String.format(timezone_XPATH, data)));
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

    public void removesSpecifiedContact(String name, String email) {
        int n = rows.size();
        for (int i = 1; i <= n; i++) {
            String details = "";
            List<WebElement> detailsList = driver.findElements(By.xpath(String.format(nameAndEmail_XPATH, i, 2)));
            for (WebElement x : detailsList) {
                details += x.getText();

            }

            if (details.contains(name) && details.contains(email)) {
                WebElement action = driver.findElement(By.xpath(String.format(actions_XPATH, i)));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", action);
                js.executeScript("arguments[0].click()", removeBtn);
                js.executeScript("arguments[0].click()", removeConfirmationBtn);

            }

        }

    }

    public Boolean isContactPresent(String name, String email) {
        int n = rows.size();
        for (int i = 1; i <= n; i++) {
            String details = "";
            List<WebElement> detailsList = driver.findElements(By.xpath(String.format(nameAndEmail_XPATH, i, 2)));
            for (WebElement x : detailsList) {
                details += x.getText();

            }

            if (details.contains(name) && details.contains(email)) {
                return false;

            }

        }
        return true;
    }
}
