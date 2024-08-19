package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }


    public boolean isPresent(List<WebElement> eventNamesList) {
        try {
            wait.until(ExpectedConditions.visibilityOf(eventNamesList.get(0)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchTab() {
        List<String> windowIds = driver.getWindowHandles().stream().toList();
        String currentWindowId = windowIds.get(0);

        if (driver.getWindowHandle().equals(currentWindowId)) {
            driver.switchTo().window(windowIds.get(1));
        } else {
            driver.switchTo().window(windowIds.get(0));
        }

    }
}
