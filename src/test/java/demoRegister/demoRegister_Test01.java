package demoRegister;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoRegister.pages.demoRegister_locators.submitButton;
import static com.demoRegister.pages.demoRegister_locators.webTableHeader;

class demoRegister_Test01 {

   private static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public static void testDemoRegister(){
        demoRegister_Steps.enterDetailsTodemoRegisterForm(driver);
        commonMethods.clickElement(driver, submitButton);
        commonMethods.waitForElement(driver, webTableHeader);
        commonMethods.verifyCurrentPageUrl(driver,"/WebTable.html");
        commonMethods.verifyCurrentPageTitle(driver,"Web Table");
        commonMethods.checkElementIsPresent(driver,webTableHeader);
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }


}
