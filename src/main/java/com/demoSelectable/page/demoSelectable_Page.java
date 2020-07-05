package com.demoSelectable.page;

import org.openqa.selenium.By;

public interface demoSelectable_Page {

    By tabDefaultFunctionality = By.xpath("//a[@class='analystic' and (text()='Default Functionality ')]");
    By tabSerialize = By.xpath("//a[@class='analystic' and (text()='Serialize ')]");

    By listDefaultFunctionalityCommonLoc = By.xpath("//div[@id='Default']//li[contains(@class,'ui-widget-content')]");
    By listSerizlieCommonLoc = By.xpath("//div[@id='Serialize']//li[contains(@class,'ui-widget-content')]/b");

    By textVerify = By.xpath("//div[@id='Serialize']//p[@id='feedback']");
}
