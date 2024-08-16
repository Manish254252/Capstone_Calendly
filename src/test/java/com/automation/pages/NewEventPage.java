package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class NewEventPage extends BasePage{

    @FindBy(xpath = "//input[@id='event-name-field']")
    WebElement newEventNameInput;

    @FindBy(xpath="//div[@name='eventDuration']")
    WebElement eventDuration;

    String XPATH_DURATION = "//button[text()='%s']";

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueBtn;

    @FindBy(xpath = "//h1[contains(text(), 'Your event type is ready!')] ")
    WebElement confirmationDialogueBox;




}
