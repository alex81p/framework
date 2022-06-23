package com.example.page.google_cloud.calculator;

import com.example.page.AbstractPage;
import com.example.page.google_cloud.calculator.tool_forms.ComputeEngineFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PricingCalculatorMainFrame extends AbstractPage {

    public ComputeEngineFormPage selectComputeEngine() {
        switchToCalculatorFrame();
        selectTool("Compute Engine");
        return new ComputeEngineFormPage();

    }
    private void selectTool(String tool) {
        waitUntilElementIsClickable(By.xpath(String.format("//md-pagination-wrapper//div[text()='%s']", tool))).click();
    }

    public void switchToCalculatorFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//article[@id='cloud-site']//iframe")));
        driver.switchTo().frame("myFrame");
    }

    public WebElement scrollIntoView(WebElement webElement) {
        int verticalPosition = webElement.getLocation().getY();
        driver.switchTo().defaultContent();
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(0,%s);", verticalPosition - 200));
        switchToCalculatorFrame();
        return webElement;
    }
}
