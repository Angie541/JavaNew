package webDriver.secondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

        PageResult pageElements = new PageElement(driver)
                .openPage()
                .inputNewPaste(paste)
                .openSyntaxHighlightingDropdownMenu()
                .chooseSyntaxHighlighting()
                .openPasteExpirationDropdownMenu()
                .choosePasteExpiration()
                .inputPasteName(pasteName)
                .createNewPaste();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageElements.getPasteName(), pasteName + extrasInTitle);
        softAssert.assertEquals(pageElements.getSyntaxHighlighting(), "bash");
        softAssert.assertEquals(pageElements.getPaste(), paste);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
         driver.quit();
         driver = null;
    }
}