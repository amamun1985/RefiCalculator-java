package command_providers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class BrowserAction {
    public WebDriver driver;

    public BrowserAction(WebDriver driver){
        this.driver=driver;
    }

    public BrowserAction openBrowser(String url){
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }
    public BrowserAction closeBrowser(){
        driver.quit();
        return this;
    }


 public String validateTitle(String s){
    return driver.getTitle();
}
}
