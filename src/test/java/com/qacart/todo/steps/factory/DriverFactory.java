package com.qacart.todo.steps.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        String browser = System.getProperty("browser", "EDGE").toUpperCase();

        WebDriver webDriver;

        switch (browser) {

            case "EDGE":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--disable-gpu");

                webDriver = new EdgeDriver(edgeOptions);
                break;

            case "FIREFOX":
                webDriver = new FirefoxDriver();
                break;

            case "CHROME":
                webDriver = new ChromeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.set(webDriver);
        return webDriver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}