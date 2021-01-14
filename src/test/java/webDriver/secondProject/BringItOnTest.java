package webDriver.secondProject;

import org.openqa.selenium.By;
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
    
    public BringItOnTest(WebDriver driver) {
    }

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void checkingForDetails() {
        driver.get("https://pastebin.com");
        BringItOnPageElements pageElements = new BringItOnPageElements(driver);

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id, 'postform-text')]")));

        pageElements.inputNewPaste("git config --global user.name  \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" + "git push origin master --force");
        pageElements.openSyntaxHighlightingDropdownMenu();
        pageElements.chooseSyntaxHighlighting();
        pageElements.openPasteExpirationDropdownMenu();
        pageElements.choosePasteExpiration();
        pageElements.inputPasteName("how to gain dominance among developers");
        pageElements.createNewPasteButton();

        String extrasInTitle = " - Pastebin.com";
        String browserTitle = driver.getTitle();

        Assert.assertEquals(browserTitle, "how to gain dominance among developers" + extrasInTitle);

        Assert.assertEquals(driver.findElement(By.xpath("/html/body//ol")).getAttribute("class"), "bash");

        Assert.assertEquals(driver.findElement(By.xpath("/html/body//textarea")).getAttribute("value"),
                "git config --global user.name  \"New Sheriff in Town\"\n"
                        + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                        + "git push origin master --force");
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
        }
    }
