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

    @FindBy(xpath = "//div[@data-component='sortable']//div/a")
    List<WebElement> eventBookingPageLink;

    @FindBy(xpath = "//div[@data-component='sortable']//h2/ancestor::div[@data-component='event-type-card-list']//button[@aria-expanded]")
    List<WebElement> settingOptions;

    @FindBy(xpath = "//div[@data-calendly-label='left-nav-main-items-container']//span[contains(text(),'Availability')]")
    WebElement availabilityLink;

    @FindBy(xpath = "//div[@data-calendly-label='left-nav-main-items-container']//span[contains(text(),'Meetings')]")
    WebElement meetingsLink;

    @FindBy(id = "main-user-menu-toggle")
    WebElement profileIconBtn;

    @FindBy(xpath = "//button/span[text()='Yes']")
    WebElement deleteConfirmBtn;

    @FindBy(xpath = "//div[@id='main-user-menu']//div/a/div[contains(text(),'Profile')]")
    WebElement profileLink;

    static int noOfEventsBeforeDeletion;
    static int noOfEventsAfterDeletion;

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

        boolean eventsDeleted = false;
        while (!eventsDeleted) {
            List<WebElement> eventNamesList = driver.findElements(By.xpath("//div[@data-component='sortable']//h2"));
            List<WebElement> settingOptions = driver.findElements(By.xpath("//div[@data-component='sortable']//h2/ancestor::div[@data-component='event-type-card-list']//button[@aria-expanded]"));
            noOfEventsBeforeDeletion = eventNamesList.size();
            if (eventNamesList.size() != settingOptions.size()) {
                continue;
            }
            for (int i = 0; i < eventNamesList.size(); i++) {

                try {
                    WebElement eventNameElement = eventNamesList.get(i);
                    WebElement settingOptionElement = settingOptions.get(i);

                    if (eventNameElement.getText().equals(eventName)) {
                        settingOptionElement.click();
                        WebElement deleteButton = settingOptionElement.findElement(By.xpath("//div[@data-component='event-type-card-list']//button[@aria-expanded]/following-sibling::div//button/div[text()='Delete']"));
                        deleteButton.click();
                        deleteConfirmBtn.click();
                        actions.pause(2000).build().perform();
                        eventsDeleted = true;
                        System.out.println(eventNamesList.size());
                        break;
                    }
                } catch (Exception e) {
                    eventsDeleted = true;
                    break;
                }
            }
        }
    }

    public boolean areEventsDeleted(String eventName) {
        List<WebElement> eventNamesList = driver.findElements(By.xpath("//div[@data-component='sortable']//h2"));
        noOfEventsAfterDeletion = eventNamesList.size();
        return noOfEventsAfterDeletion < noOfEventsBeforeDeletion;

    }

    public void clickOnBookingEventLink(String eventName, String eventDuration) {
        for(int i = 0; i < eventBookingPageLink.size(); i++){
            if(eventNamesList.get(i).getText().equals(eventName) && eventDurationList.get(i).getText().contains(eventDuration)){
                eventBookingPageLink.get(i).click();
                break;
            }
        }
    }

    public void clickOnAvailabilityButton() {
        availabilityLink.click();
    }

    public void clickOnMeetingLink() {
        meetingsLink.click();
    }

    public void clickOnProfileIcon() {
        profileIconBtn.click();
    }

    public void clickOnProfileLink() {
        profileLink.click();
    }
}
