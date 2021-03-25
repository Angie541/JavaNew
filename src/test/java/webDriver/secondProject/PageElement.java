package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageElement extends AbstractPage {
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

    public PageElement(WebDriver driver) {
        super(driver);
    }

    public PageElement openPage() {
        driver.get("https://pastebin.com");
        return this;
    }

    public PageElement inputNewPaste(String string) {
        newPasteInput.sendKeys(string);
        return this;
    }

    public PageElement openSyntaxHighlightingDropdownMenu() {
        syntaxHighlightingDropdownMenu.click();
        return this;
    }

    public PageElement chooseSyntaxHighlighting() {
        syntaxHighlightingBash.click();
        return this;
    }

    public PageElement openPasteExpirationDropdownMenu() {
        pasteExpirationDropdownMenu.click();
        return this;
    }

    public PageElement choosePasteExpiration() {
        pasteExpirationTenMinutes.click();
        return this;
    }

    public PageElement inputPasteName(String string) {
        pasteNameInput.sendKeys(string);
        return this;
    }

    public PageResult createNewPaste() {
        newPasteButton.click();
        return new PageResult(driver);
    }
}