package webDriver.thirdProject;

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

public class HurtMePlentyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkingForDetails() {
        HurtMePlentyMainPage elementsOfTheMainPage = new HurtMePlentyMainPage(driver)
                .openPage()
                .clickOnInputOfRequest()
                .inputTheRequest("Google Cloud Platform Pricing Calculator")
                .clickOnSearchResult();

        WebElement frame1 = driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(frame2);

        HurtMePlentyGoogleCloudPricingCalculator elementsOfGoogleCloudPricingCalculatorPage = new HurtMePlentyGoogleCloudPricingCalculator(driver)
                .clickOnInput()
                .chooseASection()
                .chooseNumberOfInstances("4")
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

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body//md-list-item[2]/div")));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[2]/div")).getText(), "VM class: regular");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[3]/div")).getText(), "Instance type: n1-standard-8");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[4]/div")).getText(), "Region: Frankfurt");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[5]/div")).getText(), "Total available local SSD space 2x375 GiB");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[6]/div")).getText(), "Commitment term: 1 Year");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body//h2/b")).getText(), "Total Estimated Cost: USD 1,082.77 per 1 month");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}