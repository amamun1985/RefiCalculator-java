package automation001;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectModel.Refi_Calculate;
import utilities.ReadConfigFile;

import java.io.IOException;
import java.util.Properties;

public class RefiCalculator {
    private static final Logger LOGGER= LogManager.getLogger(RefiCalculator.class);

    WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        ReadConfigFile readConfigFiles=new ReadConfigFile();
        Properties prop= readConfigFiles.getPropertyValue();
        String url= prop.getProperty("URL");
        LOGGER.info("Url is:"+url);
        ActOn.browser(driver).openBrowser(url);
        System.out.println(url);

        /*ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/ ");
        LOGGER.info("This is for url");*/
    }
    @Test
    public void dataEnterRefinance(){
        new Refi_Calculate(driver)
                .mouseHover()
                .clickLink()
                .homeValue("500000")
                .downPayment("70000")
                .loanLenght("25")
                .interestValue("5")
                .enterCalculateButton()
                .priceVal("$2,513.74")
                .clickLogo();
}
@AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();
}
}
