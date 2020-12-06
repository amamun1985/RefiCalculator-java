package automation001;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TitleValidationRefi {

    WebDriver driver;
    @Test
    public void validateTitle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
      ActOn.browser(driver).validateTitle("Mortgage Calculator");
      ActOn.browser(driver).closeBrowser();
    }
}
