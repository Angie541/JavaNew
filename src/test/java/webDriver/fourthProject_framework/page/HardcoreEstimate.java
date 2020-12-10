package webDriver.fourthProject_framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.fourthProject_framework.test.HardcoreTests;

public class HardcoreEstimate  {
    public WebDriver driver;
    public HardcoreEstimate(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'email_quote')]")
    private WebElement emailEstimateButton;

    public void clickOnEmailEstimateButton() {
        emailEstimateButton.click();
    }

    @FindBy(xpath = "//*[contains(@name, 'description')][@ng-model='emailQuote.user.email'][@type='email']")
    private WebElement emailInput;

    public void inputEmailAddress() {
        emailInput.click();
        emailInput.sendKeys(Keys.CONTROL, "V");
    }

    @FindBy(xpath = "//*[contains(@type, 'button')][@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public void sendEmail() {
        sendEmailButton.click();
    }

}
