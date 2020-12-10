package webDriver.fourthProject_framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.fourthProject_framework.test.HardcoreTests;

public class HardcoreMainPage  {
    public WebDriver driver;
    public HardcoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "div.devsite-search-container")
    private WebElement searchButton;

    public void clickOnInputOfRequest() {
        searchButton.click();;
    }

    @FindBy(xpath = "//*[contains(@class, 'devsite-search-field devsite-search-query')]")
    private WebElement searchInput;

    public void inputTheRequest(String string) {
        searchInput.sendKeys(string);
        searchInput.sendKeys(Keys.ENTER);
    }
}