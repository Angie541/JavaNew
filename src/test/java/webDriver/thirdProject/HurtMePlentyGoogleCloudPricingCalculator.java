package webDriver.thirdProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HurtMePlentyGoogleCloudPricingCalculator extends HurtMePlenty{
    public WebDriver driver;

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

    @FindBy(xpath = "//*[contains(@value,'regular')][@id='select_option_78']")
    private WebElement machineClass;

    @FindBy(xpath = "//*[contains(@name,'series')][@placeholder='Series'][@ng-model='listingCtrl.computeServer.series']")
    private WebElement seriesDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'n1')] [@class='ng-scope md-ink-ripple'] [@role='option']")
    private WebElement series;

    @FindBy(xpath = "//*[contains(@placeholder,'Instance type')][@ng-model='listingCtrl.computeServer.instance']")
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

    @FindBy(xpath = "//*[contains(@ng-value,'item.value')][@value='24']")
    private WebElement localSSD;

    @FindBy(xpath = "//*[contains(@placeholder,'Datacenter location')][@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdownMenu;

    @FindBy(xpath = "//*[contains(@value,'europe-west3')][@ng-repeat='item in listingCtrl.fullRegionList'][@id='select_option_205']")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//*[contains(@aria-label,'Committed usage: None')][@ng-model='listingCtrl.computeServer.cud']")
    private WebElement commitedUsageDropdownMenu;

    @FindBy(xpath = "//*[contains(@ng-value,'1')][@id='select_option_97']")
    private WebElement commitedUsage;

    @FindBy(xpath = "//*[contains(@class,'md-raised md-primary cpc-button md-button md-ink-ripple')][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);'] [@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    public HurtMePlentyGoogleCloudPricingCalculator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnInput() {
        input.click();
    }

    public void chooseASection() {
        computeEngine.click();
    }

    public void chooseNumberOfInstances(String string) {
        numberOfInstances.click();
        numberOfInstances.sendKeys((string));
    }

    public void openOperatingSystemDropDownMenu() {
        operatingSystemAndSoftwareDropdownMenu.click();
    }

    public void chooseOperatingSystemAndSoftware() {
        operatingSystemAndSoftware.click();
    }

    public void openMachineClassDropdownMenu() {
        machineClassDropdownMenu.click();
    }

    public void chooseMachineClass() {
        machineClass.click();
    }

    public void openSeriesDropdownMenu() {
        seriesDropdownMenu.click();
    }

    public void chooseSeries() {
        series.click();
    }

    public void openMachineTypeDropdownMenu() {
        machineTypeDropdownMenu.click();
    }

    public void chooseMachineType() {
        machineType.click();
    }

    public void clickOnCheckboxAddGPUs() {
        checkboxAddGPUs.click();
    }

    public void openNumberOfGPUsDropdownMenu() {
        numberOfGPUsDropdownMenu.click();
    }

    public void chooseNumberOfGPUs() {
        numberOfGPUs.click();
    }

    public void openTypeOfGPUsDropdownMenu() {
        typeOfGPUsDropdownMenu.click();
    }

    public void chooseTypeOfGPUs() {
        typeOfGPUs.click();
    }

    public void openLocalSSDDropdownMenu() {
        localSSDDropdownMenu.click();
    }

    public void chooseLocalSSD() {
        localSSD.click();
    }

    public void openDatacenterLocationDropdownMenu() {
        datacenterLocationDropdownMenu.click();
    }

    public void chooseDatacenterLocation() {
        datacenterLocation.click();
    }

    public void openCommitedUsageDropdownMenu() {
        commitedUsageDropdownMenu.click();
    }

    public void chooseCommitedUsage() {
        commitedUsage.click();
    }

    public void addToEstimate() {
        addToEstimateButton.click();
    }
}
