package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final void enterEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='email']"))
        );
        email.sendKeys("test@example.com");
    }

    private final void enterPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='password']"))
        );
        password.sendKeys("Test1234");
    }

    private final void ClickOnLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement login = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='submit']"))
        );
        login.click();
    }

    public  final void login(String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='email']"))
        );
        emailField.sendKeys(email);

        driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-testid='submit']")).click();
    }

}
