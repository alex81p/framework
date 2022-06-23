package com.example.test;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.page.yopmail.EMailGeneratorPage;
import com.example.page.yopmail.YOPMailHomePage;
import com.example.service.ComputeEngineFormCreator;
import com.example.service.TestDataReader;
import com.example.steps.GoogleCloudSteps;
import com.example.util.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardcore extends AbstractTest {
    private static final String SEARCH_REQUEST = "testData.searchRequest";
    private static final String LINK_TEXT = "testData.linkText";
    private static final String EXPECTED_RESULT = "testData.expectedResult";

    @Test
    public void verifyTotalEstimatedCost() {
        String searchRequest = TestDataReader.getTestData(SEARCH_REQUEST);
        String linkText = TestDataReader.getTestData(LINK_TEXT);
        String expectedResult = TestDataReader.getTestData(EXPECTED_RESULT);
        ComputeEngineForm computeEngineForm = ComputeEngineFormCreator.withDataFromProperty();
        GoogleCloudSteps.createComputeEngineCalculation(searchRequest, linkText, computeEngineForm);
        String calculatorTab = getCurrentTabHandle();
        openNewTab();
        new YOPMailHomePage()
                .openPage()
                .clickEMailGeneratorLink()
                .clickCopyToClipboardButton();
        String yopMailTab = getCurrentTabHandle();
        switchToTab(calculatorTab);
        GoogleCloudSteps.sendComputeEngineResultsToEMail(Utils.getTextFromClipboard());
        switchToTab(yopMailTab);
        String actualResult = new EMailGeneratorPage()
                .clickCheckInboxButton()
                .openEstimatedMonthlyCostLetter()
                .getEstimatedMonthlyCost();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
