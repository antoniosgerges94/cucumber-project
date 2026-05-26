package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait;

    private final void addNewTodo(String todoText) {
        WebElement newToDo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='newToDo']"))
        );
        newToDo.sendKeys(todoText);

        WebElement submitNewTask = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='submit-newTask']"))
        );
        submitNewTask.click();
    }

    public void addTodo(String item) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement todoInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='new-todo']")
                )
        );

        todoInput.sendKeys(item);

        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-testid='submit-newTask']")
                )
        );

        submitButton.click();
    }
}