package selenium_grid;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class Selenium_grid_Chrome2 {
    WebDriver driver;
    @Test
    public void runINChrome2() {
        driver=new TestEnvironment().selectTestEnvironment();
        //TestEnvironment.selectTestEnvironment();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());




    }
}
