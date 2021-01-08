package ax.generic;

import org.testng.annotations.DataProvider;

public class DataproviderClass {

    @DataProvider (name="ItemCategories")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "CSN" },
                { "SPN" }
               // { "Bhupesh" }
        };
    }

}
