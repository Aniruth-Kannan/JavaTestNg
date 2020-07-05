package com.demoWindows.page;

import org.openqa.selenium.By;

public interface demoWindow_Page {

    By tabClickToTabbedWindows = By.xpath("//a[@class='analystic' and (text()='Open New Tabbed Windows ')]");
    By TabClickToSeperateWindows = By.xpath("//a[@class='analystic' and (text()='Open New Seperate Windows')]");
    By TabClickToMultipleWindows = By.xpath("//a[@class='analystic' and (text()='Open Seperate Multiple Windows')]");
    By buttonToTabbedWindows = By.xpath("//button[@class='btn btn-info' and (text()='    click   ')]");
    By buttonToSeperateWindows = By.xpath("//button[@class='btn btn-primary']");
    By buttonToMultipleWindows = By.xpath("//button[@class='btn btn-info' and (text()='click ')]");

    By secondTabHeader = By.xpath("//a[@class='navbar-brand']");
    By secondTabButtonSignIn = By.xpath("//button[@id='btn1']");
}
