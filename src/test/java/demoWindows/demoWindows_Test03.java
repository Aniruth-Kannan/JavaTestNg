package demoWindows;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoWindows.page.demoWindow_Page.*;

class demoWindows_Test03 {

    private static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public static void verifyControlToSecondBrowserWindow(){
        commonMethods.openUrl(driver,"demo.automationtesting.in/Windows.html",false);
        commonMethods.waitForElement(driver,buttonToTabbedWindows);
        commonMethods.checkElementIsPresent(driver,buttonToTabbedWindows);
        commonMethods.checkElementIsPresent(driver,TabClickToMultipleWindows);
        commonMethods.clickElement(driver,TabClickToMultipleWindows);
        commonMethods.checkElementIsPresent(driver,buttonToMultipleWindows);
        commonMethods.clickElement(driver,buttonToMultipleWindows);
        commonMethods.setBaseWindow(driver);
        commonMethods.moveControlToTab(driver,2);
        commonMethods.waitForElement(driver,secondTabButtonSignIn);
        commonMethods.verifyCurrentPageTitle(driver, "Index");
    }

    @Test(priority = 1)
    public static void verifyControlBackToBaseWindow(){
        commonMethods.switchtoBaseWindow(driver);
        commonMethods.waitForElement(driver,buttonToMultipleWindows);
        commonMethods.checkElementIsPresent(driver,buttonToMultipleWindows);
        commonMethods.verifyCurrentPageTitle(driver,"Frames & windows");
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }


}
