package pageObjectModel;


import command_providers.ActOn;
import command_providers.AssertThat;
import command_providers.WaitExplicit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Refi_Calculate extends NavigationBar {
    private final By setHomeValue = By.id("HomeValue");
    private final By setDownPayment  = By.id("Down");
    private final By loanTerm  = By.name("Length");
    private final By interestRate  = By.name("Interest3");
    private final By calculateButton =By.name("calculate");
    private final By monthlyPayment = By.xpath("//*[@id='analysisDiv']/table[3]//td[2][text()='$2,513.74']");
    private final By clickLogoHome = By.xpath("//a/img[@alt='Logo']");
    public Refi_Calculate(WebDriver driver) {
        super(driver);
    }
    public Refi_Calculate homeValue(String value){
        WaitExplicit.waitFor(driver,setHomeValue).waitForElementToVisible();
        ActOn.element(driver,setHomeValue).setValue(value);
        return this;
    }
    public Refi_Calculate downPayment(String value){
        ActOn.element(driver,setDownPayment).setValue(value);
        return this;
    }
    public Refi_Calculate loanLenght(String value){
        ActOn.element(driver,loanTerm).setValue(value);
        return this;
    }
    public Refi_Calculate interestValue(String value){
        ActOn.element(driver,interestRate).setValue(value);
        return this;
    }
    public Refi_Calculate enterCalculateButton(){
        ActOn.element(driver,calculateButton).click();
        return this;
    }

    public Refi_Calculate priceVal(String totalMonthlyPayment){
       // LOGGER.info("expected total monthly payment"+totalMonthlyPayment);
        By monthlyPaymentLocator=By.xpath("//*[@id='analysisDiv']/table[3]//td[2][text()='"+totalMonthlyPayment+"']");
        AssertThat.elementAssertions(driver,monthlyPaymentLocator).elementExist();
        return this;
    }
    public Home clickLogo(){
        ActOn.element(driver,clickLogoHome).click();
        return new Home(driver);
    }

}
