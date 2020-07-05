package com.goibibo.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class goibibo_Methods {

    public static void datePickerDeparture(WebDriver driver, String dateToSelect) {
        driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
        List<WebElement> currentMonthLoc = new ArrayList<>();
        List<String> fullformat = new ArrayList<>();
        currentMonthLoc = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
        for (int i = 0; i < currentMonthLoc.size(); ) {
            fullformat.add(currentMonthLoc.get(i).getAttribute("aria-label"));
            if (fullformat.get(i).equals(dateToSelect)) {
                currentMonthLoc.get(i).click();
                break;
            } else if (i == (currentMonthLoc.size() - 1)) {
                driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
                i = 0;
                currentMonthLoc.clear();
                fullformat.clear();
                currentMonthLoc = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
            } else {
                i++;
            }
        }

    }

    public static void datePickerArrival(WebDriver driver, String dateToSelect) {
        driver.findElement(By.xpath("//input[@id='returnCalendar']")).click();
        List<WebElement> currentMonthLoc = new ArrayList<>();
        List<String> fullformat = new ArrayList<>();
        currentMonthLoc = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
        for (int i = 0; i < currentMonthLoc.size(); ) {
            fullformat.add(currentMonthLoc.get(i).getAttribute("aria-label"));
            if (fullformat.get(i).equals(dateToSelect)) {
                currentMonthLoc.get(i).click();
                break;
            } else if (i == (currentMonthLoc.size() - 1)) {
                driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
                i = 0;
                currentMonthLoc.clear();
                fullformat.clear();
                currentMonthLoc = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
            } else {
                i++;
            }
        }

    }

    public static void typeTextDeparture(WebDriver driver, String departureCity) {
        driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).sendKeys(departureCity);
        List<WebElement> suggestionsWebElements = new ArrayList<>();
        ArrayList<String> suggestionsText = new ArrayList<>();
        suggestionsWebElements = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']/li"));
        for (int i = 0; i < suggestionsWebElements.size(); i++) {
            suggestionsText.add(suggestionsWebElements.get(i).getText());
        }
        for (int i = 0; i < suggestionsWebElements.size(); ) {
            if (suggestionsText.get(i).contains(departureCity)) {
                suggestionsWebElements.get(i).click();
                break;
            } else {
                i++;
            }
        }

        System.out.println(suggestionsText);

    }

    public static void typeTextArrival(WebDriver driver, String arrivalCity) {
        driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).sendKeys(arrivalCity);
        List<WebElement> suggestionsWebElements = new ArrayList<>();
        ArrayList<String> suggestionsText = new ArrayList<>();
        suggestionsWebElements = driver.findElements(By.xpath("//ul[@id='react-autosuggest-1']/li"));
        for (int i = 0; i < suggestionsWebElements.size(); i++) {
            suggestionsText.add(suggestionsWebElements.get(i).getText());
        }
        for (int i = 0; i < suggestionsWebElements.size(); ) {
            if (suggestionsText.get(i).contains(arrivalCity)) {
                suggestionsWebElements.get(i).click();
                break;
            } else {
                i++;
            }
        }

        System.out.println(suggestionsText);

    }

    public static void selectLeastPrice(WebDriver driver) {
        List<WebElement> leastPriceLoc = driver.findElements(By.xpath("//span[@class='ico20 fb quicks']"));
        ArrayList<String> leastPriceText = new ArrayList<>();
        for (int i = 0; i < leastPriceLoc.size(); i++) {
            leastPriceText.add(leastPriceLoc.get(i).getText());
        }
        Collections.sort(leastPriceText);
        System.out.println(leastPriceText);
        String leastPrice = leastPriceText.get(0);
        System.out.println(leastPrice);
        By leastPriceFinalLoc = By.xpath(String.format("//span[@class='ico20 fb quicks' and (text()='" + leastPrice + "')]//ancestor::div[@class='clr']//input"));
        driver.findElement(leastPriceFinalLoc).click();
    }
}
