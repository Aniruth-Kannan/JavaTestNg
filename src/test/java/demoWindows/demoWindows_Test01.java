package demoWindows;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoWindows.page.demoWindow_Page.*;

class demoWindows_Test01 {

    private static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public static void testDemoRegister(){
        commonMethods.openUrl(driver,"demo.automationtesting.in/Windows.html",false);
        commonMethods.waitForElement(driver,buttonToTabbedWindows);
        commonMethods.checkElementIsPresent(driver,buttonToTabbedWindows);
        commonMethods.clickElement(driver,tabClickToTabbedWindows);
        commonMethods.checkElementIsPresent(driver,buttonToTabbedWindows);
        commonMethods.clickElement(driver,buttonToTabbedWindows);
        commonMethods.setBaseWindow(driver);
        commonMethods.moveControlToTab(driver,2);
        commonMethods.waitForElement(driver,secondTabHeader);
        commonMethods.verifyCurrentPageTitle(driver, "Sakinalium | Home");
    }

    @Test(priority = 1)
    public static void verifyControlBackToBaseTab(){
        commonMethods.switchtoBaseWindow(driver);
        commonMethods.waitForElement(driver,buttonToTabbedWindows);
        commonMethods.checkElementIsPresent(driver,buttonToTabbedWindows);
        commonMethods.verifyCurrentPageTitle(driver,"Frames & windows");
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }


}
