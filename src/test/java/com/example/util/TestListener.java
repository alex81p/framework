package com.example.util;

import com.example.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {

    private final Logger log = LogManager.getRootLogger();
    private final String screenshotsFolder = ".//target/screenshots/";
    private final String screenshotFileExtension = ".png";
    private final String screenshotDateFormat = "uuuu-MM-dd_HH-mm-ss";

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot)DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    screenshotsFolder
                    + getCurrentTimeAsString() +
                    screenshotFileExtension));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(screenshotDateFormat);
        return ZonedDateTime.now().format(formatter);
    }
}
