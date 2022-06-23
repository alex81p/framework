package com.example.test;

import com.example.driver.DriverSingleton;
import com.example.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

@Listeners({TestListener.class})
public abstract class AbstractTest {

    protected WebDriver driver;
    protected final static String PASTE_FROM_CLIPBOARD = Keys.CONTROL + "v";

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    protected void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    protected void switchToTab(String handle) {
        driver.switchTo().window(handle);
    }

    protected String getCurrentTabHandle() {
        return driver.getWindowHandle();
    }
}
