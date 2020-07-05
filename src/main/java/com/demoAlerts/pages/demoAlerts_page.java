package com.demoAlerts.pages;

import org.openqa.selenium.By;

public interface demoAlerts_page {

    By tabClickToAlertOk = By.xpath("//a[@class='analystic' and (text()='Alert with OK ')]");
    By TabClickToAlertOkCancel = By.xpath("//a[@class='analystic' and (text()='Alert with OK & Cancel ')]");
    By TabClickToAlertTextBox = By.xpath("//a[@class='analystic' and (text()='Alert with Textbox ')]");
    By buttonClickToAlert = By.xpath("//button[@class='btn btn-danger']");
    By buttonClickToAlertOkCancel = By.xpath("//button[@class='btn btn-primary']");
    By buttonClickToAlertTextBox = By.xpath("//button[@class='btn btn-info']");
    By alertStatusText = By.xpath("//p[@id='demo']");
    By alertTextBoxStatus = By.xpath("//p[@id='demo1']");

}
