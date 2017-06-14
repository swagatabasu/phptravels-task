package com.blogspot.notes.automation.qa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import java.lang.InterruptedException;

public class Dropdown extends HTMLElement {

    public Dropdown(final WebDriver driver, final SearchBy elementSearchCriteria, final String elementValue) {
        super(driver, elementSearchCriteria, elementValue);
    }

    public void select(String text) throws Throwable{

        Select countrySelect = new Select(waitUntil(ExpectedConditions::elementToBeClickable));
        TimeUnit.SECONDS.sleep(2);
        countrySelect.selectByVisibleText(text);
    }
}
