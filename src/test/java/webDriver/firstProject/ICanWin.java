package  webDriver.firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICanWin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        ICanWinPageElements pageElements = new ICanWinPageElements(driver);

        pageElements.inputNewPaste("Hello from WebDriver");
        pageElements.openMenuOfPasteExpiration();
        pageElements.choosePasteExpiration();
        pageElements.inputPasteName();
        pageElements.createNewPaste();

        Thread.sleep(10000);
        driver.quit();
    }
}