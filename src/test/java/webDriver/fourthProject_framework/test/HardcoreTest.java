package webDriver.fourthProject_framework.test;

import org.openqa.selenium.*;
import webDriver.fourthProject_framework.model.FormParameters;
import webDriver.fourthProject_framework.page.*;
import org.testng.annotations.Test;
import webDriver.fourthProject_framework.service.FillingInFormParameters;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HardcoreTest extends CommonConditions {

    @Test
    public void checkForDetails() throws InterruptedException {
        FormParameters testFormParametrs = FillingInFormParameters.withFormParameters();
        HardcoreEstimate elements = new HardcoreMainPage(driver)
                .openPage()
                .inputTheRequest("Google Cloud Platform Pricing Calculator")
                .clickOnSearchResult()
                .switchToCalculator()
                .clickOnInput()
                .chooseASection()
                .chooseNumberOfInstances(testFormParametrs.getNumberOfInstances())
                .chooseOperatingSystemAndSoftware(testFormParametrs.getOperatingSystemAndSoftware())
                .chooseMachineClass(testFormParametrs.getMachineClass())
                .chooseSeries(testFormParametrs.getSeries())
                .chooseMachineType(testFormParametrs.getMachineType())
                .addGPUs()
                .chooseNumberOfGPUs(testFormParametrs.getNumberOfGPUs())
                .chooseTypeOfGPUs(testFormParametrs.getTypeOfGPUs())
                .chooseLocalSSD(testFormParametrs.getLocalSSD())
                .chooseDatacenterLocation(testFormParametrs.getDatacenterLocation())
                .chooseCommitedUsage(testFormParametrs.getCommitedUsage())
                .addToEstimate()
                .clickOnEmailEstimateButton();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        HardcoreTenMinuteMailPage elementsOfTenMinuteMailPage = new HardcoreTenMinuteMailPage(driver)
                .openPage()
                .copyMailAddress();

        driver.switchTo().window(tabs.get(0));

        elements.switchToCalculator();
        elements.inputEmailAddress();
        elements.sendEmail();
        String totalEstimatedCost = elements.getEstimateCost();

        driver.switchTo().window(tabs.get(1));

        elementsOfTenMinuteMailPage.waitForMessage();
        elementsOfTenMinuteMailPage.openMailMessage();

        assertThat(elementsOfTenMinuteMailPage.getEstimatedMonthlyCost(), is(equalTo(totalEstimatedCost)));
    }
}