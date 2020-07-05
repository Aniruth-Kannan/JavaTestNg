package com.commonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.BaseClassFinder;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class commonMethods extends base implements com.demoRegister.pages.demoRegister_locators {

    static Logger logger = LogManager.getLogger(BaseClassFinder.class.getName());
    static base base = new base();

    static WebDriver driver = null;
    private static String baseWindow = null;

    //@Given("^Customer launches browser with \\\"(.*)\\\" and url \\\"(.*)\\\" with security type \\\"(.*)\\\"$")
    public static void openUrl(WebDriver driver, String url, boolean securityType) {
        if (securityType) {
            url = "https://" + url;
        } else {
            url = "http://" + url;
        }
        com.commonMethods.base.driver.get(url);
        logger.info("Opening url: " + url);
        com.commonMethods.base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Expected url: " + url + " Actual Url: " + driver.getCurrentUrl());
        Assert.assertTrue(url.equals(driver.getCurrentUrl()));
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> TO CLICK AN ELEMENT </h1>
     *  <p> Pass the driver, elementLocator</p>
     */
    public static void clickElement(WebDriver driver, By elementLocator) {
        WebElement el = null;
        boolean status = false;
        try {
            returnWebelement(driver, elementLocator).click();
        } catch (ElementClickInterceptedException ex) {
            logger.error("Element with locator: " + elementLocator + " is not displayed on Page");
            System.exit(1);
        }
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> TO TYPE A TEXT IN A TEXT BOX </h1>
     *  <p> Pass the driver, elementLocator, Text </p>
     */
    public static void typeTextInTextBox(WebDriver driver, By elementLocator, String text) {
        returnWebelement(driver, elementLocator).sendKeys(text);
    }

    public static void checkElementIsPresent(WebDriver driver, By elementLocator) {
        boolean status = false;
        Assert.assertTrue(returnWebelement(driver, elementLocator).isDisplayed());
    }

    public static void checkTextIspresent(WebDriver driver, By elementLocator, String expectedText) {
        String textOfElement = returnWebelement(driver, elementLocator).getText();
        Assert.assertTrue(textOfElement.equals(expectedText));
    }

    public static String returnTextOfElement(WebDriver driver, By elementLocator) {
        String textOfElement = returnWebelement(driver, elementLocator).getText();
        return textOfElement;
    }

    public static void verifyTextInField(WebDriver driver, By elementLocator, String expectedText) {
        String textOfElement = returnWebelement(driver, elementLocator).getText();
        Assert.assertTrue(textOfElement.equals(expectedText));
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> TO SELECT AN ITEM IN DROPDOWN</h1>
     *  <p> Pass the driver, dropdownLocator, text of the element to be selected in dropdown</p>
     */
    public static void selectElementByName(WebDriver driver, By selectLocator, String name) {
        Select sl = new Select(returnWebelement(driver, selectLocator));
        try {
            sl.selectByVisibleText(name);
        } catch (NoSuchElementException e) {
            logger.error("[[TEST DATA ISSUE]] No element with locator name " + name + "  is found on page failed with exception" + e.getMessage());
        }
    }

    public static void waitForElement(WebDriver driver, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(com.commonMethods.base.driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> RETURNS THE WEBELEMT BY CONSUMING A BY</h1>
     *  <p> Pass the driver, element Locator</p>
     */
    public static WebElement returnWebelement(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = null;
        try {
            el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            logger.info("Element with locator: " + element + " is found in page ");
        } catch (NoSuchElementException e) {
            logger.error("Element with locator: " + element + " is not displayed on Page");
            System.exit(1);
        }
        logger.info("Returning WebElemen with loc: " + element);
        return el;
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> GENERATES A RANDOM 10 DIGIT PHONE NO AND RETURNS IT IN STRING FORMAT</h1>
     */
    public static String generateRandomPhoneNo() {
        String randomPhoneNo = null;
        Random rand = new Random();
        double randomNo1 = (Math.random() * (900000 - 100000)) + 100000;
        double randomNo2 = (Math.random() * (9000 - 1000)) + 1000;
        String stnum1 = (Double.toString(randomNo1)).replace(".", " ").split(" ")[0];
        String stnum2 = Double.toString(randomNo2).replace(".", " ").split(" ")[0];
        randomPhoneNo = stnum1 + stnum2;
        logger.info("Random Phone no generated: " + randomPhoneNo);
        return randomPhoneNo;
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> GENERATES A RANDOM EMAIL AND RETURNS IT IN STRING FORMAT</h1>
     */
    public static String generateRandomEmail() {
        String randomEmail = null;
        Random rand = new Random();
        double randomNo1 = (Math.random() * (90000 - 10000)) + 10000;
        String stnum1 = (Double.toString(randomNo1)).replace(".", " ").split(" ")[0];
        randomEmail = "abcd" + stnum1 + "@bh.test.com";
        logger.info("Random Email generated: " + randomEmail);
        return randomEmail;
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> VERIFIES THE EXPECTED URL CONTAINS THE CURRENT PAGE URL</h1>
     * <p> Pass the driver, Expected Url </p>
     */
    public static void verifyCurrentPageUrl(WebDriver driver, String expectedUrl) {
        boolean status = false;
        String actualUrl = driver.getCurrentUrl();
        logger.info("Current Url is: " + actualUrl);
        logger.info("Expected url: " + expectedUrl + " Actual Url: " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> VERIFIES THE CURRENT PAGE TITLE CONTAINS THE EXPECCTED TITLE</h1>
     * <p> Pass the driver, Expected title </p>
     */
    public static void verifyCurrentPageTitle(WebDriver driver, String expectedTitle) {
        boolean status = false;
        String actualTitle = driver.getTitle();
        logger.info("Current Page title is: " + actualTitle);
        logger.info("Expected Title: " + expectedTitle + " Actual Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> METHOD TO ACCEPT OR DISMISS THE ALERT</h1>
     * <p> Pass the driver, Pass "accept" / "dismiss" </p>
     */
    public static void alertAcceptOrDismiss(WebDriver driver, String frameAction) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        if ("accept".equalsIgnoreCase(frameAction)) {
            driver.switchTo().alert().accept();
        } else if ("dismiss".equalsIgnoreCase(frameAction)) {
            driver.switchTo().alert().dismiss();
        } else {
            logger.error("[[TEST SCRIPT ISSUE]] Invalid Frame action: " + frameAction + " is provided");
            System.exit(1);
        }
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> METHOD TO TYPE TEXT IN ALERT BOX ALERT</h1>
     * <p> Pass the driver, String to be typed in the alert text box</p>
     */
    public static void alertSendText(WebDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> METHOD TO SWITCH CONTROL TO A SPECIFIC TAB IN A BROWSER WINDOW</h1>
     * <p> Pass the driver, Tab no in Integer format</p>
     */
    public static void moveControlToTab(WebDriver driver, int tabNo) {
        tabNo = tabNo - 1;
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(tabNo));
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> METHOD TO SET BASE WINDOW TO A VARIABLE</h1>
     * <p> Pass the driver</p>
     */
    public static void setBaseWindow(WebDriver driver) {
        baseWindow = driver.getWindowHandle();
    }

    /*
     * @author Aniruth Kannan
     * @since 06/05/2020
     * <h1> METHOD TO TRAVERSE BACK TO BASE WINDOW/h1>
     * <p> Pass the driver</p>
     */
    public static void switchtoBaseWindow(WebDriver driver) {
        driver.switchTo().window(baseWindow);
    }

    //IFRAMES//

    public static void switchControlToIframeByName(WebDriver driver, By iframeLoc) {
        driver.switchTo().frame(returnWebelement(driver, iframeLoc));
        logger.info("Control switched to Iframe");
    }

    public static void verifyAttributeValue(WebDriver driver, By elementName, String attributeName, String expectedVale) {
        WebElement el = returnWebelement(driver, elementName);
        String actualAttribute = el.getAttribute("class");
        logger.info("Expected value of " + attributeName + " is: " + expectedVale + "  and the actual value is: " + actualAttribute);
        Assert.assertTrue(actualAttribute.equals(expectedVale));

    }

    public static void closeDriverConnection(WebDriver driver) {
        driver.quit();
    }
}
