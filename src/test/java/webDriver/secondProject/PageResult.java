package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageResult extends AbstractPage {
    @FindBy(xpath = "/html/body//textarea")
    private WebElement pasteArea;

    @FindBy(xpath = "/html/body//ol")
    private WebElement syntaxHighlighting;

    public PageResult(WebDriver driver) {
        super(driver);
    }

    public String getPaste() {
        return pasteArea.getAttribute("value");
    }

    public String getSyntaxHighlighting() {
        return syntaxHighlighting.getAttribute("class");
    }

    public String getPasteName() {
        return driver.getTitle();
    }
}
