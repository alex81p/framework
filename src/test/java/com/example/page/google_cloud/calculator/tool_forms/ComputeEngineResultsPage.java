package com.example.page.google_cloud.calculator.tool_forms;

import com.example.page.google_cloud.calculator.PricingCalculatorMainFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputeEngineResultsPage extends PricingCalculatorMainFrame {

    @FindBy(id = "email_quote")
    private WebElement eMailEstimateButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement eMailInput;

    @FindBy(xpath = "//button[normalize-space(text())='Send Email']")
    private WebElement sendEMailButton;

    public ComputeEngineResultsPage() {
        super();
        switchToCalculatorFrame();
    }

    public ComputeEngineResultsPage clickEMailEstimateButton() {
        waitUntilElementIsClickable(eMailEstimateButton).click();
        logger.info("Sent the calculation to e-mail");
        return this;
    }

    public ComputeEngineResultsPage inputEMail(String eMail) {
        waitUntilElementIsVisible(eMailInput).sendKeys(eMail);
        return this;
    }

    public ComputeEngineResultsPage clickSendEMailButton() {
        scrollIntoView(waitUntilElementIsClickable(sendEMailButton)).click();
        return this;
    }
}
