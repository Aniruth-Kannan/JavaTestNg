package demoDatePicker;

import com.commonMethods.commonMethods;
import com.demoDatePicker.method.demoDatePicker_Method;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demoDatePicker_Test01 {

    public static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver(){
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public void verifyDatePickerDisabled(){
        commonMethods.openUrl(driver, "demo.automationtesting.in/Datepicker.html",false);
        demoDatePicker_Method.selectDemoDatePickerDisabled(driver, 2021,11, 27);
    }

    @Test(priority = 1)
    public void verifyDatePickerEnabled(){
        demoDatePicker_Method.selectDemoDatePickerEnabled(driver, "September","2025", "11");
    }

    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }
}
