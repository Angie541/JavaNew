package webDriver.fourthProject_framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HardcoreTenMinuteMailPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@id, 'mail_address')]")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[contains(@id, 'mail_messages_content')]")
    private WebElement mailMessage;

    public HardcoreTenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public HardcoreTenMinuteMailPage openPage() {
        driver.get("https://10minutemail.com");
        return this;
    }

    public HardcoreTenMinuteMailPage copyMailAddress() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@id, 'mail_address')]")));
        mailAddress.sendKeys(Keys.CONTROL, "C");
        return this;
    }

    public HardcoreTenMinuteMailPage openMailMessage() {
        mailMessage.click();
        return this;
    }

    public HardcoreTenMinuteMailPage waitForMessage() {
        new WebDriverWait(driver, 10000).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mail_messages_content']//*[text()='Google Cloud Platform Price Estimate']")));
        return this;
    }

    public String getEstimatedMonthlyCost() {
        return driver.findElement(By.xpath("//*[@id='mobilepadding']/td/table/tbody/tr[2]/td[2]/h3")).getText();
    }
}