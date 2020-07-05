package com.demoRegister.pages;

import org.openqa.selenium.By;

public interface demoRegister_locators {

    By firstName = By.xpath("//input[@ng-model='FirstName']");
    By lastName = By.xpath("//input[@ng-model='LastName']");
    By email = By.xpath("//input[@ng-model='EmailAdress']");
    By phone = By.xpath("//input[@ng-model='Phone']");
    By genderMale = By.xpath("//input[@value='Male']");
    By genderFemale = By.xpath("//input[@value='FeMale']");
    By hobbiesCricket = By.xpath("//input[@value='Cricket']");
    By hobbiesMovies = By.xpath("//input[@value='Movies']");
    By hobbiesHockey = By.xpath("//input[@value='Hockey']");
    By country = By.xpath("//select[@ng-model='country']");
    By submitButton = By.xpath("//button[@id='submitbtn']");
    By refreshButton = By.xpath("//button[@id='Button1']");
    By selectYear = By.xpath("//select[@id='yearbox']");
    By selectMonth = By.xpath("//select[@ng-model='monthbox']");
    By selectDate = By.xpath("//select[@id='daybox']");
    By fieldPassword = By.xpath("//input[@id='firstpassword']");
    By fieldConfirmPassword = By.xpath("//input[@id='secondpassword']");
    By webTableHeader = By.xpath("//div[@class='ui-grid-header-cell-wrapper']");

}
