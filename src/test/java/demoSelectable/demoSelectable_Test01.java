package demoSelectable;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import com.demoSelectable.method.demoSelectable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoSelectable.page.demoSelectable_Page.*;

public class demoSelectable_Test01 {

    static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public static void verifySelectRepeatedlyDefaultFunctionality(){
        commonMethods.openUrl(driver, "demo.automationtesting.in/Selectable.html",false);
        commonMethods.waitForElement(driver, tabDefaultFunctionality);
        commonMethods.clickElement(driver,tabDefaultFunctionality);
        demoSelectable_Methods.clickRepeatedlyAndVerifySelection(driver,listDefaultFunctionalityCommonLoc);
    }

    @Test(priority = 1)
    public static void verifySelectRepeatedlySerialize(){
        commonMethods.waitForElement(driver, tabSerialize);
        commonMethods.clickElement(driver,tabSerialize);
        demoSelectable_Methods.clickRepeatedlyAndVerifySelectionText(driver,listSerizlieCommonLoc);
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }
}
