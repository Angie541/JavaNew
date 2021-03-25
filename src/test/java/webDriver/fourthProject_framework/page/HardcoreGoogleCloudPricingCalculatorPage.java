package webDriver.fourthProject_framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HardcoreGoogleCloudPricingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//input[contains(@id, 'input-0')]")
    private WebElement input;

    @FindBy(xpath = "//*[@id='ul-0']/li[1]/md-autocomplete-parent-scope/span")
    private WebElement computeEngine;

    @FindBy(xpath = "//*[contains(@name,'quantity')][@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.os')][@role='listbox']")
    private WebElement operatingSystemAndSoftwareDropdownMenu;

    @FindBy(xpath = "//*[contains(@aria-label,'VM Class: Regular')]")
    private WebElement machineClassDropdownMenu;

    @FindBy(xpath = "//*[@id='select_value_label_61']")
    private WebElement seriesDropdownMenu;

    @FindBy(xpath = "//*[@id='select_value_label_62']")
    private WebElement machineTypeDropdownMenu;

    @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.addGPUs')]")
    private WebElement checkboxAddGPUs;

    @FindBy(xpath = "//*[contains(@placeholder,'Number of GPUs')][@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropdownMenu;

    @FindBy(xpath = "//*[contains(@placeholder,'GPU type')][@ng-model='listingCtrl.computeServer.gpuType'] ")
    private WebElement typeOfGPUsDropdownMenu;

    @FindBy(xpath = "//*[contains(@placeholder,'Local SSD')] [@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdownMenu;

    @FindBy(xpath = "//*[contains(@placeholder,'Datacenter location')][@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdownMenu;

    @FindBy(xpath = "//*[contains(@aria-label,'Committed usage: None')][@ng-model='listingCtrl.computeServer.cud']")
    private WebElement commitedUsageDropdownMenu;

    @FindBy(xpath = "//*[contains(@class,'md-raised md-primary cpc-button md-button md-ink-ripple')][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);'] [@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    public HardcoreGoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public HardcoreGoogleCloudPricingCalculatorPage switchToCalculator() {
        WebElement frame1 = driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(frame2);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage clickOnInput() {
        input.click();
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseASection() {
        computeEngine.click();
        return this;
    }

    private void selectMenuItem(String s) {
        String xpath = "//*[contains(@class, 'md-active') and @aria-hidden='false']//div[contains(text(), '%s')]";
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xpath, s)))).click();
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseNumberOfInstances(String number) {
        numberOfInstances.click();
        numberOfInstances.sendKeys(number);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseOperatingSystemAndSoftware(String operatingSystemAndSoftware) {
        operatingSystemAndSoftwareDropdownMenu.click();
        selectMenuItem(operatingSystemAndSoftware);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseMachineClass(String machineClass) {
        machineClassDropdownMenu.click();
        selectMenuItem(machineClass);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseSeries(String series) {
        seriesDropdownMenu.click();
        selectMenuItem(series);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseMachineType(String machineType) {
        machineTypeDropdownMenu.click();
        selectMenuItem(machineType);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage addGPUs() {
        checkboxAddGPUs.click();
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdownMenu.click();
        selectMenuItem(numberOfGPUs);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseTypeOfGPUs(String typeOfGPUs) {
        typeOfGPUsDropdownMenu.click();
        selectMenuItem(typeOfGPUs);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseLocalSSD(String localSSD) {
        localSSDDropdownMenu.click();
        selectMenuItem(localSSD);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdownMenu.click();
        selectMenuItem(datacenterLocation);
        return this;
    }

    public HardcoreGoogleCloudPricingCalculatorPage chooseCommitedUsage(String commitedUsage) {
        commitedUsageDropdownMenu.click();
        selectMenuItem(commitedUsage);
        return this;
    }

    public HardcoreEstimate addToEstimate() {
        addToEstimateButton.click();
        return new HardcoreEstimate(driver);
    }
}