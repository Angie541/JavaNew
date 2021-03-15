package webDriver.thirdProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HurtMePlentyGoogleCloudPricingCalculator extends AbstractPage {
    @FindBy(xpath = "//input[contains(@id, 'input-0')]")
    private WebElement input;

    @FindBy(xpath = "//*[@id='ul-0']/li[1]/md-autocomplete-parent-scope/span")
    private WebElement computeEngine;

    @FindBy(xpath = "//*[contains(@name,'quantity')][@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.os')][@role='listbox']")
    private WebElement operatingSystemAndSoftwareDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'free')] ")
    private WebElement operatingSystemAndSoftware;

    @FindBy(xpath = "//*[contains(@aria-label,'VM Class: Regular')]")
    private WebElement machineClassDropdownMenu;

    @FindBy(xpath = "//*[@id='select_container_83']//div[text()='Regular']")
    private WebElement machineClass;

    @FindBy(xpath = "//*[@id='select_value_label_61']")
    private WebElement seriesDropdownMenu;

    @FindBy(xpath = "//*[@id='select_option_190']")
    private WebElement series;

    @FindBy(xpath = "//*[@id='select_value_label_62']")
    private WebElement machineTypeDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8')]")
    private WebElement machineType;

    @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.addGPUs')]")
    private WebElement checkboxAddGPUs;

    @FindBy(xpath = "//*[contains(@placeholder,'Number of GPUs')][@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'1')][@ng-value='item.value'] [@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//*[contains(@placeholder,'GPU type')][@ng-model='listingCtrl.computeServer.gpuType'] ")
    private WebElement typeOfGPUsDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'NVIDIA_TESLA_V100')]")
    private WebElement typeOfGPUs;

    @FindBy(xpath = "//*[contains(@placeholder,'Local SSD')] [@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdownMenu;

    @FindBy(xpath = "//*[@value='2'][@id='select_option_383']")
    private WebElement localSSD;

    @FindBy(xpath = "//*[contains(@placeholder,'Datacenter location')][@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'europe-west3')][@id='select_option_207']")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//*[contains(@aria-label,'Committed usage: None')][@ng-model='listingCtrl.computeServer.cud']")
    private WebElement commitedUsageDropdownMenu;

    @FindBy(xpath = "//*[contains(@ng-value,'1')][@id='select_option_99']")
    private WebElement commitedUsage;

    @FindBy(xpath = "//*[contains(@class,'md-raised md-primary cpc-button md-button md-ink-ripple')][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);'] [@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    public HurtMePlentyGoogleCloudPricingCalculator(WebDriver driver) {
        super(driver);
    }

    public HurtMePlentyGoogleCloudPricingCalculator clickOnInput() {
        input.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseASection() {
        computeEngine.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseNumberOfInstances(String string) {
        numberOfInstances.click();
        numberOfInstances.sendKeys((string));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openOperatingSystemDropDownMenu() {
        operatingSystemAndSoftwareDropdownMenu.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseOperatingSystemAndSoftware() {
        operatingSystemAndSoftware.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openMachineClassDropdownMenu() {
        machineClassDropdownMenu.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseMachineClass() {
        machineClass.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openSeriesDropdownMenu() {
        seriesDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(series));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseSeries() {
        series.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openMachineTypeDropdownMenu() {
        machineTypeDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(machineType));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseMachineType() {
        machineType.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator clickOnCheckboxAddGPUs() {
        checkboxAddGPUs.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openNumberOfGPUsDropdownMenu() {
        numberOfGPUsDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(numberOfGPUs));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseNumberOfGPUs() {
        numberOfGPUs.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openTypeOfGPUsDropdownMenu() {
        typeOfGPUsDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(typeOfGPUs));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseTypeOfGPUs() {
        typeOfGPUs.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openLocalSSDDropdownMenu() {
        localSSDDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(localSSD));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseLocalSSD() {
        localSSD.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openDatacenterLocationDropdownMenu() {
        datacenterLocationDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(datacenterLocation));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseDatacenterLocation() {
        datacenterLocation.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator openCommitedUsageDropdownMenu() {
        commitedUsageDropdownMenu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(commitedUsage));
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator chooseCommitedUsage() {
        commitedUsage.click();
        return this;
    }

    public HurtMePlentyGoogleCloudPricingCalculator addToEstimate() {
        addToEstimateButton.click();
        return this;
    }
}