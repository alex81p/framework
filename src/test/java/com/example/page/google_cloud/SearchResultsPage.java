package com.example.page.google_cloud;

import com.example.page.AbstractPage;
import com.example.page.google_cloud.calculator.PricingCalculatorMainFrame;
import org.openqa.selenium.*;

public class SearchResultsPage extends AbstractPage {

    public PricingCalculatorMainFrame openPricingCalculatorPage(String linkText) {
            waitUntilElementIsClickable(By.linkText(linkText)).click();
            return new PricingCalculatorMainFrame();
    }
}
