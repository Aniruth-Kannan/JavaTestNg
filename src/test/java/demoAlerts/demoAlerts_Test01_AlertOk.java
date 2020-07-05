package demoAlerts;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoAlerts.pages.demoAlerts_page.*;

class demoAlerts_Test01_AlertOk {

    public static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public void verifyAlertWithOk(){
        commonMethods.openUrl(driver, "demo.automationtesting.in/Alerts.html",false);
        commonMethods.waitForElement(driver, tabClickToAlertOk);
        commonMethods.clickElement(driver,tabClickToAlertOk);
        commonMethods.checkElementIsPresent(driver,buttonClickToAlert);
        commonMethods.clickElement(driver,buttonClickToAlert);
        commonMethods.alertAcceptOrDismiss(driver,"accept");
    }

    @Test(priority = 1)
    public static void verifyAlertAcceptDismiss(){
        commonMethods.openUrl(driver,"demo.automationtesting.in/Alerts.html",false);
        commonMethods.waitForElement(driver,tabClickToAlertOk);
        commonMethods.clickElement(driver, TabClickToAlertOkCancel);
        commonMethods.checkElementIsPresent(driver,buttonClickToAlertOkCancel);
        commonMethods.clickElement(driver, buttonClickToAlertOkCancel);
        commonMethods.alertAcceptOrDismiss(driver,"accept");
        commonMethods.checkTextIspresent(driver,alertStatusText,"You pressed Ok");
    }

    @Test(priority = 2)
    public static void verifyTypeTextInAlert(){
        commonMethods.openUrl(driver,"demo.automationtesting.in/Alerts.html",false);
        commonMethods.waitForElement(driver,tabClickToAlertOk);
        commonMethods.clickElement(driver, TabClickToAlertTextBox);
        commonMethods.checkElementIsPresent(driver,buttonClickToAlertTextBox);
        commonMethods.clickElement(driver,buttonClickToAlertTextBox);
        commonMethods.alertSendText(driver,"Lenin");
        commonMethods.alertAcceptOrDismiss(driver,"accept");
        commonMethods.checkTextIspresent(driver,alertTextBoxStatus,"Hello Lenin How are you today");
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }


}
