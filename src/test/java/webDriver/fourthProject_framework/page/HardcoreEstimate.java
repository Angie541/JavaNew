package webDriver.fourthProject_framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public HardcoreEstimate switchToCalculator() {
        WebElement frame1 = driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(frame2);
        return this;
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

    public String getEstimateCost() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div//h2/b")));
        return driver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div//h2/b")).getText().substring(22,34);
    }
}
