package  webDriver.firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICanWinPageElements {
    public WebDriver driver;

    @FindBy(xpath = "//*[contains(@id, 'postform-text')]")
    private WebElement newPasteInput;

    @FindBy(xpath = "//*[contains(@id, 'select2-postform-expiration-container')] [contains(text(), 'Never')]")
    private WebElement pasteExpirationSelector;

    @FindBy(xpath = "//*[contains(@class, 'select2-results__option')] [contains(text(), '10 Minutes')]")
    private WebElement pasteExpirationTenMinutes;

    @FindBy(xpath = "//*[contains(@id, 'postform-name')]")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//*[contains(@class, 'btn -big')]")
    private WebElement createNewPasteButton;

    public ICanWinPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputNewPaste(String string) {
        newPasteInput.sendKeys(string);
    }

    public void openMenuOfPasteExpiration() {
        pasteExpirationSelector.click();
    }

    public void choosePasteExpiration() {
        pasteExpirationTenMinutes.click();
    }

    public void inputPasteName() {
        pasteNameInput.sendKeys("helloweb");
    }

    public void createNewPaste() {
        createNewPasteButton.click();
    }
}