package stepDefinition_cucumber;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps_cucumber {
    private static final By EnterEmail=By.id("ap_email");
    private static final By ClickContinue=By.id("continue");
    private static final By EnterPassword=By.id("ap_password");
    private static final By ClickOnSignInButton=By.id("signInSubmit");
    private static final By SeeHelloAbdullah=By.xpath("//*[@id='nav-link-accountList']/div/span[text()='Hello, Abdullah']");


    private static Logger LOGGER= LogManager.getLogger(LoginSteps_cucumber.class);
    WebDriver driver;
    @Given("^a user is on the login page of amazon$")
    public void loginPage(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_AccountFlyout_signout%26signIn%3D1%26useRedirectOnSuccess%3D1");
        LOGGER.info("This is the user login page");

    }
    @When("^user enter username and click on Continue button$")
    public void userCredentialsEntering(){
        ActOn.element(driver,EnterEmail).setValue("rumamun01@gmail.com");
        ActOn.element(driver,ClickContinue).click();
        LOGGER.info("User has enter credential");
    }
    @And("^user enter password and click on sign-in button$")
    public void clickOnLoginButton(){
        ActOn.element(driver,EnterPassword).setValue("gsansmmb11");
        ActOn.element(driver,ClickOnSignInButton).click();
        LOGGER.info("User hit the login button");
    }
    @Then("^user is navigated to home page login of amazon$")
    public void validateHomePageOpenSuccessfully(){
      boolean signInNameDisplay=driver.findElement(SeeHelloAbdullah).isDisplayed();
        Assert.assertTrue("name of the person is displayed",signInNameDisplay);
        LOGGER.info("User is in the home page");
        ActOn.browser(driver).closeBrowser();
    }
}
