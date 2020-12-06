package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActOn {
    public static BrowserAction browser(WebDriver driver){
        return new BrowserAction(driver);
    }
    public static ElementActions element(WebDriver driver, By locator){
        return new ElementActions(driver,locator);
    }
    public static WaitFor wait(WebDriver driver,By locator){

        return new WaitFor(driver,locator);
    }
}
