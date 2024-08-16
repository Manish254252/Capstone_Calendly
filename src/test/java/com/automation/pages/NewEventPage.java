package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class NewEventPage extends BasePage{

    @FindBy(xpath = "//input[@id='event-name-field']")
    WebElement newEventNameInput;

    @FindBy(xpath="//div[@name='eventDuration']")
    WebElement eventDuration;




}
