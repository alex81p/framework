package com.example.page.yopmail;

import com.example.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InboxPage extends AbstractPage {

    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost:')]")
    private WebElement estimatedMonthlyCost;

    public InboxPage openEstimatedMonthlyCostLetter() {
        By estimatedMonthlyCostLetterLocator = By.xpath("//div[text()='Google Cloud Price Estimate']/ancestor::button");
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, Duration.ofSeconds(20),Duration.ofSeconds(3))
                .until(driver -> {
                    driver.switchTo().frame("ifinbox");
                    if (elementExists(estimatedMonthlyCostLetterLocator)) {
                        return driver.findElement(estimatedMonthlyCostLetterLocator);
                    }
                    driver.navigate().refresh();
                    return null;
                }).click();
        logger.info("Opened the e-mail");
        return this;
    }

    public String getEstimatedMonthlyCost() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");
        return estimatedMonthlyCost.getText();
    }
}
