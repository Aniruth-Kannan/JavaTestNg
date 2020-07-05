package com.demoSelectable.method;

import com.commonMethods.commonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.internal.BaseClassFinder;

import java.util.List;

import static com.demoSelectable.page.demoSelectable_Page.textVerify;

public class demoSelectable_Methods {
    static com.commonMethods.commonMethods commonMethods = new commonMethods();
    static Logger logger = LogManager.getLogger(BaseClassFinder.class.getName());

    public static void clickRepeatedlyAndVerifySelection(WebDriver driver, By elementName) {
        List<WebElement> locToSelectRepeatedly = driver.findElements(elementName);
        for (int i = 0; i < locToSelectRepeatedly.size(); i++) {
            locToSelectRepeatedly.get(i).click();
            WebElement el = locToSelectRepeatedly.get(i);
            String actualAttribute = el.getAttribute("class");
            logger.info("Expected value of " + "class" + " is: " + "ui-widget-content selected" + "  and the actual value is: " + actualAttribute);
            Assert.assertTrue(actualAttribute.equals("ui-widget-content selected"));
        }
    }

    public static void clickRepeatedlyAndVerifySelectionText(WebDriver driver, By elementName) {
        List<WebElement> locToSelectRepeatedly = driver.findElements(elementName);
        for (int i = 0; i < locToSelectRepeatedly.size(); i++) {
            String elText = locToSelectRepeatedly.get(i).getText().split("-")[1].trim();
            String elTextVerify = "You've selected: " + elText;
            logger.info("String to verify in field: " + elTextVerify);
            locToSelectRepeatedly.get(i).click();
            WebElement el = locToSelectRepeatedly.get(i);
            String actualAttribute = el.getAttribute("class");
            String actualVerifyText = com.commonMethods.commonMethods.returnWebelement(driver, textVerify).getText();
            logger.info("Actual Text in UI: " + actualVerifyText + " Expected verification text: " + elTextVerify);
            Assert.assertTrue(actualVerifyText.equals(elTextVerify));
        }
    }
}
