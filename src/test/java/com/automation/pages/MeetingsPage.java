package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class MeetingsPage extends BasePage {

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

        String userHome = System.getProperty("user.home");
        Path downloadsPath = Paths.get(userHome, "Downloads");
        String filePath = downloadsPath.toString() + "\\events-export.zip";

        boolean isDownloaded = isFileDownloaded(filePath, 30, TimeUnit.SECONDS);
        File file = new File(filePath);

        if (isDownloaded) {
            return file.exists();
        } else {
            return false;
        }
    }

    public boolean isFileDownloaded(String filePath, long timeout, TimeUnit timeUnit) {
        File file = new File(filePath);
        long endTime = System.currentTimeMillis() + timeUnit.toMillis(timeout);

        while (System.currentTimeMillis() < endTime) {
            if (file.exists() && file.isFile() && file.length() > 0) {
                return true;
            }

            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                System.err.println("File check interrupted: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
