package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'list-header')]//span[contains(text(),'New Event Type')]")
    WebElement newEventTypeButton;

    @FindBy(id = "home-bar-create-button")
    WebElement createBtn;

    @FindBy(xpath = "//div[@data-component='sortable']//h2")
    List<String> eventNamesList;

    String XPATH_DURATION = "//div[@data-component='sortable']//p[contains(text(),'%s')]";



    public void clickOnTheEventType() {
    }

    public void clickOnNewEventTypeButton() {
    }

    public boolean isCreateBtnDisplayed() {
        return createBtn.isDisplayed();
    }
}
