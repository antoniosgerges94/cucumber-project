package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    private final void welcome_message_should_be_displayed() throws InterruptedException {

        boolean isWelcomeDisplayed =
                driver.findElement(By.cssSelector("[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }

    private final void user_adds_new_todo_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement add = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='add']"))
        );
        add.click();
    }

    private final void todo_should_be_added_correctly() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toDoItem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='todo-item']")
                )
        );
        String actualText = toDoItem.getText();
        Assert.assertEquals(actualText, "Learn Cucumber");
    }

    public boolean isWelcomeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(                                          // ← add return here
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='welcome']")
                )
        ).isDisplayed();
    }

    public void plusButtonClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='add']")
        )).click();
    }

    public String getLastTodoText(){
        return driver.findElements(By.cssSelector("[data-testid='todo-item']")).get(0).getText();
    }

}
