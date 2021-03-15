package webDriver.fourthProject_framework.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.fourthProject_framework.model.*;
import webDriver.fourthProject_framework.page.*;
import org.testng.annotations.Test;
import webDriver.fourthProject_framework.service.*;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HardcoreTests extends CommonConditions {

    @Test
    public void checkingForDetails() throws InterruptedException {
        HardcoreMainPage elementsOfTheMainPage = new HardcoreMainPage(driver)
                .openPage()
                .clickOnInputOfRequest()
                .inputTheRequest("Google Cloud Platform Pricing Calculator")
                .clickOnSearchResult();

        WebElement frame1 = driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(frame2);

        FormParameters testFormParametrs = FillingInFormParameters.withNumberOfInstances();
        HardcoreGoogleCloudPricingCalculatorPage elementsOfGoogleCloudPricingCalculatorPage = new HardcoreGoogleCloudPricingCalculatorPage(driver)
                .clickOnInput()
                .chooseASection()
                .chooseNumberOfInstances(testFormParametrs)
                .openOperatingSystemDropDownMenu()
                .chooseOperatingSystemAndSoftware()
                .openMachineClassDropdownMenu()
                .chooseMachineClass()
                .openSeriesDropdownMenu()
                .chooseSeries()
                .openMachineTypeDropdownMenu()
                .chooseMachineType()
                .clickOnCheckboxAddGPUs()
                .openNumberOfGPUsDropdownMenu()
                .chooseNumberOfGPUs()
                .openTypeOfGPUsDropdownMenu()
                .chooseTypeOfGPUs()
                .openLocalSSDDropdownMenu()
                .chooseLocalSSD()
                .openDatacenterLocationDropdownMenu()
                .chooseDatacenterLocation()
                .openCommitedUsageDropdownMenu()
                .chooseCommitedUsage()
                .addToEstimate();

        HardcoreEstimate elementsOfEstimate = new HardcoreEstimate(driver)
                .clickOnEmailEstimateButton();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to("https://10minutemail.com");
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@id, 'mail_address')]")));

        HardcoreTenMinuteMailPage elementsOfTenMinuteMailPage = new HardcoreTenMinuteMailPage(driver)
                .copyMailAddress();

        driver.switchTo().window(tabs.get(0));
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));

        driver.switchTo().frame(frame1);
        driver.switchTo().frame(frame2);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@name, 'description')][@ng-model='emailQuote.user.email'][@type='email']")));

        elementsOfEstimate.inputEmailAddress();
        elementsOfEstimate.sendEmail();

        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 10000).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mail_messages_content']//*[text()='Google Cloud Platform Price Estimate']")));

        elementsOfTenMinuteMailPage.openMailMessage();

        assertThat(driver.findElement(By.xpath("//*[@id='mobilepadding']/td/table/tbody/tr[2]/td[2]/h3")).getText(), is(equalTo("USD 1,082.77")));
    }
}