package  webDriver.firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWin {
    private WebDriver driver;
    
    @BeforeMethod(alwaysRun = true)
     public void browserSetup() {
        driver = new ChromeDriver();
    }
    
     @Test
      public void checkingForDetails() {
        driver.get("https://pastebin.com");
        ICanWinPageElements pageElements = new ICanWinPageElements(driver);

        pageElements.inputNewPaste("Hello from WebDriver");
        pageElements.openMenuOfPasteExpiration();
        pageElements.choosePasteExpiration();
        pageElements.inputPasteName();
        pageElements.createNewPaste();
     }

      @AfterMethod(alwaysRun = true)
       public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
