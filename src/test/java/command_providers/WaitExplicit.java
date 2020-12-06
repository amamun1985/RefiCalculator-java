package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WaitExplicit {
    public static WaitFor waitFor(WebDriver driver, By locator){
        return new WaitFor(driver,locator);
    }
}
