package webDriver.fourthProject_framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.fourthProject_framework.model.FormParameters;
import webDriver.fourthProject_framework.service.*;

public class HardcoreGoogleCloudPricingCalculatorPage extends AbstractPage {
    FormParameters testFormParametrs = FillingInFormParameters.withOperatingSystemAndSoftware();

        @FindBy(xpath = "//input[contains(@id, 'input-0')]")
        private WebElement input;

        @FindBy(xpath = "//*[@id='ul-0']/li[1]/md-autocomplete-parent-scope/span")
        private WebElement computeEngine;

        @FindBy(xpath = "//*[contains(@name,'quantity')][@ng-model='listingCtrl.computeServer.quantity']")
        private WebElement numberOfInstances;

        @FindBy(xpath = "//*[contains(@ng-model,'listingCtrl.computeServer.os')][@role='listbox']")
        private WebElement operatingSystemAndSoftwareDropdownMenu;

        @FindBy(xpath = "//*[@id='select_option_67']/div[1]")
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

        public HardcoreGoogleCloudPricingCalculatorPage(WebDriver driver) {
            super(driver);
        }

        public HardcoreGoogleCloudPricingCalculatorPage clickOnInput() {
            input.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseASection() {
            computeEngine.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseNumberOfInstances(FormParameters formParameters) {
            numberOfInstances.click();
            numberOfInstances.sendKeys((formParameters.getNumberOfInstances()));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openOperatingSystemDropDownMenu() {
            operatingSystemAndSoftwareDropdownMenu.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseOperatingSystemAndSoftware() {
            operatingSystemAndSoftware.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openMachineClassDropdownMenu() {
            machineClassDropdownMenu.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseMachineClass() {
            machineClass.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openSeriesDropdownMenu() {
            seriesDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(series));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseSeries() {
            series.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openMachineTypeDropdownMenu() {
            machineTypeDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(machineType));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseMachineType() {
            machineType.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage clickOnCheckboxAddGPUs() {
            checkboxAddGPUs.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openNumberOfGPUsDropdownMenu() {
            numberOfGPUsDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(numberOfGPUs));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseNumberOfGPUs() {
            numberOfGPUs.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openTypeOfGPUsDropdownMenu() {
            typeOfGPUsDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(typeOfGPUs));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseTypeOfGPUs() {
            typeOfGPUs.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openLocalSSDDropdownMenu() {
            localSSDDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(localSSD));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseLocalSSD() {
            localSSD.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openDatacenterLocationDropdownMenu() {
            datacenterLocationDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(datacenterLocation));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseDatacenterLocation() {
            datacenterLocation.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage openCommitedUsageDropdownMenu() {
            commitedUsageDropdownMenu.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(commitedUsage));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage chooseCommitedUsage() {
            commitedUsage.click();
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage addToEstimate() {
            addToEstimateButton.click();
            return this;
        }
    }