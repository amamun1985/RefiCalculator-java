package dataDrivenTestForRefiCalculator;

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
import utilities.SqlConnector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class RefiCalculatorperameter {
    private static final Logger LOGGER= LogManager.getLogger(RefiCalculatorperameter.class);

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

        ResultSet resultSet= SqlConnector.readData("select * from monthlyprice");
        try{
            while (resultSet.next()){
                new Refi_Calculate(driver)
                        .mouseHover()
                        .clickLink()
                        .homeValue(resultSet.getString("homevalue"))
                        .downPayment(resultSet.getString("downpayment"))
                        .loanLenght(resultSet.getString("loanterm"))
                        .interestValue(resultSet.getString("interestrate"))
                        .enterCalculateButton()
                        .priceVal(resultSet.getString("totalmonthlypayment"))
                        .clickLogo();
            }
        }catch(SQLException e){
            LOGGER.error(e.getMessage());
        }


}
@AfterMethod
    public void closeBrowser(){
       ActOn.browser(driver).closeBrowser();
}
}
