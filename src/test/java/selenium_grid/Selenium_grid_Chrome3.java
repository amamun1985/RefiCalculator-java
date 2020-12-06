package selenium_grid;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class Selenium_grid_Chrome3 {
    WebDriver driver;
    @Test
    public void runInChrome1() {

            driver=new TestEnvironment().selectTestEnvironment();
            //TestEnvironment.selectTestEnvironment();
            driver.get("https://www.facebook.com/");
            System.out.println(driver.getTitle());
            driver.quit();
     }
}
