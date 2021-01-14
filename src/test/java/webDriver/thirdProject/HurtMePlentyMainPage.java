package webDriver.thirdProject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HurtMePlentyMainPage extends  HurtMePlenty{
    public WebDriver driver;
    
    @FindBy(css = "div.devsite-search-container")
    private WebElement searchButton;
    
    @FindBy(xpath = "//*[contains(@class, 'devsite-search-field devsite-search-query')]")
    private WebElement searchInput;
    
    @FindBy(xpath = "//*[@id='___gcse_0']//div/div[5]/div[2]/div//div[1]/div[1]/div[1]/div[1]/div/a")
    private WebElement searchResult;
    
    public HurtMePlentyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnInputOfRequest() {
        searchButton.click();;
    }

    public void inputTheRequest(String string) {
        searchInput.sendKeys(string);
        searchInput.sendKeys(Keys.ENTER);
    }
    
      public  void clickOnSearchResult() {
        searchResult.click();
    }
}
