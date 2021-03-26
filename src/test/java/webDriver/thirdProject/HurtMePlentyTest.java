package webDriver.thirdProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HurtMePlentyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkingForDetails() {
        HurtMePlentyGoogleCloudPricingCalculator elements = new HurtMePlentyMainPage(driver)
                .openPage()
                .inputTheRequest("Google Cloud Platform Pricing Calculator")
                .clickOnSearchResult()
                .switchToCalculator()
                .clickOnInput()
                .chooseASection()
                .chooseNumberOfInstances("4")
                .chooseOperatingSystemAndSoftware()
                .chooseMachineClass()
                .chooseSeries()
                .chooseMachineType()
                .addGPUs()
                .chooseNumberOfGPUs()
                .chooseTypeOfGPUs()
                .chooseLocalSSD()
                .chooseDatacenterLocation()
                .chooseCommitedUsage()
                .addToEstimate();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[2]/div")).getText(), "VM class: regular");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[3]/div")).getText(), "Instance type: n1-standard-8");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[4]/div")).getText(), "Region: Frankfurt");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[5]/div")).getText(), "Total available local SSD space 2x375 GiB");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body//md-list-item[6]/div")).getText(), "Commitment term: 1 Year");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body//h2/b")).getText(), "Total Estimated Cost: USD 1,082.77 per 1 month");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}