package com.example.page.google_cloud.calculator;

import com.example.page.AbstractPage;
import com.example.page.google_cloud.calculator.tool_forms.ComputeEngineFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PricingCalculatorMainFrame extends AbstractPage {

    private final String toolLocator = "//md-pagination-wrapper//div[text()='%s']";
    private final String frameLocator = "//article[@id='cloud-site']//iframe";


    public ComputeEngineFormPage selectComputeEngine() {
        switchToCalculatorFrame();
        selectTool("Compute Engine");
        return new ComputeEngineFormPage();

    }
    private void selectTool(String tool) {
        waitUntilElementIsClickable(By.xpath(String.format(toolLocator, tool))).click();
    }

    public void switchToCalculatorFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath(frameLocator)));
        driver.switchTo().frame("myFrame");
    }

    public WebElement scrollIntoView(WebElement webElement) {
        int verticalPosition = webElement.getLocation().getY() - driver.manage().window().getSize().getHeight() / 2;
        driver.switchTo().defaultContent();
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(0,%s);", verticalPosition));
        switchToCalculatorFrame();
        return webElement;
    }
}
