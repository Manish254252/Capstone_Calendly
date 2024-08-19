package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class MeetingsPage extends BasePage{

    @FindBy(xpath = "//div/h1")
    WebElement meetingPageTitle;

    @FindBy(xpath = "//div/button//span[contains(text(),'Export')]")
    WebElement exportBtn;

    public boolean isMeetingsPageDisplayed() {
        return meetingPageTitle.getText().equals("Meetings");
    }

    public void clickOnExportBtn() {
        exportBtn.click();
    }

    public boolean isFileDownloaded() {
        String filePath = "C:\\Users\\280708\\Downloads\\events-export.zip";

        File file = new File(filePath);

        while (true){
            if(file.exists()){
                break;
            }
        }


        return file.exists();
    }
}
