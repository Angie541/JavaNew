package webDriver.fourthProject_framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class HardcoreMainPage extends AbstractPage {
        @FindBy(css = "div.devsite-search-container")
        private WebElement searchButton;

        @FindBy(xpath = "//*[contains(@class, 'devsite-search-field devsite-search-query')]")
        private WebElement searchInput;

        @FindBy(xpath = "//div[@id='___gcse_0']//a[1]//b[text()='Google Cloud Platform Pricing Calculator']")
        private WebElement searchResult;

        public HardcoreMainPage(WebDriver driver) {
            super(driver);
        }

        public HardcoreMainPage openPage() {
            driver.get("https://cloud.google.com/");
            return this;
        }

        public HardcoreMainPage inputTheRequest(String string) {
            searchButton.click();
            searchInput.sendKeys(string);
            searchInput.sendKeys(Keys.ENTER);
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchResult));
            return this;
        }

        public HardcoreGoogleCloudPricingCalculatorPage clickOnSearchResult() {
            searchResult.click();
            return new HardcoreGoogleCloudPricingCalculatorPage(driver);
        }
    }