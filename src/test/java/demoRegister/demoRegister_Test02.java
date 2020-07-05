
package demoRegister;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoRegister.pages.demoRegister_locators.firstName;
import static com.demoRegister.pages.demoRegister_locators.refreshButton;

class demoRegister_Test02 {

    private static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public static void testDemoRegisterRefresh(){
        demoRegister_Steps.enterDetailsTodemoRegisterForm(driver);
        commonMethods.clickElement(driver, refreshButton);
        commonMethods.checkTextIspresent(driver,firstName,"");
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }


}
