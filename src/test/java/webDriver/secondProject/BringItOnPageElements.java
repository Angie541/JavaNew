package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BringItOnPageElements extends BringItOnTest{
    public WebDriver driver;
    
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
        PageFactory.initElements(this.driver, this);
    }

    public void inputNewPaste(String string) {
        newPasteInput.sendKeys(string);
    }

    public void openSyntaxHighlightingDropdownMenu() {
        syntaxHighlightingDropdownMenu.click();
    }

    public void chooseSyntaxHighlighting() {
        syntaxHighlightingBash.click();
    }

    public void openPasteExpirationDropdownMenu() {
        pasteExpirationDropdownMenu.click();
    }

    public void choosePasteExpiration() {
        pasteExpirationTenMinutes.click();
    }

    public void inputPasteName(String string) {
        pasteNameInput.sendKeys(string);
    }

    public BringItOnTest createNewPasteButton() {
        newPasteButton.click();
        return new BringItOnTest(driver);
    }
}
