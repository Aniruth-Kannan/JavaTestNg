package com.demoDatePicker.page;

import org.openqa.selenium.By;

public interface demoDatePicker_Page {
    By datePickerDisabled = By.xpath("//img[contains(@src,'/calendar.gif')]");
    By datePickerDisabledYear = By.xpath("//span[@class='ui-datepicker-year']");
    By datePickerDisabledMonth = By.xpath("//span[@class='ui-datepicker-month']");

    By monthSelectDatePickerEnabled = By.xpath("//select[@title='Change the month']");
    By yearSelectDatePickerEnabled = By.xpath("//select[@title='Change the year']");

}
