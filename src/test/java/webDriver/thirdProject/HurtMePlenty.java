package  webDriver.thirdProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HurtMePlenty {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void checkingForDetails() {
        driver.get("https://cloud.google.com/");

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.devsite-search-container")));

        HurtMePlentyMainPage elementsOfTheMainPage = new HurtMePlentyMainPage(driver);
        HurtMePlentyGoogleCloudPricingCalculator elementsOfGoogleCloudPricingCalculatorPage = new HurtMePlentyGoogleCloudPricingCalculator(driver);

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

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body//md-list-item[2]/div")));

        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[2]/div")).getText(), "VM class: regular");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[3]/div")).getText(), "Instance type: n1-standard-8");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[4]/div")).getText(), "Region: Frankfurt");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[5]/div")).getText(), "Total available local SSD space 24x375 GiB");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[6]/div")).getText(), "Commitment term: 1 Year");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//h2/b")).getText(), "Total Estimated Cost: USD 3,095.85 per 1 month");
    }

     @AfterMethod(alwaysRun = true)
     public void closeBrowser() {
        driver.quit();
        driver = null;
 }
}