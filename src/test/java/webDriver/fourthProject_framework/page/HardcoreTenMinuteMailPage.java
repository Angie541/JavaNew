package webDriver.fourthProject_framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HardcoreTenMinuteMailPage extends AbstractPage{
    @FindBy(xpath = "//*[contains(@id, 'mail_address')]")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[contains(@id, 'mail_messages_content')]")
    private WebElement mailMessage;

    public HardcoreTenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public HardcoreTenMinuteMailPage copyMailAddress() {
        mailAddress.sendKeys(Keys.CONTROL, "C");
        return this;
    }

    public HardcoreTenMinuteMailPage openMailMessage() {
        mailMessage.click();
        return this;
    }
}
