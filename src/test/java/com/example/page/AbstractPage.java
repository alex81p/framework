package com.example.page;

import com.example.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();
    protected static final Duration TIMEOUT = Duration.ofSeconds(30);

    protected AbstractPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    protected WebElement waitUntilElementIsClickable(WebElement webElement) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitUntilElementIsClickable(By by) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitUntilElementIsVisible(WebElement webElement) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected boolean elementExists(By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
