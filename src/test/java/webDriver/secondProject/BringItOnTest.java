package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BringItOnTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkingForDetails() {
        String extrasInTitle = " - Pastebin.com";
        String paste = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" + "git push origin master --force";
        String pasteName = "how to gain dominance among developers";

        BringItOnResult pageElements = new BringItOnPageElements(driver)
                .openPage()
                .inputNewPaste(paste)
                .openSyntaxHighlightingDropdownMenu()
                .chooseSyntaxHighlighting()
                .openPasteExpirationDropdownMenu()
                .choosePasteExpiration()
                .inputPasteName(pasteName)
                .createNewPaste();

        new WebDriverWait(driver, 1000).until(ExpectedConditions.titleIs(pasteName + extrasInTitle));
        Assert.assertEquals(pageElements.getPasteName(), pasteName + extrasInTitle);
        Assert.assertEquals(pageElements.getSyntaxHighlighting(), "bash");
        Assert.assertEquals(pageElements.getPaste(), paste);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
         driver.quit();
         driver = null;
    }
}