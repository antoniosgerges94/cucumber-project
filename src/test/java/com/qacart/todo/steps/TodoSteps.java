package com.qacart.todo.steps;

import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.steps.factory.DriverFactory;
import com.qacart.todo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;


public class TodoSteps {

    WebDriver driver;

    @Given("User is at the todo page")
    public void user_is_at_the_todo_page() throws IOException {
        driver = DriverFactory.getDriver(); // fetch, don't create
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load(EnvUtils.getInstance().getURL() + "/login");
        loginPage.login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());
    }

    @When("User adds new todo page")
    public void user_adds_new_todo_page() {

        new TodoPage(driver).plusButtonClick();

        new NewTodoPage(driver).addTodo("Learn Cucumber");

    }

    @Then("Todo should be added correctly")
    public void todo_should_be_added_correctly() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toDoItem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='todo-item']")
                )
        );
        String actualText = new TodoPage(driver).getLastTodoText();
        Assert.assertEquals(actualText, "Learn Cucumber");
    }

}
