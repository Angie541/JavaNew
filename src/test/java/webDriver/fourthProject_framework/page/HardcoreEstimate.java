package webDriver.fourthProject_framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HardcoreEstimate extends AbstractPage {
    @FindBy(xpath = "//*[contains(@id, 'email_quote')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//*[contains(@name, 'description')][@ng-model='emailQuote.user.email'][@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[contains(@type, 'button')][@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public HardcoreEstimate(WebDriver driver) {
        super(driver);
    }

    public HardcoreEstimate clickOnEmailEstimateButton() {
        emailEstimateButton.click();
        return this;
    }

    public HardcoreEstimate inputEmailAddress() {
        emailInput.click();
        emailInput.sendKeys(Keys.CONTROL, "V");
        return this;
    }

    public HardcoreEstimate sendEmail() {
        sendEmailButton.click();
        return this;
    }
}
