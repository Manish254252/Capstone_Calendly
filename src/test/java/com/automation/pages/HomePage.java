package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'list-header')]//span[contains(text(),'New Event Type')]")
    WebElement newEventTypeButton;

    @FindBy(id = "home-bar-create-button")
    WebElement createBtn;

    @FindBy(xpath = "//div[@data-component='sortable']//h2")
    List<WebElement> eventNamesList;

    @FindBy(xpath = "//div[@data-component='sortable']//p")
    List<WebElement> eventDurationList;

    @FindBy(xpath = "//div[@data-component='sortable']//button[@aria-expanded]")
    List<WebElement> noOfEvents;

    @FindBy(xpath = "//div[@data-component='sortable']//h2/ancestor::div[@data-component='event-type-card-list']//button[@aria-expanded]")
    List<WebElement> settingOptions;

    @FindBy(xpath = "//button/span[text()='Yes']")
    WebElement deleteConfirmBtn;

    public void clickOnNewEventTypeButton() {
        newEventTypeButton.click();
    }

    public boolean isCreateBtnDisplayed() {
        return createBtn.isDisplayed();
    }

    public boolean isEventListedOnHomePage(String eventName, String eventDuration) {
        boolean isEventPresent = false;
        boolean isDurationPresent = false;

        if (isPresent(eventNamesList)) {
            for (WebElement event : eventNamesList) {
                if (event.getText().contains(eventName)) {
                    isEventPresent = true;
                    break;
                }
            }
            if (eventDuration.equals("60 min")) {
                eventDuration = "1 hr";
            }
            for (WebElement event : eventDurationList) {
                if (event.getText().contains(eventDuration)) {
                    isDurationPresent = true;
                    break;
                }
            }
        }
        return isEventPresent && isDurationPresent;
    }

    public void deleteEventsOfName(String eventName) {
        boolean eventsDeleted = true;
        while (eventsDeleted) {
            List<WebElement> eventNamesList = driver.findElements(By.xpath("//div[@data-component='sortable']//h2"));
            List<WebElement> settingOptions = driver.findElements(By.xpath("//div[@data-component='sortable']//h2/ancestor::div[@data-component='event-type-card-list']//button[@aria-expanded]"));

            if (eventNamesList.size() != settingOptions.size()) {
                continue;
            }
            eventsDeleted = false;
            for (int i = 0; i < eventNamesList.size(); i++) {
                try {
                    WebElement eventNameElement = eventNamesList.get(i);
                    WebElement settingOptionElement = settingOptions.get(i);

                    if (eventNameElement.getText().equals(eventName)) {
                        settingOptionElement.click();
                        WebElement deleteButton = settingOptionElement.findElement(By.xpath("//div[@data-component='event-type-card-list']//button[@aria-expanded]/following-sibling::div//button/div[text()='Delete']"));
                        deleteButton.click();
                        deleteConfirmBtn.click();
                        eventsDeleted = true;
                        break; // Exit loop to re-fetch elements since the DOM has changed
                    }
                } catch (Exception e) {
                    // If an element becomes stale, re-fetch elements and retry
                    eventsDeleted = true;
                    break;
                }
            }
        }
    }

    public boolean areEventsDeleted(String eventName) {
        for(WebElement event: eventNamesList){
            System.out.println("Event Name: "+ event.getText());
            if(event.getText().equals(eventName)){
                return false;
            }
        }
        return true;
    }
}
