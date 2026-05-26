package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void load(String url) {
        driver.get(url);
        System.out.println("Navigated to: " + driver.getCurrentUrl());
    }

}
