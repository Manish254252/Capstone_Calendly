package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'list-header')]//span[contains(text(),'New Event Type')]")
    WebElement newEventTypeButton;

    


}
