package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BringItOnPageElements extends AbstractPage {
    @FindBy(xpath = "//*[contains(@id, 'postform-text')]")
    private WebElement newPasteInput;

    @FindBy(xpath = "//*[contains(@id, 'select2-postform-format-container')] [text()='None']")
    private WebElement syntaxHighlightingDropdownMenu;

    @FindBy(xpath = "//*[contains(@class,'select2-results__option')] [text()='Bash']")
    private WebElement syntaxHighlightingBash;

    @FindBy(xpath = "//*[contains(@id,'select2-postform-expiration-container')] [text()='Never']")
    private WebElement pasteExpirationDropdownMenu;

    @FindBy(xpath = "//*[contains(@class,'select2-results__option')] [text()='10 Minutes']")
    private WebElement pasteExpirationTenMinutes;

    @FindBy(xpath = "//*[contains(@id,'postform-name')]")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//*[contains(@class, 'btn -big')]")
    private WebElement newPasteButton;

    public BringItOnPageElements(WebDriver driver) {
        super(driver);
    }

    public BringItOnPageElements openPage() {
        driver.get("https://pastebin.com");
        return this;
    }

    public BringItOnPageElements inputNewPaste(String string) {
        newPasteInput.sendKeys(string);
        return this;
    }

    public BringItOnPageElements openSyntaxHighlightingDropdownMenu() {
        syntaxHighlightingDropdownMenu.click();
        return this;
    }

    public BringItOnPageElements chooseSyntaxHighlighting() {
        syntaxHighlightingBash.click();
        return this;
    }

    public BringItOnPageElements openPasteExpirationDropdownMenu() {
        pasteExpirationDropdownMenu.click();
        return this;
    }

    public BringItOnPageElements choosePasteExpiration() {
        pasteExpirationTenMinutes.click();
        return this;
    }

    public BringItOnPageElements inputPasteName(String string) {
        pasteNameInput.sendKeys(string);
        return this;
    }

    public BringItOnResult createNewPaste() {
        newPasteButton.click();
        return new BringItOnResult(driver);
    }
}