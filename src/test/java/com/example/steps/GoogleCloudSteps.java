package com.example.steps;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.page.google_cloud.GoogleCloudHomePage;
import com.example.page.google_cloud.calculator.tool_forms.ComputeEngineResultsPage;

public class GoogleCloudSteps {

    public static ComputeEngineResultsPage createComputeEngineCalculation(String searchRequest, String linkText,
                                                                   ComputeEngineForm computeEngineForm) {
        return new GoogleCloudHomePage()
                .openPage()
                .search(searchRequest)
                .openPricingCalculatorPage(linkText)
                .selectComputeEngine()
                .fillComputeEngineForm(computeEngineForm)
                .clickAddInstancesToEstimateButton()
                .switchToComputeEngineResults();
    }

    public static ComputeEngineResultsPage sendComputeEngineResultsToEMail(String eMail) {
        return new ComputeEngineResultsPage()
                .clickEMailEstimateButton()
                .inputEMail(eMail)
                .clickSendEMailButton();
    }
}
