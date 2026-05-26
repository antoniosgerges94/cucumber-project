package com.qacart.todo.steps.hooks;

import com.qacart.todo.steps.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void before() {
        driver = DriverFactory.initDriver();
    }

    @After
    public void after() {
        DriverFactory.quitDriver();
        driver.quit();
    }

}
