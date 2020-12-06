package command_providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
    private static final Logger LOGGER= LogManager.getLogger(WaitFor.class);
    private WebDriver driver;
    private By locator;

    public WaitFor(WebDriver driver,By locator){
        this.driver=driver;
        this.locator=locator;
    }
    public WaitFor waitForElementToVisible(){
        WebDriverWait wait=new WebDriverWait(driver,15);
        LOGGER.info("Waiting for the locator "+locator+"to be visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }
}
