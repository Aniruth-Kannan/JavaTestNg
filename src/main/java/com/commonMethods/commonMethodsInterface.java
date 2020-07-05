package com.commonMethods;

import org.openqa.selenium.WebDriver;

public interface commonMethodsInterface {

    WebDriver invokeDriver();

    void openUrl(WebDriver driver, String url, boolean securityType);

    void closeDriverConnection(WebDriver driver);

}
