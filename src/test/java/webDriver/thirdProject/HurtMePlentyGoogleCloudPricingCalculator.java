package webDriver.thirdProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HurtMePlentyGoogleCloudPricingCalculator extends HurtMePlenty{
    public WebDriver driver;
    public HurtMePlentyGoogleCloudPricingCalculator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[contains(@id, 'input-0')]")
    private WebElement input;

    public void clickOnInput() {
        input.click();
    }

    @FindBy(xpath = "//*[@id='ul-0']/li[1]/md-autocomplete-parent-scope/span")
    private WebElement computeEngine;

    public void chooseASection() {
        computeEngine.click();
    }

    @FindBy(xpath = "//*[contains(@name,'quantity')][@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;

    public void chooseNumberOfInstances(String string) {
        numberOfInstances.click();
        numberOfInstances.sendKeys((string));
    }

    @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.os')][@role='listbox']")
    private WebElement operatingSystemAndSoftwareDropdownMenu;

    public void openOperatingSystemDropDownMenu() {
        operatingSystemAndSoftwareDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'free')] ")
    private WebElement operatingSystemAndSoftware;

    public void chooseOperatingSystemAndSoftware() {
        operatingSystemAndSoftware.click();
    }

    @FindBy(xpath = "//*[contains(@aria-label,'VM Class: Regular')]")
    private WebElement machineClassDropdownMenu;

    public void openMachineClassDropdownMenu() {
        machineClassDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'regular')][@id='select_option_77']")
    private WebElement machineClass;

    public void chooseMachineClass() {
        machineClass.click();
    }

    @FindBy(xpath = "//*[contains(@name,'series')][@placeholder='Series'][@ng-model='listingCtrl.computeServer.series']")
    private WebElement seriesDropdownMenu;

    public void openSeriesDropdownMenu() {
        seriesDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'n1')]")
    private WebElement series;

    public void chooseSeries() {
        series.click();
    }

    @FindBy(xpath = "//*[contains(@placeholder,'Instance type')][@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeDropdownMenu;

    public void openMachineTypeDropdownMenu() {
        machineTypeDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8')]")
    private WebElement machineType;

    public void chooseMachineType() {
        machineType.click();
    }

    @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.addGPUs')]")
    private WebElement checkboxAddGPUs;

    public void clickOnCheckboxAddGPUs() {
        checkboxAddGPUs.click();
    }

    @FindBy(xpath = "//*[contains(@placeholder,'Number of GPUs')][@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropdownMenu;

    public void openNumberOfGPUsDropdownMenu() {
        numberOfGPUsDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'1')][@ng-value='item.value'] [@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']")
    private WebElement numberOfGPUs;

    public void chooseNumberOfGPUs() {
        numberOfGPUs.click();
    }

    @FindBy(xpath = "//*[contains(@placeholder,'GPU type')][@ng-model='listingCtrl.computeServer.gpuType'] ")
    private WebElement typeOfGPUsDropdownMenu;

    public void openTypeOfGPUsDropdownMenu() {
        typeOfGPUsDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'NVIDIA_TESLA_V100')]")
    private WebElement typeOfGPUs;

    public void chooseTypeOfGPUs() {
        typeOfGPUs.click();
    }

    @FindBy(xpath = "//*[contains(@placeholder,'Local SSD')] [@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdownMenu;

    public void openLocalSSDDropdownMenu() {
        localSSDDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@ng-value,'item.value')][@value='24']")
    private WebElement localSSD;

    public void chooseLocalSSD() {
        localSSD.click();
    }

    @FindBy(xpath = "//*[contains(@placeholder,'Datacenter location')][@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdownMenu;

    public void openDatacenterLocationDropdownMenu() {
        datacenterLocationDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@value,'europe-west3')][@ng-repeat='item in listingCtrl.fullRegionList'][@id='select_option_204']")
    private WebElement datacenterLocation;

    public void chooseDatacenterLocation() {
        datacenterLocation.click();
    }

    @FindBy(xpath = "//*[contains(@aria-label,'Committed usage: None')][@ng-model='listingCtrl.computeServer.cud']")
    private WebElement commitedUsageDropdownMenu;

    public void openCommitedUsageDropdownMenu() {
        commitedUsageDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@ng-value,'1')][@id='select_option_95']")
    private WebElement commitedUsage;

    public void chooseCommitedUsage() {
        commitedUsage.click();
    }

    @FindBy(xpath = "//*[contains(@class,'md-raised md-primary cpc-button md-button md-ink-ripple')][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);'] [@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    public void addToEstimate() {
        addToEstimateButton.click();
    }
}