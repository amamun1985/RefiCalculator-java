package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="SingleValue")
    public Object[][] storeSingleValue(){
        return new Object[][]{{"Abdullah"},{"Mohammad"},{"Hasan"},{"Abbus"}};
    }
    @DataProvider(name="MultipleValue")
    public Object[][]storeMultipleValue(){
        return new Object[][]{{"Momin","New York",33162},{"Raihan","Atlanta",11433},{"Akash","Miami",55426}};
    }
   /* @Test(dataProvider = "SingleValue")
    public void readSingleValue(String name){
        System.out.println("Single value is: "+name);
        //in this case I do not need to use loop.It automatically use loop for me
    }
    @Test(dataProvider ="MultipleValue")

    public void readMultipleValue(String name,String State){
        System.out.println("Multiple value name :"+name);
        System.out.println("Multiple State: ");
    }*/
    @DataProvider(name="RefiCalculator")
    public Object[][] storeRefiValue(){
        return new Object[][]{{"500000","70000","25","5","$2,513.74"}};
    }
}
