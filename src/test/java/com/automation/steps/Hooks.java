package com.automation.steps;



import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Hooks {

    WebDriver driver;


    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initConfig();
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
        ReportManager.initReport(scenario);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        if (scenario.isFailed()) {
            ReportManager.attachScreenShot();
        }
    }

//    @After
//    public void tearDown(Scenario scenario) {
//
//        if (scenario.isFailed()) {
//            ReportManager.attachScreenShot();
//        }
//        DriverManager.getDriver().quit();
//    }

}
