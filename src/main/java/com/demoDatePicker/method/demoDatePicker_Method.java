package com.demoDatePicker.method;

import com.commonMethods.commonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.demoDatePicker.page.demoDatePicker_Page.monthSelectDatePickerEnabled;
import static com.demoDatePicker.page.demoDatePicker_Page.yearSelectDatePickerEnabled;

public class demoDatePicker_Method {

    static com.commonMethods.commonMethods commonMethods = new commonMethods();
    WebDriver driver = null;

    public static void selectDemoDatePickerDisabled(WebDriver driver, int expectedYr, int expectedMonth, int expectedDate) {
        driver.findElement(By.xpath("//img[contains(@src,'/images/calendar.gif')]")).click();
        int actualYr = Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
        int actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
        System.out.println("Actual Year: " + actualYr + " Actual Month: " + actualMonth);
        if (actualYr < expectedYr) {
            while (actualYr != expectedYr) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                actualYr = Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
            }
            System.out.println("Actual Year: " + actualYr);
            actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
            while (actualMonth != expectedMonth) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
            }
            String locFormat = "//td[@data-handler='selectDay']/a[text()='" + expectedDate + "']";
            By dateLoc = By.xpath(String.format(locFormat));
            driver.findElement(dateLoc).click();
        } else if (actualYr > expectedYr) {
            while (actualYr != expectedYr) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                actualYr = Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
            }
            System.out.println("Actual Year: " + actualYr);
            actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
            while (actualMonth != expectedMonth) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
            }
            String locFormat = "//td[@data-handler='selectDay']/a[text()='" + expectedDate + "']";
            By dateLoc = By.xpath(String.format(locFormat));
            driver.findElement(dateLoc).click();
        } else if (actualYr == expectedYr) {
            if (actualMonth < expectedMonth) {
                while (actualMonth != expectedMonth) {
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                    actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
                }
                String locFormat = "//td[@data-handler='selectDay']/a[text()='" + expectedDate + "']";
                By dateLoc = By.xpath(String.format(locFormat));
                driver.findElement(dateLoc).click();
            } else if (actualMonth > expectedMonth) {
                while (actualMonth != expectedMonth) {
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                    actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
                }
                String locFormat = "//td[@data-handler='selectDay']/a[text()='" + expectedDate + "']";
                By dateLoc = By.xpath(String.format(locFormat));
                driver.findElement(dateLoc).click();
            } else if (actualMonth == expectedMonth) {
                String locFormat = "//td[@data-handler='selectDay']/a[text()='" + expectedDate + "']";
                By dateLoc = By.xpath(String.format(locFormat));
                driver.findElement(dateLoc).click();
            }
        }
        actualYr = Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
        actualMonth = convertMonthsToNumbers(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
        System.out.println("Actual Year: " + actualYr + " Actual Month: " + actualMonth);

    }

    public static int convertMonthsToNumbers(String monthName) {
        int monthNuber = 0;
        switch (monthName.toLowerCase()) {
            case "january": {
                monthNuber = 1;
            }
            break;
            case "february": {
                monthNuber = 2;
            }
            break;
            case "March": {
                monthNuber = 3;
            }
            break;
            case "april": {
                monthNuber = 4;
            }
            break;
            case "may": {
                monthNuber = 5;
            }
            break;
            case "june": {
                monthNuber = 6;
            }
            break;
            case "july": {
                monthNuber = 7;
            }
            break;
            case "august": {
                monthNuber = 8;
            }
            break;
            case "september": {
                monthNuber = 9;
            }
            break;
            case "october": {
                monthNuber = 10;
            }
            break;
            case "november": {
                monthNuber = 11;
            }
            break;
            case "december": {
                monthNuber = 12;
            }
            break;
            default: {
                monthNuber = 0;
            }
        }
        return monthNuber;
    }

    public static void selectDemoDatePickerEnabled(WebDriver driver, String expectedMonth, String expectedYr, String expectedDate) {
        driver.findElement(By.xpath("//input[@id='datepicker2']")).click();
        com.commonMethods.commonMethods.selectElementByName(driver, monthSelectDatePickerEnabled, expectedMonth);
        com.commonMethods.commonMethods.selectElementByName(driver, yearSelectDatePickerEnabled, expectedMonth);
        String dateFormatLoc = "//a[contains(@title,'Select') and (text()='" + expectedDate + "')]";
        By dateLoc = By.xpath(String.format(dateFormatLoc));
        driver.findElement(dateLoc).click();
    }
}
