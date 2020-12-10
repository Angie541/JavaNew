package webDriver.fourthProject_framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.fourthProject_framework.test.HardcoreTests;

public class HardcoreTenMinuteMailPage {
    public WebDriver driver;
    public HardcoreTenMinuteMailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'mail_address')]")
    private WebElement mailAddress;

    public void copyMailAddress() {
        mailAddress.sendKeys(Keys.CONTROL, "C");
    }

    @FindBy(xpath = "//*[contains(@id, 'mail_messages_content')]")
    private WebElement mailMessage;

    public void openMailMessage() {
        mailMessage.click();
    }
}
