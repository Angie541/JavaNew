package webDriver.fourthProject_framework.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.fourthProject_framework.driver.DriverSingleton;
import webDriver.fourthProject_framework.page.HardcoreMainPage;
import webDriver.fourthProject_framework.page.HardcoreEstimate;
import webDriver.fourthProject_framework.page.HardcoreGoogleCloudPricingCalculatorPage;
import webDriver.fourthProject_framework.page.HardcoreTenMinuteMailPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HardcoreTests extends CommonConditions {

    @Test
    public void checkingForDetails() throws InterruptedException {

        driver.get("https://cloud.google.com/");

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.devsite-search-container")));

        HardcoreMainPage elementsOfTheMainPage = new HardcoreMainPage(driver);
        HardcoreGoogleCloudPricingCalculatorPage elementsOfGoogleCloudPricingCalculatorPage = new HardcoreGoogleCloudPricingCalculatorPage(driver);
        HardcoreEstimate elementsOfEstimate = new HardcoreEstimate(driver);
        HardcoreTenMinuteMailPage elementsOfTenMinuteMailPage = new HardcoreTenMinuteMailPage(driver);

        elementsOfTheMainPage.clickOnInputOfRequest();
        elementsOfTheMainPage.inputTheRequest("Google Cloud Platform Pricing Calculator");

        driver.navigate().to("https://cloud.google.com/products/calculator");

        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));

        WebElement frame1 = driver.findElement( By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement( By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(frame2);

        elementsOfGoogleCloudPricingCalculatorPage.clickOnInput();
        elementsOfGoogleCloudPricingCalculatorPage.chooseASection();

        elementsOfGoogleCloudPricingCalculatorPage.chooseNumberOfInstances("4");

        elementsOfGoogleCloudPricingCalculatorPage.openOperatingSystemDropDownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseOperatingSystemAndSoftware();

        elementsOfGoogleCloudPricingCalculatorPage.openMachineClassDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseMachineClass();

        elementsOfGoogleCloudPricingCalculatorPage.openSeriesDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseSeries();

        elementsOfGoogleCloudPricingCalculatorPage.openMachineTypeDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseMachineType();

        elementsOfGoogleCloudPricingCalculatorPage.clickOnCheckboxAddGPUs();

        elementsOfGoogleCloudPricingCalculatorPage.openNumberOfGPUsDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseNumberOfGPUs();

        elementsOfGoogleCloudPricingCalculatorPage.openTypeOfGPUsDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseTypeOfGPUs();

        elementsOfGoogleCloudPricingCalculatorPage.openLocalSSDDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseLocalSSD();

        elementsOfGoogleCloudPricingCalculatorPage.openDatacenterLocationDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseDatacenterLocation();

        elementsOfGoogleCloudPricingCalculatorPage.openCommitedUsageDropdownMenu();
        elementsOfGoogleCloudPricingCalculatorPage.chooseCommitedUsage();

        elementsOfGoogleCloudPricingCalculatorPage.addToEstimate();

        elementsOfEstimate.clickOnEmailEstimateButton();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to("https://10minutemail.com");
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@id, 'mail_address')]")));

        elementsOfTenMinuteMailPage.copyMailAddress();

        driver.switchTo().window(tabs.get(0));
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));

        WebElement zzz = driver.findElement( By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(zzz);

        WebElement ccc = driver.findElement( By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(ccc);
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@name, 'description')][@ng-model='emailQuote.user.email'][@type='email']")));

        elementsOfEstimate.inputEmailAddress();
        elementsOfEstimate.sendEmail();

        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver,1000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mail_messages_content']")));

        elementsOfTenMinuteMailPage.openMailMessage();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div[2]/div[6]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText(), "USD 3,095.85");
    }
}