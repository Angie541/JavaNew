package  webDriver.firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ICanWinPageElements extends ICanWin{
    public WebDriver driver;
    public ICanWinPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'postform-text')]")
    private WebElement newPasteInput;

    public void inputNewPaste(String string) {
        newPasteInput.sendKeys(string);
    }

    @FindBy(xpath = "//*[contains(@id, 'select2-postform-expiration-container')] [contains(text(), 'Never')]")
    private WebElement pasteExpirationSelector;

    public void openMenuOfPasteExpiration() {
        pasteExpirationSelector.click();
    }

    @FindBy(xpath = "//*[contains(@class, 'select2-results__option')] [contains(text(), '10 Minutes')]")
    private WebElement pasteExpirationButton;

    public void choosePasteExpiration() {
        pasteExpirationButton.click();
    }

    @FindBy(xpath = "//*[contains(@id, 'postform-name')]")
    private WebElement pasteNameInput;

    public void inputPasteName() {
        pasteNameInput.sendKeys("helloweb");
    }

    @FindBy(xpath = "//*[contains(@class, 'btn -big')]")
    private WebElement createNewPasteButton;

    public void createNewPaste() {
        createNewPasteButton.click();
    }
}