package com.goibibo.pages;

import org.openqa.selenium.By;

public interface goIbIbo_HomePage {

    String Url = "www.goibibo.com/";
    By buttonRoundTrip = By.xpath("//span[@id='roundTrip']");
    By fieldFrom = By.xpath("//input[@id='gosuggest_inputSrc']");
    By fieldTo = By.xpath("//input[@id='gosuggest_inputDest']");

    By departureDate = By.xpath("//input[@id='departureCalendar']");
    By buttonSubmit = By.xpath("//button[@id='gi_search_btn']");

}
