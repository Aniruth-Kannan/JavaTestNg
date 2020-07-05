package com.demoRegister.methods;

import com.commonMethods.base;
import com.commonMethods.commonMethods;
import com.demoRegister.pages.demoRegister_locators;
import org.openqa.selenium.WebDriver;

public class demoRegister_Steps implements com.demoRegister.pages.demoRegister_locators {

    static commonMethods commonMethods = new commonMethods();
    static demoRegister_locators demoRegister_locators = new demoRegister_Steps();
    static demoRegister_Steps demoRegister_Steps = new demoRegister_Steps();
    static WebDriver driver = null;
    static String url = "demo.automationtesting.in/Register.html";

    public static WebDriver invokeDriverFordemoRegister() {
        return driver = base.invokeDriver("chrome");
    }

    public static void enterDetailsTodemoRegisterForm(WebDriver driver) {
        com.commonMethods.commonMethods.openUrl(driver, url, false);
        com.commonMethods.commonMethods.typeTextInTextBox(driver, firstName, "Fname");
        com.commonMethods.commonMethods.typeTextInTextBox(driver, lastName, "Lname");
        com.commonMethods.commonMethods.typeTextInTextBox(driver, email, com.commonMethods.commonMethods.generateRandomEmail());
        com.commonMethods.commonMethods.typeTextInTextBox(driver, phone, com.commonMethods.commonMethods.generateRandomPhoneNo());
        com.commonMethods.commonMethods.clickElement(driver, genderMale);
        com.commonMethods.commonMethods.clickElement(driver, hobbiesCricket);
        com.commonMethods.commonMethods.selectElementByName(driver, country, "India");
        com.commonMethods.commonMethods.selectElementByName(driver, selectYear, "1990");
        com.commonMethods.commonMethods.selectElementByName(driver, selectMonth, "April");
        com.commonMethods.commonMethods.selectElementByName(driver, selectDate, "13");
        com.commonMethods.commonMethods.typeTextInTextBox(driver, fieldPassword, "Abcd@1234");
        com.commonMethods.commonMethods.typeTextInTextBox(driver, fieldConfirmPassword, "Abcd@1234");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeTest() {
        com.commonMethods.commonMethods.closeDriverConnection(driver);
    }


}
