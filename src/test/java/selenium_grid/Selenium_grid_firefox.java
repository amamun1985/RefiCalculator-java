package selenium_grid;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class Selenium_grid_firefox {
    WebDriver driver;
    @Test
    public void runInFirefox() {
        driver=new TestEnvironment().selectTestEnvironment();
        //TestEnvironment.selectTestEnvironment();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
