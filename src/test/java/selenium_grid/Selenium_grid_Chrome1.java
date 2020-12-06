package selenium_grid;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class Selenium_grid_Chrome1 {
    WebDriver driver;
    @Test
    public void runInChrome1() {

            driver=new TestEnvironment().selectTestEnvironment();
            //TestEnvironment.selectTestEnvironment();
            driver.get("https://www.mortgagecalculator.org/");
            System.out.println(driver.getTitle());
            driver.quit();
     }
}
