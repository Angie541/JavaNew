package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BringItOnPageElements extends BringItOnTest{
    public WebDriver driver;
    public BringItOnPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'postform-text')]")
    private WebElement newPasteInput;

    public void inputNewPaste(String string) {
        newPasteInput.sendKeys(string);
    }

   @FindBy(xpath = "//*[contains(@id, 'select2-postform-format-container')] [text()='None']")
    private WebElement syntaxHighlightingDropdownMenu;

    public void openSyntaxHighlightingDropdownMenu() {
        syntaxHighlightingDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@class,'select2-results__option')] [text()='Bash']")
    private WebElement syntaxHighlighting;

    public void chooseSyntaxHighlighting() {
        syntaxHighlighting.click();
    }

    @FindBy(xpath = "//*[contains(@id,'select2-postform-expiration-container')] [text()='Never']")
    private WebElement pasteExpirationDropdownMenu;

    public void openPasteExpirationDropdownMenu() {
        pasteExpirationDropdownMenu.click();
    }

    @FindBy(xpath = "//*[contains(@class,'select2-results__option')] [text()='10 Minutes']")
    private WebElement pasteExpiration;

    public void choosePasteExpiration() {
        pasteExpiration.click();
    }

    @FindBy(xpath = "//*[contains(@id,'postform-name')]")
    private WebElement pasteNameInput;

    public void inputPasteName(String string) {
        pasteNameInput.sendKeys(string);
    }

    @FindBy(xpath = "//*[contains(@class, 'btn -big')]")
    private WebElement newPasteButton;

    public void createNewPasteButton() {
        newPasteButton.click();
    }
}