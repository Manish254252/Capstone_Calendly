package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

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

    public void clickOnNewEventTypeButton() {
        newEventTypeButton.click();
    }

    public boolean isCreateBtnDisplayed() {
        return createBtn.isDisplayed();
    }

    public boolean isEventListedOnHomePage(String eventName, String eventDuration) {
        boolean isEventPresent = false;
        boolean isDurationPresent = false;

        if(isPresent(eventNamesList)){
            for(WebElement event : eventNamesList){
                if(event.getText().contains(eventName)){
                    isEventPresent = true;
                    break;
                }
            }
            if(eventDuration.equals("60 min")){
                eventDuration = "1 hr";
            }
            for(WebElement event: eventDurationList){
                if(event.getText().contains(eventDuration)){
                    isDurationPresent = true;
                    break;
                }
            }
        }
        return isEventPresent && isDurationPresent;
    }

    public void deleteEventsOfName(String eventName) {
            for(int i = 0; i < eventNamesList.size(); i++){
                System.out.println("inside for");
                if(eventNamesList.get(i).getText().equals(eventName)){
                    System.out.println("inside if");
                    settingOptions.get(i).click();
                    settingOptions.get(i).findElement(By.xpath("//div[@data-component='event-type-card-list']//button[@aria-expanded]/following-sibling::div//button/div[text()='Delete']")).click();
                    i = 0;
                }
        }
    }
}
